package managers;

import main.TileSet;
import utils.Utils;

import java.util.ArrayList;

public class TileSetManager {
    public static final ArrayList<TileSet> tileSets = new ArrayList<>();

    public static TileSet getTileSet(String identifier) {
        return Utils.objects.findObjectWithFieldValue(tileSets, "identifier", identifier);
    }
}
