package ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

/**
 * If TRUE, the maxCount is a "per world" limit, if FALSE, it's a "per level". Possible
 * values: `PerLayer`, `PerLevel`, `PerWorld`
 */
public enum LimitScope {
    PER_LAYER, PER_LEVEL, PER_WORLD;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case PER_LAYER -> "PerLayer";
            case PER_LEVEL -> "PerLevel";
            case PER_WORLD -> "PerWorld";
        };
    }

    @JsonCreator
    public static LimitScope forValue(String value) throws IOException {
        if (value.equals("PerLayer")) return PER_LAYER;
        if (value.equals("PerLevel")) return PER_LEVEL;
        if (value.equals("PerWorld")) return PER_WORLD;
        throw new IOException("Cannot deserialize LimitScope");
    }
}
