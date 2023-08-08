package entity;

import main.Camera;
import main.Drawable;
import main.GamePanel;
import main.TileSet;
import utils.Direction;

import java.awt.*;

public abstract class Entity implements Drawable {
    public double[] screenPosition = new double[2];
    public double[] worldPosition = new double[2];
    public double width;
    public double height;

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

    @Override
    public void update(double delta) {
        this.screenPosition[0] = (worldPosition[0] * GamePanel.getInstance().tileScale) + Camera.xOffset;
        this.screenPosition[1] = (worldPosition[1] * GamePanel.getInstance().tileScale) + Camera.yOffset;

        this.hitbox.x = (int) ((int) this.screenPosition[0] + (this.width * GamePanel.getInstance().tileScale / 2) - this.hitbox.width / 2);
        this.hitbox.y = (int) ((int) this.screenPosition[1] + (this.width * GamePanel.getInstance().tileScale / 2) - this.hitbox.width / 2);
    }
}
