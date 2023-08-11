package main;

import entity.Player;
import entity.item.Item;
import entity.item.ObsidianSword;
import interactable.Farm;
import ldtk.*;
import ldtk.tile.Converter;
import ldtk.tile.TileProperties;
import managers.EntityManger;
import managers.TileManager;
import managers.TileSetManager;
import utils.Direction;
import utils.Utils;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LDtkLoader {
    public static LDtkLoader loader;

    public void loadTilesets(LDtk ldtk) {
        TilesetDefinition[] tilesetDefinitions = ldtk.getDefs().getTilesets();
        for (TilesetDefinition tilesetDefinition : tilesetDefinitions) {
            TileSet tileSet = new TileSet(tilesetDefinition);
            tileSet.loadImage('/' + Utils.paths.normalizePath("world/" + tilesetDefinition.getRelPath()));
            TileSetManager.tileSets.add(tileSet);
        }
    }

    public Player loadPlayer(LDtk ldtk, EntityInstance entity, LayerInstance layer, Level level, EntityManger entityManger) {
        Player player = new Player(GamePanel.getInstance().keyHandler, entityManger);

        double[] playerPosition = getEntityPosition(entity, layer, level, ldtk.getWorldLayout());
        player.worldPosition[0] = playerPosition[0];
        player.worldPosition[1] = playerPosition[1];
//        get the player's screen position from the world position
        player.screenPosition[0] = player.worldPosition[0] - Camera.xOffset / GamePanel.getInstance().tileScale;
        player.screenPosition[1] = player.worldPosition[1] - Camera.yOffset / GamePanel.getInstance().tileScale;

        player.tileSet = TileSetManager.getTileSet("Player");
        player.width = player.tileSet.tileSize;
        player.height = player.tileSet.tileSize;
//        TODO: reference the player's image to only add collision to feet.
        player.hitbox = new Rectangle();

        player.hitbox.width = (int) (player.width * GamePanel.getInstance().tileScale / 4);
        player.hitbox.height = (int) (player.height * GamePanel.getInstance().tileScale / 4);

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
        Item item = null;
        double[] itemPosition = getEntityPosition(entity, layer, level, ldtk.getWorldLayout());

        List tags = Arrays.asList(entity.getTags());
        if (tags.contains("Item")) {
            if (tags.contains("Weapon")) {
                item = new ObsidianSword(entityManger, TileSetManager.getTileSet("Weapons"), entity.getTile());
            }
        }
        if (item != null) {
            item.worldPosition[0] = itemPosition[0];
            item.worldPosition[1] = itemPosition[1];

            item.screenPosition[0] = item.worldPosition[0] - Camera.xOffset / GamePanel.getInstance().tileScale;
            item.screenPosition[1] = item.worldPosition[1] - Camera.yOffset / GamePanel.getInstance().tileScale;

            item.width = item.tileSet.tileSize;
            item.height = item.tileSet.tileSize;

            item.collision = false;
        }
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
    public void loadMap(LDtk ldtk) {
        GamePanel gamePanel = GamePanel.getInstance();
        Level targetLevel = findLevel(ldtk, "Level_0");

        if (targetLevel == null) {
            return;
        }

        ArrayList<LayerInstance> tileLayers = getLayers(targetLevel);
        processLayers(tileLayers, gamePanel, ldtk, targetLevel);
    }

    /**
     * Get layers from the target level.
     *
     * @param targetLevel target level
     * @return an array list of LayerInstance
     */
    public ArrayList<LayerInstance> getLayers(Level targetLevel) {
        ArrayList<LayerInstance> tileLayers = new ArrayList<>();
        for (LayerInstance layer : targetLevel.getLayerInstances()) {
            if (layer.getType().equals("Tiles")) {
                tileLayers.add(layer);
            } else if (layer.getType().equals("Entities")) {
                for (EntityInstance entity : layer.getEntityInstances()) {
                    if (entity.getIdentifier().equals("PlayerStart")) {
                        tileLayers.add(layer);
                    }
                }
            }
        }

        return tileLayers;
    }

    /**
     * Process all layers.
     *
     * @param tileLayers  layers to process
     * @param gamePanel   game panel
     * @param ldtk        the level data
     * @param targetLevel target level
     */
    public void processLayers(ArrayList<LayerInstance> tileLayers,
                              GamePanel gamePanel,
                              LDtk ldtk,
                              Level targetLevel) {
        for (LayerInstance layer : tileLayers) {
            if (layer.getType().equals("Entities")) {
                processEntityLayer(layer, gamePanel, ldtk, targetLevel);
            } else if (layer.getType().equals("Tiles")) {
                processTileLayer(layer, gamePanel, targetLevel);
            }
        }
    }

    /**
     * Process entity layer.
     *
     * @param layer       layer
     * @param gamePanel   game panel
     * @param ldtk        the level data
     * @param targetLevel target level
     */
    public void processEntityLayer(LayerInstance layer, GamePanel gamePanel, LDtk ldtk, Level targetLevel) {
        EntityManger entityManager = new EntityManger();
        for (EntityInstance entity : layer.getEntityInstances()) {
            if (entity.getIdentifier().equals("PlayerStart")) {
                gamePanel.player = loadPlayer(ldtk,
                                              entity,
                                              layer,
                                              targetLevel,
                                              entityManager);
                entityManager.entities.add(gamePanel.player);
                centerPlayer();
            } else {
                entityManager.entities.add(loadItem(ldtk, entity, layer, targetLevel, entityManager));
            }
        }
        gamePanel.manager.managers.add(entityManager);
    }

    /**
     * Process tile layer.
     *
     * @param layer       layer
     * @param gamePanel   game panel
     * @param targetLevel target level
     */
    public void processTileLayer(LayerInstance layer, GamePanel gamePanel, Level targetLevel) {
        for (TileSet tileset : TileSetManager.tileSets) {
            if (tileset.uid == layer.getTilesetDefUid()) {
                processTileSet(layer, gamePanel, tileset, targetLevel);
            }
        }
    }

    /**
     * Process tile set.
     *
     * @param layer       layer
     * @param gamePanel   game panel
     * @param tileset     tile set
     * @param targetLevel target level
     */
    public void processTileSet(LayerInstance layer, GamePanel gamePanel, TileSet tileset, Level targetLevel) {
        TileManager tileManager = new TileManager();
        for (TileInstance tile : layer.getGridTiles()) {
            TileCustomMetadata metadata = Utils.objects.findObjectWithFieldValue(List.of(tileset.metadata),
                                                                                 "tileID",
                                                                                 tile.getT());

            TileProperties properties = null;
            if (metadata != null) {
                properties = getTileProperties(metadata);
            }

            addTile(properties, tile, tileset, targetLevel, tileManager);
        }

        gamePanel.manager.managers.add(tileManager);
    }

    /**
     * Get tile properties.
     *
     * @param metadata metadata
     * @return tile properties
     */
    public TileProperties getTileProperties(TileCustomMetadata metadata) {
        TileProperties properties = null;
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
                switch (properties.getInteraction()) {
                    case FARM -> tileManager.tiles.add(new Farm(tile, tileset, targetLevel));
                }
            } else {
                tileManager.tiles.add(new Tile(tile, tileset, targetLevel));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Level findLevel(LDtk ldtk, String identifier) {
        Level[] levels = ldtk.getLevels();

        return Utils.objects.findObjectWithFieldValue(
                List.of(levels), "identifier", identifier);
    }

    public static LDtkLoader get() {
        if (loader == null) {
            loader = new LDtkLoader();
        }
        return loader;
    }

    public void centerPlayer() {
        GamePanel gamePanel = GamePanel.getInstance();

        Camera.xOffset -= (gamePanel.player.worldPosition[0] * gamePanel.tileScale) - ((double) gamePanel.screenWidth / 2);
        Camera.yOffset -= (gamePanel.player.worldPosition[1] * gamePanel.tileScale) - ((double) gamePanel.screenHeight / 2);
    }
}
