package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

/**
 * Possible values: `Above`, `Center`, `Beneath`
 */
public enum EditorDisplayPos {
    ABOVE, BENEATH, CENTER;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case ABOVE -> "Above";
            case BENEATH -> "Beneath";
            case CENTER -> "Center";
        };
    }

    @JsonCreator
    public static EditorDisplayPos forValue(String value) throws IOException {
        if (value.equals("Above")) return ABOVE;
        if (value.equals("Beneath")) return BENEATH;
        if (value.equals("Center")) return CENTER;
        throw new IOException("Cannot deserialize EditorDisplayPos");
    }
}
