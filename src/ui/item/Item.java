package ui.item;

import main.Drawable;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Item implements Drawable {
    private final GamePanel gamePanel;
    public long[] screenPosition = null;
    private BufferedImage image;
    public int count;

    public Item(entity.item.Item item, int count) {
        this.gamePanel = GamePanel.getInstance();
        this.image = item.tileSet.getFrame((int) (item.rectangle.getX() / item.tileSet.tileSize),
                                           (int) (item.rectangle.getY() / item.tileSet.tileSize));
        this.image = utils.Utils.images.scale(image, gamePanel.tileScale, gamePanel.tileScale);
        this.count = count;
    }

    public void setScreenPosition(long[] screenPosition) {
        this.screenPosition = screenPosition;
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(image,
                      (int) screenPosition[0],
                      (int) screenPosition[1],
                      gamePanel);
    }

    public void add(int count) {
        this.count += count;
    }

    public void remove(int count) {
        this.count -= count;
    }
}
