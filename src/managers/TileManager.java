package managers;

import main.Drawable;
import main.Tile;

import java.awt.*;
import java.util.ArrayList;

public class TileManager implements Drawable {
    public ArrayList<Tile> tiles = new ArrayList<>();

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
