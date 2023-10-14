package rpgkit.ldtk;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * If TRUE, the maxCount is a "per world" limit, if FALSE, it's a "per level". Possible
 * values: `PerLayer`, `PerLevel`, `PerWorld`
 */
public enum LimitScope {
    PER_LAYER, PER_LEVEL, PER_WORLD;

    @JsonValue
    public String toValue() {
        switch (this) {
            case PER_LAYER: return "PerLayer";
            case PER_LEVEL: return "PerLevel";
            case PER_WORLD: return "PerWorld";
        }
        return null;
    }

    @JsonCreator
    public static LimitScope forValue(String value) throws IOException {
        if (value.equals("PerLayer")) return PER_LAYER;
        if (value.equals("PerLevel")) return PER_LEVEL;
        if (value.equals("PerWorld")) return PER_WORLD;
        throw new IOException("Cannot deserialize LimitScope");
    }
}
