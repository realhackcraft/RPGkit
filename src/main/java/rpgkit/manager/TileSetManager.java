package rpgkit.manager;

import rpgkit.TileSet;

import java.util.ArrayList;

public class TileSetManager {
    public static final ArrayList<TileSet> tileSets = new ArrayList<>();

    public static TileSet getTileSet(String identifier) {
        for (TileSet tileSet : tileSets) {
            if (tileSet.identifier.equals(identifier)) {
                return tileSet;
            }
        }

        return null;
    }
}
