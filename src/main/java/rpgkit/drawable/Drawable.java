package rpgkit.drawable;

import java.awt.*;

public interface Drawable {
    /**
     * Draws the object using the given Graphics2D object.
     *
     * @param g2d The Graphics2D object used for drawing.
     */
    void draw(Graphics2D g2d);

    /**
     * Updates the object based on the given time delta.
     *
     * @param delta The time elapsed in seconds since the last update.
     */
    void update(double delta);
}
