package rpgkit.ldtk;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * An enum describing how the the Entity tile is rendered inside the Entity bounds. Possible
 * values: `Cover`, `FitInside`, `Repeat`, `Stretch`, `FullSizeCropped`,
 * `FullSizeUncropped`, `NineSlice`
 */
public enum TileRenderMode {
    COVER, FIT_INSIDE, FULL_SIZE_CROPPED, FULL_SIZE_UNCROPPED, NINE_SLICE, REPEAT, STRETCH;

    @JsonValue
    public String toValue() {
        switch (this) {
            case COVER: return "Cover";
            case FIT_INSIDE: return "FitInside";
            case FULL_SIZE_CROPPED: return "FullSizeCropped";
            case FULL_SIZE_UNCROPPED: return "FullSizeUncropped";
            case NINE_SLICE: return "NineSlice";
            case REPEAT: return "Repeat";
            case STRETCH: return "Stretch";
        }
        return null;
    }

    @JsonCreator
    public static TileRenderMode forValue(String value) throws IOException {
        if (value.equals("Cover")) return COVER;
        if (value.equals("FitInside")) return FIT_INSIDE;
        if (value.equals("FullSizeCropped")) return FULL_SIZE_CROPPED;
        if (value.equals("FullSizeUncropped")) return FULL_SIZE_UNCROPPED;
        if (value.equals("NineSlice")) return NINE_SLICE;
        if (value.equals("Repeat")) return REPEAT;
        if (value.equals("Stretch")) return STRETCH;
        throw new IOException("Cannot deserialize TileRenderMode");
    }
}
