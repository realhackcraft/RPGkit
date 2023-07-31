package main;

import LDtk.TileInstance;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.event.KeyEvent.*;

public class Tile implements Drawable {
    public TileSet tileSet;
    public long[] worldPosition;
    public double[] screenPosition = new double[2];
    public long[] tileSetPosition;
    public GamePanel gamePanel;
    public BufferedImage image;

    public Tile(TileInstance tile, TileSet tileSet, GamePanel gamePanel) {
        this.tileSet = tileSet;

        this.gamePanel = gamePanel;

        this.worldPosition = tile.getPx();
        this.screenPosition[0] = worldPosition[0] * gamePanel.tileScale;
        this.screenPosition[1] = worldPosition[1] * gamePanel.tileScale;
        this.tileSetPosition = tile.getSrc();

        image = Utils.images.scale(tileSet.getFrame(
                (int) (tileSetPosition[0] / tileSet.tileSize),
                (int) (tileSetPosition[1] / tileSet.tileSize)), gamePanel.tileScale, gamePanel.tileScale);
    }

    @Override
    public void draw(Graphics2D g2d) {
//        If the tile isn't non the screen, don't draw it.
        if (screenPosition[0] + gamePanel.scaledTileSize < 0 ||
                screenPosition[0] > gamePanel.getWidth() ||
                screenPosition[1] + gamePanel.scaledTileSize < 0 ||
                screenPosition[1] > gamePanel.getHeight()) {
            return;
        }
//        Draw the tile on the screen based on its screenPosition.
        g2d.drawImage(
                image,
                (int) screenPosition[0],
                (int) screenPosition[1],
                gamePanel);
    }

    @Override
    public void update(double delta) {
        if (gamePanel.keyHandler.isKeyPressed(VK_W)) {
            this.screenPosition[1] += gamePanel.player.speed * gamePanel.tileScale * delta;
        }
        if (gamePanel.keyHandler.isKeyPressed(VK_A)) {
            this.screenPosition[0] += gamePanel.player.speed * gamePanel.tileScale * delta;
        }
        if (gamePanel.keyHandler.isKeyPressed(VK_S)) {
            this.screenPosition[1] -= gamePanel.player.speed * gamePanel.tileScale * delta;
        }
        if (gamePanel.keyHandler.isKeyPressed(VK_D)) {
            this.screenPosition[0] -= gamePanel.player.speed * gamePanel.tileScale * delta;
        }
    }
}
