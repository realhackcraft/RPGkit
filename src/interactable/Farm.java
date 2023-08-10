package interactable;

import ldtk.Level;
import ldtk.TileInstance;
import main.TileSet;

import java.awt.*;
import java.io.IOException;

public class Farm extends Interactable {

    public Farm(TileInstance tile, TileSet tileSet, Level level) throws IOException {
        super(tile, tileSet, level);
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
