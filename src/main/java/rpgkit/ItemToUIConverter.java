package rpgkit;

import rpgkit.ui.item.Item;

public interface ItemToUIConverter {
    Item convertToUIItem(rpgkit.entity.item.Item item, int count);
}
