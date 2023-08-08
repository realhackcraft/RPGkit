package ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum BgPos {
    CONTAIN, COVER, COVER_DIRTY, REPEAT, UNSCALED;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case CONTAIN -> "Contain";
            case COVER -> "Cover";
            case COVER_DIRTY -> "CoverDirty";
            case REPEAT -> "Repeat";
            case UNSCALED -> "Unscaled";
        };
    }

    @JsonCreator
    public static BgPos forValue(String value) throws IOException {
        if (value.equals("Contain")) return CONTAIN;
        if (value.equals("Cover")) return COVER;
        if (value.equals("CoverDirty")) return COVER_DIRTY;
        if (value.equals("Repeat")) return REPEAT;
        if (value.equals("Unscaled")) return UNSCALED;
        throw new IOException("Cannot deserialize BgPos");
    }
}
