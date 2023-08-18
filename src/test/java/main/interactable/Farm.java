package main.interactable;

import rpgkit.TileSet;
import rpgkit.interactable.Interactable;
import rpgkit.ldtk.Level;
import rpgkit.ldtk.TileInstance;
import rpgkit.ldtk.tile.TileProperties;

import java.awt.*;
import java.io.IOException;

public class Farm extends Interactable {

    public Farm(TileInstance tile, TileSet tileSet, Level level, TileProperties properties) throws IOException {
        super(tile, tileSet, level, properties);
    }

    @Override
    public void interact() {
        if (RPGKit.player.hitbox.intersects(hitbox)) {
            System.out.println("Interacted with farm.");
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);
    }
}
