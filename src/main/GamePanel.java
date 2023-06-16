package main;

import LDtk.Converter;
import LDtk.LDtk;
import entity.Player;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class GamePanel extends JPanel implements Runnable {
    public final int tileSize = 16;
    public final int tileScale = 4;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    private static final int FPS = 120;
    public final int scaledTileSize = tileSize * tileScale;
    public final int screenWidth = scaledTileSize * maxScreenCol;
    public final int screenHeight = scaledTileSize * maxScreenRow;

    public LDtk ldtk;
    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();
    Player player;

    public GamePanel() {
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(keyHandler);
    }

    public void start() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        try {
            String json = Utils.strings.loadFileAsString("/world/Test.ldtk", StandardCharsets.US_ASCII);
            ldtk = Converter.fromJsonString(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        player = new Player(this, keyHandler);

        double drawInterval = 1000000000.0 / FPS;
        double deltaRatio = 0;
        double delta = 0;
        long lastTime = System.nanoTime();
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
        }
    }

    public void update(double delta) {
        player.update(delta);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        try {
            player.draw(g2d);
        } catch (NullPointerException e) {
            System.err.println("Player not initialized yet");
        }
        g2d.dispose();
    }
}
