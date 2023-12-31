package main;

import main.interactable.Farm;
import rpgkit.RPGKit;
import rpgkit.Sound;
import rpgkit.manager.TileSetManager;

import javax.swing.*;
import java.util.List;

/**
 * The Main class is responsible for starting the game by creating a new JFrame
 * with the title and adding a RPGKit to it. The game loop in
 * RPGKit is started, and the frame is displayed.
 */

public class Main {
    /**
     * Sets up and runs the Life Simulator 9000 game JFrame.
     *
     * @param args command line arguments, not used
     */
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "True");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        RPGKit rpgKit = RPGKit.getInstance();
        rpgKit.setJFrame(frame);

        rpgKit.setGameName("Life Simulator");
        rpgKit.loadMap("/maps/Test.ldtk");

        rpgKit.setItemLoader((tags, entity, entityManger) -> {
            if (tags.contains("Weapon")) {
                return new main.entity.item.ObsidianSword(entityManger,
                                                          TileSetManager.getTileSet("Weapons"),
                                                          entity.getTile());
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

        rpgKit.setItemToUIConverter((itemEntity, count) -> {
            if (itemEntity.getClass() == main.entity.item.ObsidianSword.class) {
                return new main.ui.item.ObsidianSword(itemEntity, count);
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
}
