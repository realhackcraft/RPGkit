package entity;

import main.KeyHandler;
import main.Main;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The Player class represents the player entity in the game. It extends Entity class to get access to its variables and methods. It uses a GamePanel object and a KeyHandler object to initialize its position, direction and speed.
 * It loads data from the LDtk level editor using its loadDataFromLDtk() method, and updates the player's position and direction using its update() method. It also draws the player's frame using its draw() method.
 */

public class Player extends Entity {
    /**
     * This class represents a Key Handler that is responsible for handling all types of keyboard events/inputs,
     * including key presses and key releases.
     * <p>
     * The "keyHandler" variable is declared as a constant (final) object of type "KeyHandler", which can be used
     * to manage and handle all keyboard events/inputs seamlessly and efficiently.
     * <p>
     * Note that this variable has private access, which means that it can only be accessed within the current class.
     * This ensures that the key handling logic is encapsulated within a single class and is not exposed or modified
     * by any other external classes in the application.
     */
    private final KeyHandler keyHandler;

    /**
     * Initializes a new instance of the Player class with the specified GamePanel and KeyHandler.
     *
     * @param keyHandler The KeyHandler object that handles the key events.
     */
    public Player(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
    }

    /**
     * Draws the game character onto the game panel with the provided graphics context.
     * The character's image is determined by the current direction it is facing, and
     * is selected from the tile set image using the character's position and direction.
     * The image is then scaled to fit the game's tile scale, drawn onto the game panel
     * at the character's current position.
     *
     * @param g2d the graphics context used to draw the character onto the game panel.
     * @
     */
    @Override
    public void draw(Graphics2D g2d) {
        BufferedImage frame = switch (direction) {
            case UP -> tileSet.getFrame(0, 0);
            case LEFT -> tileSet.getFrame(1, 0);
            case DOWN -> tileSet.getFrame(2, 0);
            case RIGHT -> Utils.images.flipHorizontal(tileSet.getFrame(1, 0));
        };

        frame = Utils.images.scale(frame, gamePanel.tileScale, gamePanel.tileScale);
        g2d.drawImage(frame, (int) screenPosition[0], (int) screenPosition[1], gamePanel);

        if (Main.mode == Main.Mode.TEST) {
            g2d.setColor(Color.YELLOW);
            g2d.fill(hitbox);
        }
    }
}
