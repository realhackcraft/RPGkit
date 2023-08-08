package main;

import LDtk.*;
import entity.Player;
import managers.EntityManger;
import managers.TileManager;
import managers.TileSetManager;
import utils.Direction;
import utils.Utils;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
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

    public void loadPlayer(Player player, LDtk ldtk, EntityInstance entity, LayerInstance layer, Level level) {

        player.worldPosition = getEntityPosition(entity, layer, level, ldtk.getWorldLayout());
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
                player.speed = (double) field.getValue();
            }
        }
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

    public void loadMap(LDtk ldtk) {
        GamePanel gamePanel = GamePanel.getInstance();
        Level targetLevel = findLevel(ldtk, "Level_0");
        if (targetLevel == null) {
            return;
        }

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

        for (LayerInstance layer : tileLayers) {
            if (layer.getType().equals("Entities")) {
                EntityManger entityManger = new EntityManger();
                for (EntityInstance entity : layer.getEntityInstances()) {
                    if (entity.getIdentifier().equals("PlayerStart")) {
                        loadPlayer(gamePanel.player, ldtk, entity, layer, targetLevel);
                        entityManger.entities.add(gamePanel.player);
                    }
                }
                gamePanel.layerManager.drawables.add(entityManger);
            } else if (layer.getType().equals("Tiles")) {
                for (TileSet tileset : TileSetManager.tileSets) {
                    if (tileset.uid == layer.getTilesetDefUid()) {
                        TileManager tileManager = new TileManager();
                        for (TileInstance tile : layer.getGridTiles()) {
                            try {
                                tileManager.tiles.add(new Tile(tile, tileset, targetLevel));
                            } catch (IOException e) {
                                throw new RuntimeException("Cannot get tile metadata.", e);
                            }
                        }
                        gamePanel.layerManager.drawables.add(tileManager);
                    }
                }
            }
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

    public static void centerPlayer() {
        GamePanel gamePanel = GamePanel.getInstance();

        Camera.xOffset -= (gamePanel.player.worldPosition[0] * gamePanel.tileScale) - ((double) gamePanel.screenWidth / 2);
        Camera.yOffset -= (gamePanel.player.worldPosition[1] * gamePanel.tileScale) - ((double) gamePanel.screenHeight / 2);
    }
}
