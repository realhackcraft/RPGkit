package ui;

import main.Drawable;
import main.GamePanel;
import ui.item.Item;
import ui.item.ObsidianSword;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class UI implements Drawable {
    public Font font = new Font("Arial", Font.PLAIN, 20);
    public long[] nextScreenPosition = {0, 0};
    public CopyOnWriteArrayList<Item> inventory = new CopyOnWriteArrayList<>();

    public long[] nextScreenPosition() {
        GamePanel gamePanel = GamePanel.getInstance();
        long[] screenPosition = GamePanel.getInstance().ui.nextScreenPosition;
        nextScreenPosition[0] += (long) (gamePanel.scaledTileSize * 1.2);
        return screenPosition;
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (ui.item.Item item : inventory) {
            item.draw(g2d);
            g2d.setFont(font);
            if (item.count > 1) {
                g2d.setColor(Color.WHITE);
                g2d.drawString(String.valueOf(item.count),
                               (int) item.screenPosition[0] + GamePanel.getInstance().scaledTileSize,
                               (int) item.screenPosition[1] + GamePanel.getInstance().scaledTileSize);
            }

        }
    }

    @Override
    public void update(double delta) {

    }

    public void addItem(entity.item.Item itemEntity) {
        Item item = null;
        if (itemEntity instanceof entity.item.ObsidianSword) {
            item = new ObsidianSword(itemEntity, 1);
        }

        if (item == null) return;

        boolean found = false;
        for (Item inventoryItem : inventory) {
            if (inventoryItem.getClass() == item.getClass()) {
                inventoryItem.add(1);
                found = true;
                break;
            }
        }

        if (!found) {
            item.setScreenPosition(nextScreenPosition());
            inventory.add(item);
        }
    }
}
