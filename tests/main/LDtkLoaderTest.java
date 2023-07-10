package main;

import LDtk.Converter;
import LDtk.LDtk;
import org.junit.jupiter.api.Test;
import utils.Utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LDtkLoaderTest {
    @Test
    public void testLoadTilesets() throws IOException {
        String json = Utils.strings.loadFileAsString("/world/Test.ldtk", StandardCharsets.US_ASCII);
        LDtk ldtk = Converter.fromJsonString(json);
        LDtkLoader.loadTilesets(ldtk);
        LDtkLoader.loadMap(ldtk);
        assertEquals(1, LDtkLoader.tiles.size());
    }
}
