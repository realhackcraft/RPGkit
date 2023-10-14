package rpgkit;

import rpgkit.drawable.entity.Player;
import rpgkit.input.KeyHandler;
import rpgkit.util.Direction;

import java.awt.*;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;
import static rpgkit.util.Direction.LEFT;

public class Movement {
    public static final ArrayList<Tile> solidTiles = new ArrayList<>();

    public static void computeMovements(KeyHandler keyHandler, double delta) {
        RPGKit rpgKit = RPGKit.getInstance();
        Player player = rpgKit.player;

//        User inputs
        boolean[] keys = {keyHandler.isKeyPressed(VK_UP) || keyHandler.isKeyPressed(VK_W), keyHandler.isKeyPressed(
                VK_DOWN) || keyHandler.isKeyPressed(VK_S), keyHandler.isKeyPressed(
                VK_LEFT) || keyHandler.isKeyPressed(VK_A), keyHandler.isKeyPressed(VK_RIGHT) || keyHandler.isKeyPressed(
                VK_D)};

        Rectangle[] playerCollisionBoxes = {(Rectangle) player.hitbox.clone(), (Rectangle) player.hitbox.clone(), (Rectangle) player.hitbox.clone(), (Rectangle) player.hitbox.clone()};

//        Simulate player movement
        if (keys[0]) {
            playerCollisionBoxes[0].y -= (int) (player.speed * rpgKit.tileScale * delta);
        }
        if (keys[1]) {
            playerCollisionBoxes[1].y += (int) (player.speed * rpgKit.tileScale * delta);
        }
        if (keys[2]) {
            playerCollisionBoxes[2].x -= (int) (player.speed * rpgKit.tileScale * delta);
        }
        if (keys[3]) {
            playerCollisionBoxes[3].x += (int) (player.speed * rpgKit.tileScale * delta);
        }

//        Check for collision
        for (int i = 0; i < playerCollisionBoxes.length; i++) {
            Rectangle playerCollisionBox = playerCollisionBoxes[i];

            for (Tile tile : solidTiles) {
                if (playerCollisionBox.intersects(tile.hitbox)) {
//                    If collision, cancel movement
                    keys[i] = false;
                }
            }
        }

//        Apply movement
        if (keys[0]) {
            if (player.screenPosition[1] < RPGKit.getInstance().getHeight() / 4.0) {        // 1/4
                Camera.yOffset += player.speed * rpgKit.tileScale * delta;
            }
            player.worldPosition[1] -= player.speed * delta;
            player.direction = Direction.UP;
        }

        if (keys[1]) {
            if (player.screenPosition[1] > RPGKit.getInstance().getHeight() / 4.0 * 3.0) {  // 3/4
                Camera.yOffset -= player.speed * rpgKit.tileScale * delta;
            }
            player.worldPosition[1] += player.speed * delta;
            player.direction = Direction.DOWN;
        }

        if (keys[2]) {
            if (player.screenPosition[0] < RPGKit.getInstance().getWidth() / 4.0) {       // 1/4
                Camera.xOffset += player.speed * rpgKit.tileScale * delta;
            }
            player.worldPosition[0] -= player.speed * delta;
            player.direction = LEFT;
        }

        if (keys[3]) {
            if (player.screenPosition[0] > RPGKit.getInstance().getWidth() / 4.0 * 3.0) { // 3/4
                Camera.xOffset -= player.speed * rpgKit.tileScale * delta;
            }
            player.worldPosition[0] += player.speed * delta;
            player.direction = Direction.RIGHT;
        }
    }
}
