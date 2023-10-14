package rpgkit.ldtk;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Checker mode Possible values: `None`, `Horizontal`, `Vertical`
 */
public enum Checker {
    HORIZONTAL, NONE, VERTICAL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case HORIZONTAL: return "Horizontal";
            case NONE: return "None";
            case VERTICAL: return "Vertical";
        }
        return null;
    }

    @JsonCreator
    public static Checker forValue(String value) throws IOException {
        if (value.equals("Horizontal")) return HORIZONTAL;
        if (value.equals("None")) return NONE;
        if (value.equals("Vertical")) return VERTICAL;
        throw new IOException("Cannot deserialize Checker");
    }
}
