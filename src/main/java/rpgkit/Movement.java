package rpgkit;

import rpgkit.entity.Player;
import rpgkit.managers.TileManager;
import rpgkit.utils.Utils;

import java.awt.*;

import static java.awt.event.KeyEvent.*;
import static rpgkit.utils.Direction.*;

public class Movement {
    public static void computeMovements(KeyHandler keyHandler, double delta) {
        RPGKit RPGKit = rpgkit.RPGKit.getInstance();
        Rectangle player = new Rectangle(RPGKit.player.hitbox);

        double distance = RPGKit.player.speed * delta;
        double worldDistance = RPGKit.player.speed * RPGKit.tileScale * delta;

        boolean[] willCollide = {false, false, false, false};
        boolean[] keyStates = {keyHandler.isKeyPressed(VK_W), keyHandler.isKeyPressed(VK_A),
                keyHandler.isKeyPressed(VK_S), keyHandler.isKeyPressed(VK_D)};

        for (Drawable drawable : RPGKit.manager.managers) {
            if (drawable instanceof TileManager tileManager) {
                for (Tile tile : tileManager.tiles) {
//                    only check the tiles that are close to the player
                    if (Utils.game.calculateDistance(RPGKit.player.worldPosition,
                                                     new double[]{tile.worldPosition[0], tile.worldPosition[1]}) > RPGKit.tileSize)
                        continue;
                    checkCollision(player, keyStates, tile, willCollide, RPGKit, (int) worldDistance);
                }
            }
        }

        move(keyStates, willCollide, distance, worldDistance, RPGKit);
    }

    private static void move(boolean[] keyStates, boolean[] willCollide, double distance, double worldDistance, RPGKit RPGKit) {
        Player player = RPGKit.player;
        if (keyStates[0] && !willCollide[0]) {
            if (player.screenPosition[1] < RPGKit.getHeight() / 4.0) {
                Camera.yOffset += worldDistance;
            }
            player.worldPosition[1] -= distance;
            player.direction = UP;
        }
        if (keyStates[1] && !willCollide[1]) {
            if (player.screenPosition[0] < RPGKit.getWidth() / 4.0) {
                Camera.xOffset += worldDistance;
            }
            player.worldPosition[0] -= distance;
            player.direction = LEFT;
        }
        if (keyStates[2] && !willCollide[2]) {
            if (player.screenPosition[1] > RPGKit.getHeight() * (3.0 / 4.0)) {
                Camera.yOffset -= worldDistance;
            }
            player.worldPosition[1] += distance;
            player.direction = DOWN;
        }
        if (keyStates[3] && !willCollide[3]) {
            if (player.screenPosition[0] > RPGKit.getWidth() * (3.0 / 4.0)) {
                Camera.xOffset -= worldDistance;
            }
            player.worldPosition[0] += distance;
            player.direction = RIGHT;
        }
    }

    private static void checkCollision(Rectangle player, boolean[] keyStates, Tile tile, boolean[] willCollide, RPGKit RPGKit, int worldDistance) {
        if (tile.data != null && tile.data.getSolid() != null && tile.data.getSolid()) {
            boolean keyState0 = keyStates[0];
            boolean keyState1 = keyStates[1];
            boolean keyState2 = keyStates[2];
            boolean keyState3 = keyStates[3];

            if (keyState0 && !willCollide[0]) {
                player.y -= worldDistance;
                willCollide[0] = player.intersects(tile.hitbox);
            }
            if (keyState1 && !willCollide[1]) {
                player.x -= worldDistance;
                willCollide[1] = player.intersects(tile.hitbox);
            }
            if (keyState2 && !willCollide[2]) {
                player.y += worldDistance;
                willCollide[2] = player.intersects(tile.hitbox);
            }
            if (keyState3 && !willCollide[3]) {
                player.x += worldDistance;
                willCollide[3] = player.intersects(tile.hitbox);
            }
            player.setBounds(RPGKit.player.hitbox);
        }
    }
}
