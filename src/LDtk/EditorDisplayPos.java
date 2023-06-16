package LDtk;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Possible values: `Above`, `Center`, `Beneath`
 */
public enum EditorDisplayPos {
    ABOVE, BENEATH, CENTER;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ABOVE: return "Above";
            case BENEATH: return "Beneath";
            case CENTER: return "Center";
        }
        return null;
    }

    @JsonCreator
    public static EditorDisplayPos forValue(String value) throws IOException {
        if (value.equals("Above")) return ABOVE;
        if (value.equals("Beneath")) return BENEATH;
        if (value.equals("Center")) return CENTER;
        throw new IOException("Cannot deserialize EditorDisplayPos");
    }
}
