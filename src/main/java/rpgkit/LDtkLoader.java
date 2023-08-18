package rpgkit;

import rpgkit.entity.Entity;
import rpgkit.entity.Player;
import rpgkit.entity.item.Item;
import rpgkit.ldtk.*;
import rpgkit.ldtk.tile.Converter;
import rpgkit.ldtk.tile.TileProperties;
import rpgkit.managers.EntityManger;
import rpgkit.managers.TileManager;
import rpgkit.managers.TileSetManager;
import rpgkit.utils.Direction;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LDtkLoader {
    public static LDtkLoader loader;

    public void loadTilesets(LDtk ldtk) {
        TilesetDefinition[] tilesetDefinitions = ldtk.getDefs().getTilesets();
        for (TilesetDefinition tilesetDefinition : tilesetDefinitions) {
            TileSet tileSet = new TileSet(tilesetDefinition);
            TileSetManager.tileSets.add(tileSet);
        }
    }

    public Player loadPlayer(LDtk ldtk, EntityInstance entity, LayerInstance layer, Level level, EntityManger entityManger) {
        Player player = new Player(RPGKit.getInstance().keyHandler, entityManger);

        double[] playerPosition = getEntityPosition(entity, layer, level, ldtk.getWorldLayout());
        player.worldPosition[0] = playerPosition[0];
        player.worldPosition[1] = playerPosition[1];
//        get the player's screen position from the world position
        player.screenPosition[0] = player.worldPosition[0] - Camera.xOffset / RPGKit.getInstance().tileScale;
        player.screenPosition[1] = player.worldPosition[1] - Camera.yOffset / RPGKit.getInstance().tileScale;

        player.tileSet = TileSetManager.getTileSet("Player");
        player.loadImage();
        player.width = player.tileSet.tileSize;
        player.height = player.tileSet.tileSize;
//        TODO: reference the player's image to only add collision to feet.
        player.hitbox = new Rectangle();

        player.hitbox.width = (int) (player.width * RPGKit.getInstance().tileScale / 4);
        player.hitbox.height = (int) (player.height * RPGKit.getInstance().tileScale / 4);

        player.collision = true;

        for (FieldInstance field : entity.getFieldInstances()) {
            if (field.getIdentifier().equals("Direction")) {
                player.direction = Direction.valueOf((String) field.getValue());
            } else if (field.getIdentifier().equals("Speed")) {
                if (field.getValue() instanceof Integer) {
                    player.speed = ((Integer) field.getValue()).doubleValue();
                } else if (field.getValue() instanceof Double) {
                    player.speed = (Double) field.getValue();
                }
            }
        }
        return player;
    }

    public Item loadItem(LDtk ldtk, EntityInstance entity, LayerInstance layer, Level level, EntityManger entityManger) {
        Item item;
        double[] itemPosition = getEntityPosition(entity, layer, level, ldtk.getWorldLayout());

        List<String> tags = Arrays.asList(entity.getTags());
        item = RPGKit.getInstance().itemLoader.loadItem(tags, entity, entityManger);

        if (item == null) {
            return item;
        }

        item.worldPosition[0] = itemPosition[0];
        item.worldPosition[1] = itemPosition[1];

        item.screenPosition[0] = item.worldPosition[0] - Camera.xOffset / RPGKit.getInstance().tileScale;
        item.screenPosition[1] = item.worldPosition[1] - Camera.yOffset / RPGKit.getInstance().tileScale;

        item.width = item.tileSet.tileSize;
        item.height = item.tileSet.tileSize;

        item.collision = false;
        return item;
    }

    private double[] getEntityPosition(EntityInstance entity, LayerInstance layer, Level level, WorldLayout worldLayout) {
        double[] position = new double[2];
        position[0] = (entity.getPx()[0] - entity.getPivot()[0] * entity.getWidth()) + layer.getPxTotalOffsetX();
        position[1] = (entity.getPx()[1] - entity.getPivot()[1] * entity.getHeight()) + layer.getPxTotalOffsetY();

        if (worldLayout == WorldLayout.FREE || worldLayout == WorldLayout.GRID_VANIA) {
            position[0] += level.getWorldX();
            position[1] += level.getWorldY();
        }
        return position;
    }

    /**
     * Load map for a game.
     *
     * @param ldtk the level data
     *             you can add more parameters here depends on the code you have.
     */
    public void loadMap(LDtk ldtk, String identifier) {
        RPGKit RPGKit = rpgkit.RPGKit.getInstance();
        Level targetLevel = findLevel(ldtk, identifier);

        if (targetLevel == null) {
            return;
        }

        ArrayList<LayerInstance> tileLayers = getLayers(targetLevel);
        processLayers(tileLayers, RPGKit, ldtk, targetLevel);
    }

    /**
     * Get layers from the target level.
     *
     * @param targetLevel target level
     * @return an array list of LayerInstance
     */
    public ArrayList<LayerInstance> getLayers(Level targetLevel) {
        ArrayList<LayerInstance> tileLayers = new ArrayList<>();
        Collections.addAll(tileLayers, targetLevel.getLayerInstances());
        return tileLayers;
    }

    /**
     * Process all layers.
     *
     * @param tileLayers  layers to process
     * @param rpgKit      game panel
     * @param ldtk        the level data
     * @param targetLevel target level
     */
    public void processLayers(ArrayList<LayerInstance> tileLayers,
                              RPGKit rpgKit,
                              LDtk ldtk,
                              Level targetLevel) {
        for (LayerInstance layer : tileLayers) {
            if (layer.getType().equals("Entities")) {
                processEntityLayer(layer, rpgKit, ldtk, targetLevel);
            } else if (layer.getType().equals("Tiles")) {
                processTileLayer(layer, rpgKit, targetLevel);
            }
        }
    }

    /**
     * Process entity layer.
     *
     * @param layer       layer
     * @param rpgKit      game panel
     * @param ldtk        the level data
     * @param targetLevel target level
     */
    public void processEntityLayer(LayerInstance layer, RPGKit rpgKit, LDtk ldtk, Level targetLevel) {
        EntityManger entityManager = new EntityManger();
        for (EntityInstance entity : layer.getEntityInstances()) {
            List<String> tags = Arrays.asList(entity.getTags());
            if (tags.contains("Item")) {
                entityManager.entities.add(loadItem(ldtk, entity, layer, targetLevel, entityManager));
            } else if (tags.contains("Player")) {
                rpgKit.player = loadPlayer(ldtk,
                                           entity,
                                           layer,
                                           targetLevel,
                                           entityManager);
                entityManager.entities.add(rpgKit.player);
            }
        }
        rpgKit.manager.managers.add(entityManager);
    }

    /**
     * Process tile layer.
     *
     * @param layer       layer
     * @param rpgKit      game panel
     * @param targetLevel target level
     */
    public void processTileLayer(LayerInstance layer, RPGKit rpgKit, Level targetLevel) {
        for (TileSet tileset : TileSetManager.tileSets) {
            if (tileset.uid == layer.getTilesetDefUid()) {
                processTileSet(layer, rpgKit, tileset, targetLevel);
            }
        }
    }

    /**
     * Process tile set.
     *
     * @param layer       layer
     * @param rpgKit      game panel
     * @param tileset     tile set
     * @param targetLevel target level
     */
    public void processTileSet(LayerInstance layer, RPGKit rpgKit, TileSet tileset, Level targetLevel) {
        TileManager tileManager = new TileManager();
        for (TileInstance tile : layer.getGridTiles()) {
            TileCustomMetadata metadata = null;

            for (TileCustomMetadata metadata1 : tileset.tileSet.getCustomData()) {
                if (metadata1.getTileID() == tile.getT()) {
                    metadata = metadata1;
                    break;
                }
            }

            TileProperties properties = null;
            if (metadata != null) {
                properties = getTileProperties(metadata);
            }

            addTile(properties, tile, tileset, targetLevel, tileManager);
        }

        rpgKit.manager.managers.add(tileManager);
    }

    /**
     * Get tile properties.
     *
     * @param metadata metadata
     * @return tile properties
     */
    public TileProperties getTileProperties(TileCustomMetadata metadata) {
        TileProperties properties;
        try {
            properties = Converter.fromJsonString(metadata.getData());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }

    /**
     * Add tile.
     *
     * @param properties  properties
     * @param tile        tile
     * @param tileset     tile set
     * @param targetLevel target level
     * @param tileManager tile manager
     */
    public void addTile(TileProperties properties, TileInstance tile, TileSet tileset, Level targetLevel, TileManager tileManager) {
        try {
            if (properties != null && properties.getInteraction() != null) {
                tileManager.tiles.add(RPGKit.getInstance().interactableLoader.loadInteractable(properties.getInteraction().toLowerCase(),
                                                                                               tile,
                                                                                               tileset,
                                                                                               targetLevel,
                                                                                               properties));
            } else {
                tileManager.tiles.add(new Tile(tile, tileset, targetLevel, properties));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Level findLevel(LDtk ldtk, String identifier) {
        Level[] levels = ldtk.getLevels();

        for (Level level : levels) {
            if (level.getIdentifier().equals(identifier)) {
                return level;
            }
        }
        return null;
    }

    public static LDtkLoader get() {
        if (loader == null) {
            loader = new LDtkLoader();
        }
        return loader;
    }

    public void centerEntity(Entity entity) {
        RPGKit rpgKit = RPGKit.getInstance();

        Camera.xOffset -= (entity.worldPosition[0] * rpgKit.tileScale) - ((double) rpgKit.screenWidth / 2);
        Camera.yOffset -= (entity.worldPosition[1] * rpgKit.tileScale) - ((double) rpgKit.screenHeight / 2);
    }

    public void loadGame(LDtk ldtk, String identifier) {
        loadTilesets(ldtk);
        loadMap(ldtk, identifier);
    }
}
