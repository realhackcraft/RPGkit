package entity;

import LDtk.EntityInstance;
import LDtk.FieldInstance;
import LDtk.LayerInstance;
import LDtk.Level;
import main.GamePanel;
import main.KeyHandler;
import main.TileSet;
import utils.Direction;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

import static java.awt.event.KeyEvent.*;
import static utils.Direction.*;

/**
 * The Player class represents the player entity in the game. It extends Entity class to get access to its variables and methods. It uses a GamePanel object and a KeyHandler object to initialize its position, direction and speed.
 * It loads data from the LDtk level editor using its loadDataFromLDtk() method, and updates the player's position and direction using its update() method. It also draws the player's frame using its draw() method.
 */

public class Player extends Entity {
    /**
     * The gamePanel variable refers to the GamePanel object which is responsible for handling the game graphics,
     * rendering and updating the game objects and handling the user interactions.
     * <p>
     * This variable is set as final since it is not expected to change during the course of execution once it is initialized.
     * <p>
     * Usage: Once initialized, the gamePanel variable can be used to perform various operations on the gamePanel object.
     */
    private final GamePanel gamePanel;

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
     * @param gamePanel  The GamePanel object that represents the game panel.
     * @param keyHandler The KeyHandler object that handles the key events.
     */
    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        this.tileSet = new TileSet(gamePanel.ldtk.getDefs().getTilesets()[0]);
        loadDataFromLDtk();
        loadSpritesheet();
    }

    /**
     * Cuts the sprite sheet into individual tile images and sets them in the TileSet object.
     */
    private void loadSpritesheet() {
        tileSet.cut();
    }

    /**
     * Loads game data from LDtk and extracts required information to initialize the game character.
     * Finds and sets the starting position, direction, and speed of the game character
     * based on the entity instance and its field values in the "Entities" layer of the "Level_0" level.
     *
     * @throws NullPointerException if required LDtk data cannot be found or accessed
     */
    public void loadDataFromLDtk() {
        Level[] levels = gamePanel.ldtk.getLevels();

        Level targetLevel = Utils.objects.findObjectWithFieldValue(
                List.of(levels), "identifier", "Level_0");
        if (targetLevel == null) {
            return;
        }

        LayerInstance targetLayer = Utils.objects.findObjectWithFieldValue(
                List.of(targetLevel.getLayerInstances()),
                "identifier",
                "Entities");
        if (targetLayer == null || !targetLayer.getType().equals("Entities")) {
            return;
        }

        EntityInstance targetEntity = Utils.objects.findObjectWithFieldValue(
                List.of(targetLayer.getEntityInstances()),
                "identifier",
                "PlayerStart");
        if (targetEntity == null) {
            return;
        }

        this.x = targetEntity.getPx()[0];
        this.y = targetEntity.getPx()[1];

        for (FieldInstance field : targetEntity.getFieldInstances()) {
            if (field.getIdentifier().equals("Direction")) {
                this.direction = Direction.valueOf((String) field.getValue());
            } else if (field.getIdentifier().equals("Speed")) {
                this.speed = (double) field.getValue();
            }
        }
    }

    /**
     * Updates the position, direction, and speed of the game character based on user input received via the key handler.
     * If the 'W' key is pressed, the character moves upwards and faces upwards.
     * If the 'A' key is pressed, the character moves to the left and faces to the left.
     * If the 'S' key is pressed, the character moves downwards and faces downwards.
     * If the 'D' key is pressed, the character moves to the right and faces to the right.
     *
     * @param delta the time elapsed since the last update call
     */
    @Override
    public void update(double delta) {
        if (keyHandler.isKeyPressed(VK_W)) {
            this.y -= this.speed * 10;
            this.direction = UP;
        }
        if (keyHandler.isKeyPressed(VK_A)) {
            this.x -= this.speed * 10;
            this.direction = LEFT;
        }
        if (keyHandler.isKeyPressed(VK_S)) {
            this.y += this.speed * 10;
            this.direction = DOWN;
        }
        if (keyHandler.isKeyPressed(VK_D)) {
            this.x += this.speed * 10;
            this.direction = RIGHT;
        }
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
        BufferedImage frame = switch (this.direction) {
            case UP -> tileSet.getFrame(0, 0);
            case LEFT -> tileSet.getFrame(0, 1);
            case DOWN -> tileSet.getFrame(0, 2);
            case RIGHT -> Utils.images.flipHorizontal(tileSet.getFrame(0, 1));
        };

        g2d.scale(gamePanel.tileScale, gamePanel.tileScale);
        g2d.drawImage(frame, (int) this.x, (int) this.y, gamePanel);
        g2d.scale(1, 1);
    }

}
