package ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

/**
 * Possible values: `Rectangle`, `Ellipse`, `Tile`, `Cross`
 */
public enum RenderMode {
    CROSS, ELLIPSE, RECTANGLE, TILE;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case CROSS -> "Cross";
            case ELLIPSE -> "Ellipse";
            case RECTANGLE -> "Rectangle";
            case TILE -> "Tile";
        };
    }

    @JsonCreator
    public static RenderMode forValue(String value) throws IOException {
        if (value.equals("Cross")) return CROSS;
        if (value.equals("Ellipse")) return ELLIPSE;
        if (value.equals("Rectangle")) return RECTANGLE;
        if (value.equals("Tile")) return TILE;
        throw new IOException("Cannot deserialize RenderMode");
    }
}
