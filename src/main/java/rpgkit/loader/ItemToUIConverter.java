package rpgkit.loader;

import rpgkit.drawable.ui.item.Item;

public interface ItemToUIConverter {
    Item convertToUIItem(rpgkit.drawable.entity.item.Item item, int count);
}
