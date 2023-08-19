package rpgkit;

import rpgkit.drawable.Animatable;
import rpgkit.ldtk.Level;
import rpgkit.ldtk.TileCustomMetadata;
import rpgkit.ldtk.TileInstance;
import rpgkit.ldtk.tile.Converter;
import rpgkit.ldtk.tile.TileProperties;
import rpgkit.util.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile implements Animatable {
    public final TileSet tileSet;
    public final long[] worldPosition = new long[2];
    public final long[] tileSetPosition;
    private final double[] screenPosition = new double[2];
    public final RPGKit RPGKit = rpgkit.RPGKit.getInstance();
    private final TileInstance tile;
    public BufferedImage image;

    public final long tileId;
    public TileProperties data;
    public final Rectangle hitbox;
    public boolean hasAnimation;
    public int currentFrame = 0;

    public Tile(TileInstance tile, TileSet tileSet, Level level, TileProperties properties) throws IOException {
        BufferedImage tempImage;
        this.tileSet = tileSet;

        this.worldPosition[0] = tile.getPx()[0] + level.getWorldX();
        this.worldPosition[1] = tile.getPx()[1] + level.getWorldY();
        this.tileSetPosition = tile.getSrc();

        this.screenPosition[0] = (worldPosition[0] * RPGKit.tileScale) + Camera.xOffset;
        this.screenPosition[1] = (worldPosition[1] * RPGKit.tileScale) + Camera.yOffset;

        this.hitbox = new Rectangle();
        this.hitbox.x = (int) screenPosition[0];
        this.hitbox.y = (int) screenPosition[1];
        this.hitbox.width = (int) (this.tileSet.tileSize * RPGKit.tileScale);
        this.hitbox.height = (int) (this.tileSet.tileSize * RPGKit.tileScale);

        tempImage = Utils.images.scale(tileSet.getFrame(
                (int) (tileSetPosition[0] / tileSet.tileSize),
                (int) (tileSetPosition[1] / tileSet.tileSize)), RPGKit.tileScale, RPGKit.tileScale);

        if (tile.getF() == 1) {
            tempImage = Utils.images.flipHorizontal(tempImage);
        } else if (tile.getF() == 2) {
            tempImage = Utils.images.flipVertical(tempImage);
        } else if (tile.getF() == 3) {
            tempImage = Utils.images.flipAll(tempImage);
        }

        image = tempImage;
        this.tileId = tile.getT();
        this.tile = tile;

        if (properties == null) {
            return;
        }
        data = properties;
        hasAnimation = data.getAnimation() != null;
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
                      RPGKit);
    }

    @Override
    public void update(double delta) {
        screenPosition[0] = (worldPosition[0] * RPGKit.tileScale) + Camera.xOffset;
        screenPosition[1] = (worldPosition[1] * RPGKit.tileScale) + Camera.yOffset;

        if (!Utils.game.isOffScreen(screenPosition)) {
            hitbox.x = (int) screenPosition[0];
            hitbox.y = (int) screenPosition[1];
        }

        if (hasAnimation) {
            currentFrame++;
            if (currentFrame >= data.getAnimation().getDelay()) {
                currentFrame = 0;
                image = getNextFrame();
                data = getNextTileProperties();
            }
        }
    }

    private TileProperties getNextTileProperties() {
        long nextFrame = data.getAnimation().getNext();
        TileCustomMetadata[] metadata = tileSet.tileSet.getCustomData();
        for (TileCustomMetadata metadata1 : metadata) {
            if (metadata1.getTileID() == nextFrame) {
                TileProperties properties;

                try {
                    properties = Converter.fromJsonString(metadata1.getData());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return properties;
            }
        }
        return null;
    }

    @Override
    public BufferedImage getNextFrame() {
        long nextFrame = data.getAnimation().getNext();
        BufferedImage tempImage = Utils.images.scale(tileSet.getFrame((int) nextFrame),
                                                     RPGKit.tileScale,
                                                     RPGKit.tileScale);

        if (tile.getF() == 1) {
            tempImage = Utils.images.flipHorizontal(tempImage);
        } else if (tile.getF() == 2) {
            tempImage = Utils.images.flipVertical(tempImage);
        } else if (tile.getF() == 3) {
            tempImage = Utils.images.flipAll(tempImage);
        }

        return tempImage;
    }
}
