package entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class Spritesheet {
    ArrayList<BufferedImage> frames = new ArrayList<>();

    private int spriteWidth;
    private int spriteHeight;
    private int colCount;
    private int rowCount;
    private int marginX;
    private int marginY;
    private BufferedImage image;

    public Spritesheet(int spriteWidth, int spriteHeight) {
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
        this.marginX = 0;
        this.marginY = 0;
    }

    public Spritesheet(int spriteWidth, int spriteHeight, int marginX, int marginY) {
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
        this.marginX = marginX;
        this.marginY = marginY;
    }

    public Spritesheet(BufferedImage image, int spriteWidth, int spriteHeight) {
        this.image = image;
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
        this.colCount = image.getWidth() / spriteWidth;
        this.rowCount = image.getHeight() / spriteHeight;
        this.marginX = 0;
        this.marginY = 0;
    }

    public Spritesheet(BufferedImage image, int spriteWidth, int spriteHeight, int marginX, int marginY) {
        this.image = image;
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
        this.colCount = image.getWidth() / spriteWidth + marginX;
        this.rowCount = image.getHeight() / spriteHeight + marginY;
        this.marginX = marginX;
        this.marginY = marginY;
    }

    public BufferedImage getFrame(int frame) {
        return frames.get(frame);
    }

    public BufferedImage getFrame(int row, int col) {
        return frames.get(col + row * colCount);
    }

    public void loadImage(BufferedImage image) {
        this.image = image;
        this.colCount = image.getWidth() / spriteWidth;
        this.rowCount = image.getHeight() / spriteHeight;
    }

    public void loadImage(String path) {
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource(path)));
            this.colCount = image.getWidth() / spriteWidth;
            this.rowCount = image.getHeight() / spriteHeight;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cut(BufferedImage image, int spriteWidth, int spriteHeight, int marginX, int marginY) {
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
        this.marginX = marginX;
        this.marginY = marginY;

        for (int y = 0; y < image.getHeight(); y += spriteHeight + marginY) {
            for (int x = 0; x < image.getWidth(); x += spriteWidth + marginX) {
                BufferedImage sprite = image.getSubimage(x, y, spriteWidth, spriteHeight);
                frames.add(sprite);
            }
        }
    }

    public void cut(BufferedImage image) {
        cut(image, spriteWidth, spriteHeight, marginX, marginY);
    }

    public void cut(int spriteWidth, int spriteHeight, int marginX, int marginY) {
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
        this.marginX = marginX;
        this.marginY = marginY;

        for (int y = 0; y < this.image.getHeight(); y += spriteHeight + marginY) {
            for (int x = 0; x < this.image.getWidth(); x += spriteWidth + marginX) {
                BufferedImage sprite = this.image.getSubimage(x, y, spriteWidth, spriteHeight);
                frames.add(sprite);
            }
        }
    }

    public void cut(int spriteWidth, int spriteHeight) {
        cut(spriteWidth, spriteHeight, this.marginX, this.marginY);
    }

    public void cut() {
        cut(this.image, this.spriteWidth, this.spriteHeight, this.marginX, this.marginY);
    }

}
