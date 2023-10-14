package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

/**
 * Type of the layer as Haxe Enum Possible values: `IntGrid`, `Entities`, `Tiles`,
 * `AutoLayer`
 */
public enum Type {
    AUTO_LAYER, ENTITIES, INT_GRID, TILES;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case AUTO_LAYER -> "AutoLayer";
            case ENTITIES -> "Entities";
            case INT_GRID -> "IntGrid";
            case TILES -> "Tiles";
        };
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
