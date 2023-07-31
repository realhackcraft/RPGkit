package managers;

import main.Drawable;

import java.awt.*;
import java.util.ArrayList;

public class LayerManager implements Drawable {
    public ArrayList<Drawable> drawables = new ArrayList<>();

    @Override
    public void draw(Graphics2D g2d) {
        for (int i = drawables.size() - 1; i >= 0; i--) {
            drawables.get(i).draw(g2d);
        }
    }

    @Override
    public void update(double delta) {
        for (Drawable drawable : drawables) {
            drawable.update(delta);
        }
    }
}
