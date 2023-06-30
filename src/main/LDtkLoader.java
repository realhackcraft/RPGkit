package main;

import LDtk.*;
import entity.Player;
import utils.Direction;
import utils.Utils;

import java.util.List;

public class LDtkLoader {
    public static void loadPlayer(Player player, LDtk ldtk) {
        Level[] levels = ldtk.getLevels();

        Level targetLevel = Utils.objects.findObjectWithFieldValue(
                List.of(levels), "identifier", "Level_0");
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

        player.x = targetEntity.getPx()[0];
        player.y = targetEntity.getPx()[1];

        for (FieldInstance field : targetEntity.getFieldInstances()) {
            if (field.getIdentifier().equals("Direction")) {
                player.direction = Direction.valueOf((String) field.getValue());
            } else if (field.getIdentifier().equals("Speed")) {
                player.speed = (double) field.getValue();
            }
        }
    }
}
