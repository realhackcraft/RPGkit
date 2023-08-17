package rpgkit.interactable;

import rpgkit.Tile;
import rpgkit.TileSet;
import rpgkit.ldtk.Level;
import rpgkit.ldtk.TileInstance;
import rpgkit.ldtk.tile.TileProperties;

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
