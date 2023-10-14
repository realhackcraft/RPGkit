package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

/**
 * Checker mode Possible values: `None`, `Horizontal`, `Vertical`
 */
public enum Checker {
    HORIZONTAL, NONE, VERTICAL;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case HORIZONTAL -> "Horizontal";
            case NONE -> "None";
            case VERTICAL -> "Vertical";
        };
    }

    @JsonCreator
    public static Checker forValue(String value) throws IOException {
        if (value.equals("Horizontal")) return HORIZONTAL;
        if (value.equals("None")) return NONE;
        if (value.equals("Vertical")) return VERTICAL;
        throw new IOException("Cannot deserialize Checker");
    }
}
