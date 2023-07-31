package main;

import javax.swing.*;

/**
 * The Main class is responsible for starting the game by creating a new JFrame
 * with the title and adding a GamePanel to it. The game loop in
 * GamePanel is started, and the frame is displayed.
 */

public class Main {
    /**
     * Sets up and runs the Life Simulator 9000 game JFrame.
     *
     * @param args command line arguments, not used
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Life Simulator 9000");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        GamePanel gamePanel = GamePanel.getInstance();
        gamePanel.setJFrame(frame);
        gamePanel.start();
        frame.add(gamePanel);
        frame.pack();


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
