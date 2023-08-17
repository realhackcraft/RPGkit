package rpgkit.managers;

import rpgkit.entity.Entity;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class EntityManger extends Manager {
    public final CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<>();

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
