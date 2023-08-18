package main;

import main.entity.item.ObsidianSword;
import main.interactable.Farm;
import rpgkit.RPGKit;
import rpgkit.Sound;
import rpgkit.managers.TileSetManager;

import javax.swing.*;
import java.util.List;

/**
 * The Main class is responsible for starting the game by creating a new JFrame
 * with the title and adding a RPGKit to it. The game loop in
 * RPGKit is started, and the frame is displayed.
 */

public class Main {
    public static Mode mode = Mode.PRODUCTION;

    /**
     * Sets up and runs the Life Simulator 9000 game JFrame.
     *
     * @param args command line arguments, not used
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            mode = Mode.valueOf(args[0].toUpperCase());
        }

        System.setProperty("sun.java2d.opengl", "True");

        JFrame frame = new JFrame("Life Simulator 9000");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        RPGKit rpgKit = rpgkit.RPGKit.getInstance();
        rpgKit.setJFrame(frame);

        rpgKit.setGameName("Life Simulator");
        rpgKit.loadMap("/maps/Test.ldtk");

        rpgKit.setItemLoader((tags, entity, entityManger) -> {
            if (tags.contains("Weapon")) {
                return new ObsidianSword(entityManger, TileSetManager.getTileSet("Weapons"), entity.getTile());
            }
            return null;
        });

        rpgKit.setInteractableLoader((interaction, tile, tileset, targetLevel, properties) -> {
            switch (interaction) {
                case "farm" -> {
                    return new Farm(tile, tileset, targetLevel, properties);
                }
            }
            return null;
        });

        Sound.loadSounds(List.of("/sounds/pickupCoin.wav", "/sounds/powerUp.wav"));

        rpgKit.start("Level_0");

        frame.add(rpgKit);
        frame.pack();


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public enum Mode {
        PRODUCTION,
        TEST
    }
}
