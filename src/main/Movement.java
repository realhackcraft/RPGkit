package main;

import entity.Player;
import managers.TileManager;
import utils.Utils;

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
//                    only check the tiles that are close to the player
                    if (Utils.game.calculateDistance(gamePanel.player.worldPosition,
                                                     new double[]{tile.worldPosition[0], tile.worldPosition[1]}) > gamePanel.tileSize)
                        continue;
                    checkCollision(player, delta, keyHandler, tile, willCollide);
                }
            }
        }

        move(keyHandler, delta, willCollide);
    }

    private static void move(KeyHandler keyHandler, double delta, boolean[] willCollide) {
        GamePanel gamePanel = GamePanel.getInstance();
        Player player = gamePanel.player;
        double distance = player.speed * delta;
        double worldDistance = player.speed * gamePanel.tileScale * delta;
        if (keyHandler.isKeyPressed(VK_W) && !willCollide[0]) {
            Camera.yOffset += worldDistance;
            player.worldPosition[1] -= distance;
            player.direction = UP;
        }
        if (keyHandler.isKeyPressed(VK_A) && !willCollide[1]) {
            Camera.xOffset += worldDistance;
            player.worldPosition[0] -= distance;
            player.direction = LEFT;
        }
        if (keyHandler.isKeyPressed(VK_S) && !willCollide[2]) {
            Camera.yOffset -= worldDistance;
            player.worldPosition[1] += distance;
            player.direction = DOWN;
        }
        if (keyHandler.isKeyPressed(VK_D) && !willCollide[3]) {
            Camera.xOffset -= worldDistance;
            player.worldPosition[0] += distance;
            player.direction = RIGHT;
        }
    }

    private static void checkCollision(Rectangle player, double delta, KeyHandler keyHandler, Tile tile, boolean[] willCollide) {
        GamePanel gamePanel = GamePanel.getInstance();
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
