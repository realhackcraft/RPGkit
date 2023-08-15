package entity.item;

import entity.Entity;
import ldtk.TilesetRectangle;
import main.Sound;
import main.TileSet;
import managers.EntityManger;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Item extends Entity {
    public TilesetRectangle rectangle;
    public BufferedImage image;

    public Item(EntityManger entityManger, TileSet tileSet, TilesetRectangle rectangle) {
        super(entityManger);
        this.tileSet = tileSet;
        this.rectangle = rectangle;

        image = tileSet.getFrame((int) (rectangle.getX() / tileSet.tileSize),
                                 (int) (rectangle.getY() / tileSet.tileSize));
        image = Utils.images.scale(image, gamePanel.tileScale, gamePanel.tileScale);
    }

    public void interact() {
        entityManger.entities.remove(this);
        Sound sound = gamePanel.sound;
        sound.setSoundFile("/sounds/powerUp.wav");
        sound.play();
    }

    public void testForInteraction() {
        if (Utils.game.calculateDistance(this.worldPosition, gamePanel.player.worldPosition) < this.tileSet.tileSize) {
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
                      gamePanel);
    }
}
