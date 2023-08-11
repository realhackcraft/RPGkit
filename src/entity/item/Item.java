package entity.item;

import entity.Entity;
import ldtk.TilesetRectangle;
import main.GamePanel;
import main.TileSet;
import managers.EntityManger;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Item extends Entity {
    TilesetRectangle rectangle;

    public Item(EntityManger entityManger, TileSet tileSet, TilesetRectangle rectangle) {
        this.gamePanel = GamePanel.getInstance();
        this.entityManger = entityManger;
        this.tileSet = tileSet;
        this.rectangle = rectangle;
    }

    public void interact() {
        if (Utils.game.calculateDistance(this.worldPosition, gamePanel.player.worldPosition) < this.tileSet.tileSize) {
            gamePanel.player.inventory.add(this);
            entityManger.entities.remove(this);
        }
    }

    @Override
    public void update(double delta) {
        super.update(delta);
        interact();
    }

    @Override
    public void draw(Graphics2D g2d) {
        BufferedImage image = tileSet.getFrame((int) (rectangle.getX() / tileSet.tileSize),
                                               (int) (rectangle.getY() / tileSet.tileSize));
        image = Utils.images.scale(image, gamePanel.tileScale, gamePanel.tileScale);
        g2d.drawImage(image,
                      (int) screenPosition[0],
                      (int) screenPosition[1],
                      gamePanel);
    }
}
