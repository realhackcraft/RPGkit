package rpgkit;

import org.junit.jupiter.api.Test;
import rpgkit.drawable.ui.item.Item;
import rpgkit.interactable.Interactable;
import rpgkit.ldtk.EntityInstance;
import rpgkit.ldtk.Level;
import rpgkit.ldtk.TileInstance;
import rpgkit.ldtk.tile.TileProperties;
import rpgkit.loader.InteractableLoader;
import rpgkit.loader.ItemLoader;
import rpgkit.loader.ItemToUIConverter;
import rpgkit.manager.EntityManger;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class RPGKitTest {
    @Test
    public void getInstance() {
        RPGKit rpgKit = RPGKit.getInstance();

        assertEquals(rpgKit, RPGKit.getInstance());
    }

    @Test
    public void setInteractableLoader() {
        RPGKit rpgKit = RPGKit.getInstance();

        class TestInteractable implements InteractableLoader {
            @Override
            public Interactable loadInteractable(String interaction, TileInstance tile, TileSet tileset, Level targetLevel, TileProperties properties) throws IOException {
                return null;
            }
        }

        rpgKit.setInteractableLoader(new TestInteractable());

        assertInstanceOf(TestInteractable.class, rpgKit.interactableLoader);
    }

    @Test
    void setItemToUIConverter() {
        RPGKit rpgKit = RPGKit.getInstance();

        class TestItemConverter implements ItemToUIConverter {
            @Override
            public Item convertToUIItem(rpgkit.drawable.entity.item.Item item, int count) {
                return null;
            }
        }

        rpgKit.setItemToUIConverter(new TestItemConverter());

        assertInstanceOf(TestItemConverter.class, rpgKit.itemToUIConverter);
    }

    @Test
    void setItemLoader() {
        RPGKit rpgKit = RPGKit.getInstance();

        class TestItemLoader implements ItemLoader {
            @Override
            public rpgkit.drawable.entity.item.Item loadItem(List<String> tags, EntityInstance entity, EntityManger entityManger) {
                return null;
            }
        }

        rpgKit.setItemLoader(new TestItemLoader());

        assertInstanceOf(TestItemLoader.class, rpgKit.itemLoader);
    }

    @Test
    void loadMap() {
        RPGKit rpgKit = RPGKit.getInstance();

        rpgKit.loadMap("/maps/test.ldtk");
        assertEquals(69, rpgKit.ldtk.getDefaultGridSize());
    }
}
