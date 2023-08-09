package interactable;

import ldtk.Level;
import ldtk.TileInstance;
import main.Tile;
import main.TileSet;

import java.io.IOException;

public abstract class Interactable extends Tile {
    public Interactable(TileInstance tile, TileSet tileSet, Level level) throws IOException {
        super(tile, tileSet, level);
    }

    public abstract void interact();
}
