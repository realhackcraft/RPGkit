package main;

import ldtk.Level;
import ldtk.TileCustomMetadata;
import ldtk.TileInstance;
import ldtk.tile.Converter;
import ldtk.tile.TileProperties;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class Tile implements Drawable {
    public final TileSet tileSet;
    public final long[] worldPosition = new long[2];
    public final long[] tileSetPosition;
    private final double[] screenPosition = new double[2];
    public final GamePanel gamePanel = GamePanel.getInstance();
    public final BufferedImage image;

    public final long tileId;
    public TileProperties data;
    public final Rectangle hitbox;

    public Tile(TileInstance tile, TileSet tileSet, Level level) throws IOException {
        BufferedImage tempImage;
        this.tileSet = tileSet;

        this.worldPosition[0] = tile.getPx()[0] + level.getWorldX();
        this.worldPosition[1] = tile.getPx()[1] + level.getWorldY();
        this.tileSetPosition = tile.getSrc();

        this.screenPosition[0] = (worldPosition[0] * gamePanel.tileScale) + Camera.xOffset;
        this.screenPosition[1] = (worldPosition[1] * gamePanel.tileScale) + Camera.yOffset;

        this.hitbox = new Rectangle();
        this.hitbox.x = (int) screenPosition[0];
        this.hitbox.y = (int) screenPosition[1];
        this.hitbox.width = (int) (this.tileSet.tileSize * gamePanel.tileScale);
        this.hitbox.height = (int) (this.tileSet.tileSize * gamePanel.tileScale);

        tempImage = Utils.images.scale(tileSet.getFrame(
                (int) (tileSetPosition[0] / tileSet.tileSize),
                (int) (tileSetPosition[1] / tileSet.tileSize)), gamePanel.tileScale, gamePanel.tileScale);

        if (tile.getF() == 1) {
            tempImage = Utils.images.flipHorizontal(tempImage);
        } else if (tile.getF() == 2) {
            tempImage = Utils.images.flipVertical(tempImage);
        } else if (tile.getF() == 3) {
            tempImage = Utils.images.flipAll(tempImage);
        }

        image = tempImage;
        this.tileId = tile.getT();
        if (tileSet.metadata == null) {
            return;
        }
        TileCustomMetadata metadata = Utils.objects.findObjectWithFieldValue(List.of(tileSet.metadata),
                                                                             "tileID",
                                                                             tileId);
        if (metadata == null) {
            return;
        }
        data = Converter.fromJsonString(metadata.getData());
    }

    @Override
    public void draw(Graphics2D g2d) {
//        If the tile isn't non the screen, don't draw it.
        if (Utils.game.isOffScreen(screenPosition)) {
            return;
        }
//        Draw the tile on the screen based on its screenPosition.
        g2d.drawImage(image,
                      (int) screenPosition[0],
                      (int) screenPosition[1],
                      gamePanel);

        if (Main.mode == Main.Mode.TEST) {
            if (data != null && data.getSolid() != null && data.getSolid()) {
                g2d.setColor(Color.RED);
                g2d.fill(hitbox);
            }
        }
    }

    @Override
    public void update(double delta) {
        screenPosition[0] = (worldPosition[0] * gamePanel.tileScale) + Camera.xOffset;
        screenPosition[1] = (worldPosition[1] * gamePanel.tileScale) + Camera.yOffset;

        hitbox.x = (int) screenPosition[0];
        hitbox.y = (int) screenPosition[1];
    }
}
