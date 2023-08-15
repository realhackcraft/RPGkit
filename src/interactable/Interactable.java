package interactable;

import ldtk.Level;
import ldtk.TileInstance;
import ldtk.tile.TileProperties;
import main.Tile;
import main.TileSet;

import java.io.IOException;

public abstract class Interactable extends Tile {
    public Interactable(TileInstance tile, TileSet tileSet, Level level, TileProperties properties) throws IOException {
        super(tile, tileSet, level, properties);
    }

    public abstract void interact();

    @Override
    public void update(double delta) {
        super.update(delta);
        interact();
    }
}
