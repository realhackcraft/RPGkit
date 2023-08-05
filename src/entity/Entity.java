package entity;

import main.Drawable;
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
}
