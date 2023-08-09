package managers;

import interactable.Interactable;

import java.awt.*;
import java.util.ArrayList;

public class InteractableManager extends Manager {
    public final ArrayList<Interactable> interactables = new ArrayList<>();

    @Override
    public void draw(Graphics2D g2d) {
        for (Interactable interactable : interactables) {
            interactable.draw(g2d);
        }
    }

    @Override
    public void update(double delta) {
        for (Interactable interactable : interactables) {
            interactable.update(delta);
        }
    }
}
