package managers;

import entity.Entity;
import main.Drawable;

import java.awt.*;
import java.util.ArrayList;

public class EntityManger implements Drawable {
    public ArrayList<Entity> entities = new ArrayList<>();

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
