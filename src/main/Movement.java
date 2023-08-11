package main;

import managers.TileManager;

import java.awt.*;

import static java.awt.event.KeyEvent.*;
import static utils.Direction.*;

public class Movement {
    public static void computeMovements(KeyHandler keyHandler, double delta) {
        GamePanel gamePanel = GamePanel.getInstance();
        Rectangle player = new Rectangle(gamePanel.player.hitbox);
        boolean[] willCollide = {false, false, false, false};

        for (Drawable drawable : gamePanel.manager.managers) {
            if (drawable instanceof TileManager tileManager) {
                for (Tile tile : tileManager.tiles) {
                    if (tile.data != null && tile.data.getSolid() != null && tile.data.getSolid()) {
                        if (keyHandler.isKeyPressed(VK_W) && !willCollide[0]) {
                            player.setBounds(gamePanel.player.hitbox);
                            player.y -= (int) (gamePanel.player.speed * gamePanel.tileScale * delta);
                            willCollide[0] = player.intersects(tile.hitbox);
                        }
                        if (keyHandler.isKeyPressed(VK_A) && !willCollide[1]) {
                            player.setBounds(gamePanel.player.hitbox);
                            player.x -= (int) (gamePanel.player.speed * gamePanel.tileScale * delta);
                            willCollide[1] = player.intersects(tile.hitbox);
                        }
                        if (keyHandler.isKeyPressed(VK_S) && !willCollide[2]) {
                            player.setBounds(gamePanel.player.hitbox);
                            player.y += (int) (gamePanel.player.speed * gamePanel.tileScale * delta);
                            willCollide[2] = player.intersects(tile.hitbox);
                        }
                        if (keyHandler.isKeyPressed(VK_D) && !willCollide[3]) {
                            player.setBounds(gamePanel.player.hitbox);
                            player.x += (int) (gamePanel.player.speed * gamePanel.tileScale * delta);
                            willCollide[3] = player.intersects(tile.hitbox);
                        }
                    }
                }
            }
        }

        if (keyHandler.isKeyPressed(VK_W) && !willCollide[0]) {
            Camera.yOffset += gamePanel.player.speed * gamePanel.tileScale * delta;
            gamePanel.player.worldPosition[1] -= gamePanel.player.speed * delta;
            gamePanel.player.direction = UP;
        }
        if (keyHandler.isKeyPressed(VK_A) && !willCollide[1]) {
            Camera.xOffset += gamePanel.player.speed * gamePanel.tileScale * delta;
            gamePanel.player.worldPosition[0] -= gamePanel.player.speed * delta;
            gamePanel.player.direction = LEFT;
        }
        if (keyHandler.isKeyPressed(VK_S) && !willCollide[2]) {
            Camera.yOffset -= gamePanel.player.speed * gamePanel.tileScale * delta;
            gamePanel.player.worldPosition[1] += gamePanel.player.speed * delta;
            gamePanel.player.direction = DOWN;
        }
        if (keyHandler.isKeyPressed(VK_D) && !willCollide[3]) {
            Camera.xOffset -= gamePanel.player.speed * gamePanel.tileScale * delta;
            gamePanel.player.worldPosition[0] += gamePanel.player.speed * delta;
            gamePanel.player.direction = RIGHT;
        }
    }
}
