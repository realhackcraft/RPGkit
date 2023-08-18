package rpgkit;

import main.entity.Player;
import rpgkit.ldtk.Converter;
import rpgkit.ldtk.LDtk;
import rpgkit.managers.LayerManager;
import rpgkit.ui.UI;
import rpgkit.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * This class represents a JPanel used as the main game panel to display the game.
 * It implements the Runnable interface to allow for a threaded game loop.
 */

public class RPGKit extends JPanel implements Runnable {
    /**
     * The tileSize constant represents the size of the tile in pixels for a given game grid.
     * It is a final integer value of 16.
     */
    public final int tileSize = 16;

    public final int tileScale = 4;

    private static RPGKit INSTANCE;
    public InteractableLoader interactableLoader;
    public ItemLoader itemLoader;
    private int FPS;
    private String gameName = "RPGKit";

    public final int scaledTileSize = tileSize * tileScale;

    public int screenWidth;

    public int screenHeight;


    public LDtk ldtk;
    public final LayerManager manager = new LayerManager();

    Thread gameThread;

    public final KeyHandler keyHandler = new KeyHandler();

    public Player player;

    public static final LDtkLoader lDtkLoader = LDtkLoader.get();

    /**
     * Creates a new RPGKit with preferred dimensions based on screenWidth and screenHeight constants.
     * The panel has a white background and is double buffered.
     * It is focusable and listens to key events using keyHandler.
     */
    private RPGKit() {
        setFocusable(true);
        addKeyListener(keyHandler);
    }

    private boolean started = false;
    private JFrame frame;
    public Sound music = new Sound();
    public Sound effect = new Sound();
    public UI ui = new UI();

    public static RPGKit getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RPGKit();
        }

        return INSTANCE;
    }

    public void setInteractableLoader(InteractableLoader interactableLoader) {
        this.interactableLoader = interactableLoader;
    }

    public void setItemLoader(ItemLoader itemLoader) {
        this.itemLoader = itemLoader;
    }

    public void loadMap(String path) {
        try {
            String json = Utils.strings.loadFileAsString(path, StandardCharsets.US_ASCII);
            ldtk = Converter.fromJsonString(json);
        } catch (IOException e) {
            System.err.println("Error loading LDtk file");
        }
    }

    public void setFPS(int fps) {
        FPS = fps;
    }

    /**
     * Creates a new thread and starts the game loop.
     */
    public void start(String levelName) {
        gameThread = new Thread(this);

        lDtkLoader.loadGame(ldtk, levelName);
        lDtkLoader.centerEntity(player);
        warmup();

        ui.setRPGKit(this);

        gameThread.start();
        started = true;
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

        setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.setFont(getFont());
        g2d.drawString("", 0, 0);
        g2d.dispose();
    }

    /**
     * The run method is the main game loop where the gameplay and rendering happens.
     * It loads the JSON level data and initializes the game objects such as the player and key handler.
     * The loop then runs at a fixed FPS and updates and renders the game as needed.
     * Upon encountering an IOException while loading the JSON file, it prints a stack trace.
     */
    @Override
    public void run() {
        long lastFPSTime = System.nanoTime();

        long optimalTime = 1000000000 / FPS;
        long previous = System.nanoTime();
        long lag = 0;

        while (gameThread != null) {
            long current = System.nanoTime();
            long elapsed = current - previous;
            previous = current;
            lag += elapsed;

            // update
            while (lag >= optimalTime) {
                update(elapsed / 1000000.0);
                lag -= optimalTime;
            }

            // render
            repaint();

            if (System.nanoTime() - lastFPSTime >= 1000000000) {
                frame.setTitle(gameName + " [" + FPS + " FPS]");
                lastFPSTime = System.nanoTime();
            }

            // Sleep until the next frame
            try {
                long sleepTime = (previous - System.nanoTime() + optimalTime) / 1000000;
                if (sleepTime > 0) {
                    //noinspection BusyWait
                    Thread.sleep(sleepTime);
                }
            } catch (Exception e) {
                System.err.println("Error sleeping");
            }
        }
    }

    public void setGameName(String name) {
        gameName = name;
    }
}
