package rpgkit.ui.item;

import rpgkit.Drawable;
import rpgkit.RPGKit;
import rpgkit.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Item implements Drawable {
    private final RPGKit RPGKit;
    public long[] screenPosition = null;
    private BufferedImage image;
    public int count;

    public Item(rpgkit.entity.item.Item item, int count) {
        this.RPGKit = rpgkit.RPGKit.getInstance();
        this.image = item.tileSet.getFrame((int) (item.rectangle.getX() / item.tileSet.tileSize),
                                           (int) (item.rectangle.getY() / item.tileSet.tileSize));
        this.image = Utils.images.scale(image, RPGKit.tileScale, RPGKit.tileScale);
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
                      RPGKit);
    }

    public void add(int count) {
        this.count += count;
    }

    public void remove(int count) {
        this.count -= count;
    }
}
