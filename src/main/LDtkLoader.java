package main;

import LDtk.*;
import entity.Player;
import utils.Direction;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LDtkLoader {
    public static final ArrayList<TileSet> tileSets = new ArrayList<>();
    public static final ArrayList<Tile> tiles = new ArrayList<>();

    public static void loadTilesets(LDtk ldtk) {
        TilesetDefinition[] tilesetDefinitions = ldtk.getDefs().getTilesets();
        for (TilesetDefinition tilesetDefinition : tilesetDefinitions) {
            TileSet tileSet = new TileSet(tilesetDefinition);
            tileSet.loadImage('/' + Utils.paths.normalizePath("world/" + tilesetDefinition.getRelPath()));
            tileSets.add(tileSet);
        }
    }

    public static void loadPlayer(Player player, LDtk ldtk) {
        Level targetLevel = findLevel(ldtk, "Level_0");
        if (targetLevel == null) {
            return;
        }

        LayerInstance targetLayer = Utils.objects.findObjectWithFieldValue(
                List.of(targetLevel.getLayerInstances()),
                "identifier",
                "Entities");
        if (targetLayer == null || !targetLayer.getType().equals("Entities")) {
            return;
        }

        EntityInstance targetEntity = Utils.objects.findObjectWithFieldValue(
                List.of(targetLayer.getEntityInstances()),
                "identifier",
                "PlayerStart");
        if (targetEntity == null) {
            return;
        }

        double[] playerPosition = getEntityPosition(targetEntity, targetLayer, targetLevel, ldtk.getWorldLayout());

        player.x = playerPosition[0];
        player.y = playerPosition[1];

        for (FieldInstance field : targetEntity.getFieldInstances()) {
            if (field.getIdentifier().equals("Direction")) {
                player.direction = Direction.valueOf((String) field.getValue());
            } else if (field.getIdentifier().equals("Speed")) {
                player.speed = (double) field.getValue();
            }
        }
    }

    private static double[] getEntityPosition(EntityInstance entity, LayerInstance layer, Level level, WorldLayout worldLayout) {
        double[] position = new double[2];
        position[0] = (entity.getPx()[0] - entity.getPivot()[0] * entity.getWidth()) + layer.getPxTotalOffsetX();
        position[1] = (entity.getPx()[1] - entity.getPivot()[1] * entity.getHeight()) + layer.getPxTotalOffsetY();

        if (worldLayout == WorldLayout.FREE || worldLayout == WorldLayout.GRID_VANIA) {
            position[0] += level.getWorldX();
            position[1] += level.getWorldY();
        }
        return position;
    }

    public static void loadMap(LDtk ldtk) {
        Level targetLevel = findLevel(ldtk, "Level_0");
        if (targetLevel == null) {
            return;
        }

        ArrayList<LayerInstance> tileLayers = new ArrayList<>();
        for (LayerInstance layer : targetLevel.getLayerInstances()) {
            if (layer.getType().equals("Tiles")) {
                tileLayers.add(layer);
            }
        }

        for (LayerInstance layer : tileLayers) {
            for (TileSet tileset : tileSets) {
                if (tileset.uid == layer.getTilesetDefUid()) {
                    for (TileInstance tile : layer.getGridTiles()) {
                        tiles.add(new Tile(tile, tileset));
                    }
                }
            }
        }
    }

    private static Level findLevel(LDtk ldtk, String identifier) {
        Level[] levels = ldtk.getLevels();

        return Utils.objects.findObjectWithFieldValue(
                List.of(levels), "identifier", identifier);
    }
}
