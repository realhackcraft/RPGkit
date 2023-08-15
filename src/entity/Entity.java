package entity;

import main.Camera;
import main.Drawable;
import main.GamePanel;
import main.TileSet;
import managers.EntityManger;
import utils.Direction;

import java.awt.*;

public abstract class Entity implements Drawable {
    public final double[] screenPosition = new double[2];
    public final double[] worldPosition = new double[2];
    public EntityManger entityManger;
    public double width;
    public double height;
    public GamePanel gamePanel;

    /**
     * Represents the speed of an object.
     */
    public double speed;

    /**
     * Represents a set of tiles used for rendering a map.
     * Contains information about the tiles' images, positions, and other properties.
     */
    public TileSet tileSet;

    /**
     * Represents a direction that can be used to move objects in a game or application.
     */
    public Direction direction;
    public Rectangle hitbox;
    public boolean collision = false;

    public Entity() {
        this.gamePanel = GamePanel.getInstance();
    }

    public Entity(EntityManger entityManger) {
        this();
        this.entityManger = entityManger;
    }

    @Override
    public void update(double delta) {
        screenPosition[0] = worldPosition[0] * gamePanel.tileScale + Camera.xOffset;
        screenPosition[1] = worldPosition[1] * gamePanel.tileScale + Camera.yOffset;

        if (collision) {
            hitbox.x = (int) ((int) screenPosition[0] + (width * gamePanel.tileScale / 2) - hitbox.width / 2);
            hitbox.y = (int) ((int) screenPosition[1] + (width * gamePanel.tileScale / 2) - hitbox.width / 2);
        }
    }
}
