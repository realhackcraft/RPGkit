package rpgkit;

import main.entity.item.Item;
import rpgkit.ldtk.EntityInstance;
import rpgkit.managers.EntityManger;

import java.util.List;

public interface ItemLoader {
    Item loadItem(List<String> tags, EntityInstance entity, EntityManger entityManger);
}
