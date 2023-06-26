package entity;

import utils.Direction;

import java.awt.*;

public abstract class Entity {
    /**
     * This variable represents a floating-point value of type {@code double}.
     * It can be used to store and manipulate decimal numbers with a higher precision than the {@code float} data type.
     */
    public double x;

    /**
     * Represents a floating-point number that can be accessed and modified.
     * The value of y can be any valid double-precision floating-point number.
     * It is recommended that the variable be named with a descriptive name
     * to indicate its purpose in the program.
     *
     * @since (the version number when this variable was first introduced)
     */
    public double y;

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

    /**
     * Updates the object based on the given time delta.
     *
     * @param delta The time elapsed in seconds since the last update.
     */
    public abstract void update(double delta);

    /**
     * Draws the object using the given Graphics2D object.
     *
     * @param g2d The Graphics2D object used for drawing.
     */
    public abstract void draw(Graphics2D g2d);
}
