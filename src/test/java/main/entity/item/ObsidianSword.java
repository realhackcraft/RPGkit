package main.entity.item;

import rpgkit.TileSet;
import rpgkit.drawable.entity.item.Item;
import rpgkit.ldtk.TilesetRectangle;
import rpgkit.manager.EntityManger;

public class ObsidianSword extends Item {
    public ObsidianSword(EntityManger entityManger, TileSet tileSet, TilesetRectangle rectangle) {
        super(entityManger, tileSet, rectangle);
    }

    @Override
    public void interact() {
        super.interact();
        RPGKit.ui.addItem(this);
    }
}
