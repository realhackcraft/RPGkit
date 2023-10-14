package rpgkit.drawable.ui;

import rpgkit.RPGKit;
import rpgkit.drawable.Drawable;
import rpgkit.drawable.ui.item.Item;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class UI implements Drawable {
    public final long[] nextScreenPosition = {0, 0};
    public final CopyOnWriteArrayList<Item> inventory = new CopyOnWriteArrayList<>();
    private RPGKit rpgKit;

    public long[] nextScreenPosition() {
        RPGKit RPGKit = rpgkit.RPGKit.getInstance();
        long[] screenPosition = rpgkit.RPGKit.getInstance().ui.nextScreenPosition;
        nextScreenPosition[0] += (long) (RPGKit.scaledTileSize * 1.2);
        return screenPosition;
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (Item item : inventory) {
            item.draw(g2d);
            if (item.count > 1) {
                g2d.setFont(rpgKit.getFont());
                g2d.setColor(Color.WHITE);
                g2d.drawString(String.valueOf(item.count),
                               (int) item.screenPosition[0] + rpgkit.RPGKit.getInstance().scaledTileSize,
                               (int) item.screenPosition[1] + rpgkit.RPGKit.getInstance().scaledTileSize);
            }

        }
    }

    public void setRpgKit(RPGKit rpgKit) {
        this.rpgKit = rpgKit;
    }

    @Override
    public void update(double delta) {

    }

    public void addItem(rpgkit.drawable.entity.item.Item itemEntity) {
        Item item;
        item = rpgKit.itemToUIConverter.convertToUIItem(itemEntity, 1);

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
