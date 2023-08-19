package rpgkit.loader;

import rpgkit.drawable.entity.item.Item;
import rpgkit.ldtk.EntityInstance;
import rpgkit.manager.EntityManger;

import java.util.List;

public interface ItemLoader {
    Item loadItem(List<String> tags, EntityInstance entity, EntityManger entityManger);
}
