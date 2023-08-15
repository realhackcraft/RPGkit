package interactable;

import ldtk.Level;
import ldtk.TileInstance;
import ldtk.tile.TileProperties;
import main.TileSet;

import java.awt.*;
import java.io.IOException;

public class Farm extends Interactable {

    public Farm(TileInstance tile, TileSet tileSet, Level level, TileProperties properties) throws IOException {
        super(tile, tileSet, level, properties);
    }

    @Override
    public void interact() {
        if (gamePanel.player.hitbox.intersects(hitbox)) {
            System.out.println("Interacted with farm.");
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);
    }
}
