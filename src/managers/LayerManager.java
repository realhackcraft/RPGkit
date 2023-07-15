package managers;

import main.Drawable;

import java.awt.*;
import java.util.ArrayList;

public class LayerManager implements Drawable {
    public ArrayList<TileManager> tiles = new ArrayList<>();

    @Override
    public void draw(Graphics2D g2d) {
        for (int i = tiles.size() - 1; i > 0; i--) {
            tiles.get(i).draw(g2d);
        }
    }

    @Override
    public void update(double delta) {
        for (TileManager tile : tiles) {
            tile.update(delta);
        }
    }
}
