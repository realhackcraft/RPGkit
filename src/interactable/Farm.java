package interactable;

import ldtk.Level;
import ldtk.TileInstance;
import main.TileSet;

import java.io.IOException;

import static java.awt.event.KeyEvent.VK_E;

public class Farm extends Interactable {

    public Farm(TileInstance tile, TileSet tileSet, Level level) throws IOException {
        super(tile, tileSet, level);
    }

    @Override
    public void interact() {
        System.out.println("Interacted with farm.");
    }

    @Override
    public void update(double delta) {
        super.update(delta);
        if (gamePanel.keyHandler.isKeyPressed(VK_E)) {
            if (gamePanel.player.hitbox.intersects(this.hitbox)) {
                interact();
            }
        }
    }
}
