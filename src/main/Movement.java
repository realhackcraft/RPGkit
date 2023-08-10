package main;

import managers.TileManager;

import java.awt.*;

import static java.awt.event.KeyEvent.*;
import static utils.Direction.*;

public class Movement {
    public static void computeMovements(KeyHandler keyHandler, double delta) {
        GamePanel gamePanel = GamePanel.getInstance();
        Rectangle player;
        boolean[] collision = {false, false, false, false};

        for (Drawable drawable : gamePanel.manager.managers) {
            if (drawable instanceof TileManager tileManager) {
                for (Tile tile : tileManager.tiles) {
                    if (tile.data != null && tile.data.getSolid() != null && tile.data.getSolid()) {
                        player = new Rectangle(gamePanel.player.hitbox);
                        if (keyHandler.isKeyPressed(VK_W) && !collision[0]) {
                            player.y -= (int) (gamePanel.player.speed * gamePanel.tileScale * delta);
                            collision[0] = player.intersects(tile.hitbox);
                        }
                        if (keyHandler.isKeyPressed(VK_A) && !collision[1]) {
                            player.x -= (int) (gamePanel.player.speed * gamePanel.tileScale * delta);
                            collision[1] = player.intersects(tile.hitbox);
                        }
                        if (keyHandler.isKeyPressed(VK_S) && !collision[2]) {
                            player.y += (int) (gamePanel.player.speed * gamePanel.tileScale * delta);
                            collision[2] = player.intersects(tile.hitbox);
                        }
                        if (keyHandler.isKeyPressed(VK_D) && !collision[3]) {
                            player.x += (int) (gamePanel.player.speed * gamePanel.tileScale * delta);
                            collision[3] = player.intersects(tile.hitbox);
                        }
                    }
                }
            }
        }

        if (keyHandler.isKeyPressed(VK_W) && !collision[0]) {
            Camera.yOffset += gamePanel.player.speed * gamePanel.tileScale * delta;
            gamePanel.player.worldPosition[1] -= gamePanel.player.speed * delta;
            gamePanel.player.direction = UP;
        }
        if (keyHandler.isKeyPressed(VK_A) && !collision[1]) {
            Camera.xOffset += gamePanel.player.speed * gamePanel.tileScale * delta;
            gamePanel.player.worldPosition[0] -= gamePanel.player.speed * delta;
            gamePanel.player.direction = LEFT;
        }
        if (keyHandler.isKeyPressed(VK_S) && !collision[2]) {
            Camera.yOffset -= gamePanel.player.speed * gamePanel.tileScale * delta;
            gamePanel.player.worldPosition[1] += gamePanel.player.speed * delta;
            gamePanel.player.direction = DOWN;
        }
        if (keyHandler.isKeyPressed(VK_D) && !collision[3]) {
            Camera.xOffset -= gamePanel.player.speed * gamePanel.tileScale * delta;
            gamePanel.player.worldPosition[0] += gamePanel.player.speed * delta;
            gamePanel.player.direction = RIGHT;
        }
    }
}
