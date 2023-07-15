package managers;

import main.TileSet;
import utils.Utils;

import java.util.ArrayList;

public class TileSetManager {
    public static ArrayList<TileSet> tileSets = new ArrayList<>();

    public static TileSet getTileSet(int uid) {
        return Utils.objects.findObjectWithFieldValue(tileSets, "uid", uid);
    }
}
