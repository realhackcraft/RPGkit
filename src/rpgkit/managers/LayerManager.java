package rpgkit.managers;

import rpgkit.Drawable;

import java.awt.*;
import java.util.ArrayList;

public class LayerManager implements Drawable {
    public final ArrayList<Manager> managers = new ArrayList<>();

    @Override
    public void draw(Graphics2D g2d) {
        for (int i = managers.size() - 1; i >= 0; i--) {
            managers.get(i).draw(g2d);
        }
    }

    @Override
    public void update(double delta) {
        for (Manager manager : managers) {
            manager.update(delta);
        }
    }
}
