package rpgkit;

import org.junit.jupiter.api.Test;
import rpgkit.ldtk.Converter;
import rpgkit.ldtk.LDtk;

import java.io.IOException;
import java.util.Objects;

public class LDtkLoaderTest {
    @Test
    void loadTilesets() {
        LDtkLoader ldtkLoader = LDtkLoader.getInstance();

        String ldtkString = Objects.requireNonNull(getClass().getResource("/maps/test.ldtk")).getPath();

        try {
            LDtk ldtk = Converter.fromJsonString(ldtkString);
            ldtkLoader.loadTilesets(ldtk);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void loadPlayer() {
    }

    @Test
    void loadItem() {
    }

    @Test
    void loadMap() {
    }

    @Test
    void getLayers() {
    }

    @Test
    void processLayers() {
    }

    @Test
    void processEntityLayer() {
    }

    @Test
    void processTileLayer() {
    }

    @Test
    void processTileSet() {
    }

    @Test
    void getTileProperties() {
    }

    @Test
    void addTile() {
    }

    @Test
    void get() {
    }

    @Test
    void centerEntity() {
    }

    @Test
    void loadGame() {
    }
}
