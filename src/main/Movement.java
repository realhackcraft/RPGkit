package main;

import managers.TileManager;

import java.awt.*;

import static java.awt.event.KeyEvent.*;
import static utils.Direction.*;

public class Movement {
    public static void computeMovements(KeyHandler keyHandler, double delta) {
        GamePanel gamePanel = GamePanel.getInstance();

        boolean[] collision = {false, false, false, false};

        for (Drawable drawable : gamePanel.manager.managers) {
            if (drawable instanceof TileManager tileManager) {
                for (Tile tile : tileManager.tiles) {
                    if (tile.data != null) {
                        if (tile.data.getSolid()) {
                            if (keyHandler.isKeyPressed(VK_W)) {
                                Rectangle player = new Rectangle(gamePanel.player.hitbox);
                                player.y -= (int) (gamePanel.player.speed * gamePanel.tileScale * delta);
                                if (player.intersects(tile.hitbox)) {
                                    collision[0] = true;
                                }
                            }
                            if (keyHandler.isKeyPressed(VK_A)) {
                                Rectangle player = new Rectangle(gamePanel.player.hitbox);
                                player.x -= (int) (gamePanel.player.speed * gamePanel.tileScale * delta);
                                if (player.intersects(tile.hitbox)) {
                                    collision[1] = true;
                                }
                            }
                            if (keyHandler.isKeyPressed(VK_S)) {
                                Rectangle player = new Rectangle(gamePanel.player.hitbox);
                                player.y += (int) (gamePanel.player.speed * gamePanel.tileScale * delta);
                                if (player.intersects(tile.hitbox)) {
                                    collision[2] = true;
                                }
                            }
                            if (keyHandler.isKeyPressed(VK_D)) {
                                Rectangle player = new Rectangle(gamePanel.player.hitbox);
                                player.x += (int) (gamePanel.player.speed * gamePanel.tileScale * delta);
                                if (player.intersects(tile.hitbox)) {
                                    collision[3] = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (keyHandler.isKeyPressed(VK_W)) {
            if (!collision[0]) {
                Camera.yOffset += gamePanel.player.speed * gamePanel.tileScale * delta;
                gamePanel.player.worldPosition[1] -= gamePanel.player.speed * delta;
                gamePanel.player.direction = UP;
            }
        }
        if (keyHandler.isKeyPressed(VK_A)) {
            if (!collision[1]) {
                Camera.xOffset += gamePanel.player.speed * gamePanel.tileScale * delta;
                gamePanel.player.worldPosition[0] -= gamePanel.player.speed * delta;
                gamePanel.player.direction = LEFT;
            }
        }
        if (keyHandler.isKeyPressed(VK_S)) {
            if (!collision[2]) {
                Camera.yOffset -= gamePanel.player.speed * gamePanel.tileScale * delta;
                gamePanel.player.worldPosition[1] += gamePanel.player.speed * delta;
                gamePanel.player.direction = DOWN;
            }
        }
        if (keyHandler.isKeyPressed(VK_D)) {
            if (!collision[3]) {
                Camera.xOffset -= gamePanel.player.speed * gamePanel.tileScale * delta;
                gamePanel.player.worldPosition[0] += gamePanel.player.speed * delta;
                gamePanel.player.direction = RIGHT;
            }
        }
    }
}
