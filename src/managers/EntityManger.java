package managers;

import entity.Entity;

import java.awt.*;
import java.util.ArrayList;

public class EntityManger extends Manager {
    public final ArrayList<Entity> entities = new ArrayList<>();

    @Override
    public void draw(Graphics2D g2d) {
        for (Entity entity : entities) {
            entity.draw(g2d);
        }
    }

    @Override
    public void update(double delta) {
        for (Entity entity : entities) {
            entity.update(delta);
        }
    }
}
