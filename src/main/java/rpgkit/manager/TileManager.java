package rpgkit.manager;

import rpgkit.Tile;

import java.awt.*;
import java.util.ArrayList;

public class TileManager extends Manager {
    public final ArrayList<Tile> tiles = new ArrayList<>();

    @Override
    public void draw(Graphics2D g2d) {
        for (Tile tile : tiles) {
            tile.draw(g2d);
        }
    }

    @Override
    public void update(double delta) {
        for (Tile tile : tiles) {
            tile.update(delta);
        }
    }
}
