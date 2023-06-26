package entity;

import LDtk.TilesetDefinition;
import utils.Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class TileSet {
    ArrayList<BufferedImage> frames = new ArrayList<>();

    private long colCount;
    private final TilesetDefinition tileSet;
    private BufferedImage image;

    public TileSet(TilesetDefinition tileSet) {
        this.tileSet = tileSet;
        loadImage('/' + Utils.paths.normalizePath("world/" + tileSet.getRelPath()));
    }

    public BufferedImage getFrame(int frame) {
        return frames.get(frame);
    }

    public BufferedImage getFrame(int row, int col) {
        return frames.get((int) (col + row * colCount));
    }

    public void loadImage(BufferedImage image) {
        this.image = image;
        this.colCount = (image.getWidth() - 2 * this.tileSet.getPadding()) / this.tileSet.getTileGridSize();
    }

    private void loadImage(String path) {
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource(path)));
            this.colCount = image.getWidth() / this.tileSet.getTileGridSize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cut() {
        for (long y = 0; y < image.getHeight(); y += this.tileSet.getTileGridSize() + this.tileSet.getSpacing()) {
            for (long x = 0; x < image.getWidth(); x += this.tileSet.getTileGridSize() + this.tileSet.getSpacing()) {
                BufferedImage sprite = image.getSubimage((int) x,
                                                         (int) y,
                                                         (int) this.tileSet.getTileGridSize(),
                                                         (int) this.tileSet.getTileGridSize());
                frames.add(sprite);
            }
        }
    }
}
