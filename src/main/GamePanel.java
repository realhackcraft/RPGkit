package main;

import entity.Player;
import ldtk.Converter;
import ldtk.LDtk;
import managers.LayerManager;
import ui.UI;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * This class represents a JPanel used as the main game panel to display the game.
 * It implements the Runnable interface to allow for a threaded game loop.
 */

public class GamePanel extends JPanel implements Runnable {
    /**
     * The tileSize constant represents the size of the tile in pixels for a given game grid.
     * It is a final integer value of 16.
     */
    public final int tileSize = 16;

    /**
     * Represents the scaling factor used for rendering tiles.
     * The value is an integer constant of 4.
     */
    public final int tileScale = 4;

    /**
     * Frames per second for the application.
     * <p>
     * This variable represents the constant frames per second that the application is rendered at.
     * A higher value will result in smoother animations at the cost of increased CPU usage.
     *
     * @since 1.0.0
     */
    private static int FPS;

    /**
     * The size of a single tile after applying the tile scale factor.
     * This value is calculated by multiplying the base tile size with the tile scale factor.
     */
    public final int scaledTileSize = tileSize * tileScale;

    /**
     * The width of the screen in pixels.
     * This is calculated by multiplying the scaledTileSize by the maximum number
     * of screen columns.
     */
    public int screenWidth;

    /**
     * The constant variable that represents the height of the screen, calculated by multiplying the scaled tile size and the maximum number of rows that the screen can contain.
     * This variable is shared across all instances of the application and cannot be modified once initialized.
     */
    public int screenHeight;


    /**
     * The LDtk variable is an instance of the LDtk engine. This class handles the loading and
     * extraction of data from LDtk files, which are JSON files exported from the LDtk editor.
     * <p>
     * This variable can be used to access the data and metadata of an LDtk project. It provides
     * methods and properties for accessing levels, layers, enums, tilesets, and other elements
     * of an LDtk project.
     * <p>
     * To use the LDtk engine, you first need to load an LDtk file using the LDtk.load() method.
     * Once the file is loaded, you can access the data and metadata using the properties and
     * methods of the LDtk object.
     */
    public LDtk ldtk;
    public final LayerManager manager = new LayerManager();

    /**
     * The game thread which is responsible for running the game loop and updating the game state.
     * <p>
     * This thread is started when the game starts and is terminated when the game is stopped.
     * It runs continuously and updates the game state at regular intervals.
     */
    Thread gameThread;

    /**
     * KeyHandler class is responsible for handling key events.
     * It provides methods to register listeners and notify them when a key event occurs.
     */
    public final KeyHandler keyHandler = new KeyHandler();

    public Player player;

    public static final LDtkLoader lDtkLoader = LDtkLoader.get();

    private static GamePanel INSTANCE;
    private boolean started = false;
    private JFrame frame;
    public Sound sound = new Sound();
    public Sound effect = new Sound();
    public UI ui = new UI();

    /**
     * Creates a new GamePanel with preferred dimensions based on screenWidth and screenHeight constants.
     * The panel has a white background and is double buffered.
     * It is focusable and listens to key events using keyHandler.
     */
    private GamePanel() {
        setBackground(new Color(0x51A7E8));
        setFocusable(true);
        addKeyListener(keyHandler);
    }

    /**
     * Creates a new thread and starts the game loop.
     */
    public void start() {
        gameThread = new Thread(this);

        try {
            String json = Utils.strings.loadFileAsString("/maps/Test.ldtk", StandardCharsets.US_ASCII);
            ldtk = Converter.fromJsonString(json);
        } catch (IOException e) {
            System.err.println("Error loading LDtk file");
        }

        lDtkLoader.loadGame(ldtk);
        Sound.loadSounds(List.of("/sounds/pickupCoin.wav", "/sounds/powerUp.wav"));
        warmup();

        gameThread.start();
        started = true;
    }

    /**
     * The run method is the main game loop where the gameplay and rendering happens.
     * It loads the JSON level data and initializes the game objects such as the player and key handler.
     * The loop then runs at a fixed FPS and updates and renders the game as needed.
     * Upon encountering an IOException while loading the JSON file, it prints a stack trace.
     */
    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double deltaRatio = 0;
        double delta = 0;
        long lastTime = System.nanoTime();
        long lastFPSTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            deltaRatio += (currentTime - lastTime) / drawInterval;
            delta += (currentTime - lastTime) / 1000000.0;
            lastTime = currentTime;

            if (deltaRatio >= 1) {
                update(delta);
                repaint();
                deltaRatio--;
                delta = 0;
            }

            if (System.nanoTime() - lastFPSTime >= 1000000000) {
                frame.setTitle("Life Simulator [" + FPS + " FPS]");
                lastFPSTime = System.nanoTime();
            }
        }
    }

    /**
     * Updates the game state based on the elapsed time since last update.
     *
     * @param delta time in milliseconds since last update
     */
    public void update(double delta) {
        manager.update(delta);
        ui.update(delta);
        Movement.computeMovements(keyHandler, delta);
    }

    /**
     * Paints the component using the specified graphics context. Calls the draw method to render the contents.
     *
     * @param g the graphics context to use for painting
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    /**
     * Renders the game contents onto the screen using the specified graphics context.
     *
     * @param g the graphics context to use for rendering the game
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        manager.draw(g2d);
        ui.draw(g2d);
        g2d.dispose();
    }

    public void setJFrame(JFrame frame) {
        this.frame = frame;
        GraphicsDevice gd = frame.getGraphicsConfiguration().getDevice();
        DisplayMode dm = gd.getDisplayMode();
        screenWidth = dm.getWidth();
        screenHeight = dm.getHeight();
        setPreferredSize(new Dimension(screenWidth, screenHeight));

        if (started) {
            return;
        }
        FPS = dm.getRefreshRate();
    }

    private void warmup() {
        BufferedImage tempImg = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = tempImg.createGraphics();

        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.setColor(Color.WHITE);
        g2d.drawString("Warmup", 0, 0);
        g2d.dispose();
    }


    public static GamePanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GamePanel();
        }

        return INSTANCE;
    }
}
