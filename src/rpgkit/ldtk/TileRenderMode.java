package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

/**
 * An enum describing how the the Entity tile is rendered inside the Entity bounds. Possible
 * values: `Cover`, `FitInside`, `Repeat`, `Stretch`, `FullSizeCropped`,
 * `FullSizeUncropped`, `NineSlice`
 */
public enum TileRenderMode {
    COVER, FIT_INSIDE, FULL_SIZE_CROPPED, FULL_SIZE_UNCROPPED, NINE_SLICE, REPEAT, STRETCH;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case COVER -> "Cover";
            case FIT_INSIDE -> "FitInside";
            case FULL_SIZE_CROPPED -> "FullSizeCropped";
            case FULL_SIZE_UNCROPPED -> "FullSizeUncropped";
            case NINE_SLICE -> "NineSlice";
            case REPEAT -> "Repeat";
            case STRETCH -> "Stretch";
        };
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
