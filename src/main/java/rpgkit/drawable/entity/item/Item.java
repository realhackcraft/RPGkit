package rpgkit.drawable.entity.item;

import rpgkit.Sound;
import rpgkit.TileSet;
import rpgkit.drawable.entity.Entity;
import rpgkit.ldtk.TilesetRectangle;
import rpgkit.manager.EntityManger;
import rpgkit.util.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Item extends Entity {
    public final TilesetRectangle rectangle;
    public BufferedImage image;

    public Item(EntityManger entityManger, TileSet tileSet, TilesetRectangle rectangle) {
        super(entityManger);
        this.tileSet = tileSet;
        this.rectangle = rectangle;

        image = tileSet.getFrame((int) (rectangle.getX() / tileSet.tileSize),
                                 (int) (rectangle.getY() / tileSet.tileSize));
    }

    public void interact() {
        entityManger.entities.remove(this);
        Sound effect = RPGKit.effect;
        effect.setSoundFile("/sounds/powerUp.wav");
        effect.play();
    }

    public void testForInteraction() {
        if (Utils.game.calculateDistance(this.worldPosition, RPGKit.player.worldPosition) < this.tileSet.tileSize) {
            interact();
        }
    }

    @Override
    public void update(double delta) {
        super.update(delta);
        testForInteraction();
    }

    @Override
    public void draw(Graphics2D g2d) {
        if (Utils.game.isOffScreen(screenPosition)) return;

        g2d.drawImage(image,
                      (int) screenPosition[0],
                      (int) screenPosition[1],
                      RPGKit);
    }
}
