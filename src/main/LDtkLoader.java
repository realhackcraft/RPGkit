package main;

import LDtk.*;
import entity.Player;
import managers.TileManager;
import managers.TileSetManager;
import utils.Direction;
import utils.Utils;

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
        double[] playerPosition = getEntityPosition(entity, layer, level, ldtk.getWorldLayout());

        player.x = playerPosition[0];
        player.y = playerPosition[1];
        player.tileSet = TileSetManager.getTileSet("Player");

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
                if (layer.getEntityInstances().length == 1) {
                    EntityInstance entity = layer.getEntityInstances()[0];
                    if (entity.getIdentifier().equals("PlayerStart")) {
                        loadPlayer(gamePanel.player, ldtk, entity, layer, targetLevel);
                        gamePanel.layerManager.drawables.add(gamePanel.player);
                    }
                }
            } else if (layer.getType().equals("Tiles")) {
                for (TileSet tileset : TileSetManager.tileSets) {
                    if (tileset.uid == layer.getTilesetDefUid()) {
                        TileManager tileManager = new TileManager();
                        for (TileInstance tile : layer.getGridTiles()) {
                            tileManager.tiles.add(new Tile(tile, tileset, gamePanel));
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
}
