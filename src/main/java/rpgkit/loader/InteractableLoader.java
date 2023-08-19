package rpgkit.loader;

import rpgkit.TileSet;
import rpgkit.interactable.Interactable;
import rpgkit.ldtk.Level;
import rpgkit.ldtk.TileInstance;
import rpgkit.ldtk.tile.TileProperties;

import java.io.IOException;

public interface InteractableLoader {
    Interactable loadInteractable(String interaction, TileInstance tile, TileSet tileset, Level targetLevel, TileProperties properties) throws IOException;
}
