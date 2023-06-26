package main;

import javax.swing.*;

/**
 * The Main class is responsible for starting the game by creating a new JFrame
 * with the title and adding a GamePanel to it. The game loop in
 * GamePanel is started, and the frame is displayed.
 */

public class Main {
    /**
     * Sets up and runs the Mining For Gold game JFrame.
     *
     * @param args command line arguments, not used
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mining For Gold");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        gamePanel.start();
        frame.add(gamePanel);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}