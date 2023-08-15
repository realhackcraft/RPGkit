package entity.item;

import ldtk.TilesetRectangle;
import main.TileSet;
import managers.EntityManger;

public class ObsidianSword extends Item {
    public ObsidianSword(EntityManger entityManger, TileSet tileSet, TilesetRectangle rectangle) {
        super(entityManger, tileSet, rectangle);
    }

    @Override
    public void interact() {
        super.interact();
        gamePanel.ui.addItem(this);
    }
}
