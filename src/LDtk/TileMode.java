package LDtk;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Defines how tileIds array is used Possible values: `Single`, `Stamp`
 */
public enum TileMode {
    SINGLE, STAMP;

    @JsonValue
    public String toValue() {
        switch (this) {
            case SINGLE: return "Single";
            case STAMP: return "Stamp";
        }
        return null;
    }

    @JsonCreator
    public static TileMode forValue(String value) throws IOException {
        if (value.equals("Single")) return SINGLE;
        if (value.equals("Stamp")) return STAMP;
        throw new IOException("Cannot deserialize TileMode");
    }
}
