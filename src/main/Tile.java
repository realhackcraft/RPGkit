package main;

import LDtk.TileInstance;

public class Tile {
    public TileSet tileSet;
    public long[] worldPosition;
    public long[] screenPosition = new long[2];
    public long[] tileSetPosition;

    public Tile(TileInstance tile, TileSet tileSet) {
        this.tileSet = tileSet;

        this.worldPosition = tile.getPx();
        this.tileSetPosition = tile.getSrc();
    }
}
