package ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

/**
 * Defines how tileIds array is used Possible values: `Single`, `Stamp`
 */
public enum TileMode {
    SINGLE, STAMP;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case SINGLE -> "Single";
            case STAMP -> "Stamp";
        };
    }

    @JsonCreator
    public static TileMode forValue(String value) throws IOException {
        if (value.equals("Single")) return SINGLE;
        if (value.equals("Stamp")) return STAMP;
        throw new IOException("Cannot deserialize TileMode");
    }
}
