package rpgkit.ldtk;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Type of the layer as Haxe Enum Possible values: `IntGrid`, `Entities`, `Tiles`,
 * `AutoLayer`
 */
public enum Type {
    AUTO_LAYER, ENTITIES, INT_GRID, TILES;

    @JsonValue
    public String toValue() {
        switch (this) {
            case AUTO_LAYER: return "AutoLayer";
            case ENTITIES: return "Entities";
            case INT_GRID: return "IntGrid";
            case TILES: return "Tiles";
        }
        return null;
    }

    @JsonCreator
    public static Type forValue(String value) throws IOException {
        if (value.equals("AutoLayer")) return AUTO_LAYER;
        if (value.equals("Entities")) return ENTITIES;
        if (value.equals("IntGrid")) return INT_GRID;
        if (value.equals("Tiles")) return TILES;
        throw new IOException("Cannot deserialize Type");
    }
}
