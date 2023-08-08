package ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

/**
 * Possible values: `ZigZag`, `StraightArrow`, `CurvedArrow`, `ArrowsLine`, `DashedLine`
 */
public enum EditorLinkStyle {
    ARROWS_LINE, CURVED_ARROW, DASHED_LINE, STRAIGHT_ARROW, ZIG_ZAG;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case ARROWS_LINE -> "ArrowsLine";
            case CURVED_ARROW -> "CurvedArrow";
            case DASHED_LINE -> "DashedLine";
            case STRAIGHT_ARROW -> "StraightArrow";
            case ZIG_ZAG -> "ZigZag";
        };
    }

    @JsonCreator
    public static EditorLinkStyle forValue(String value) throws IOException {
        if (value.equals("ArrowsLine")) return ARROWS_LINE;
        if (value.equals("CurvedArrow")) return CURVED_ARROW;
        if (value.equals("DashedLine")) return DASHED_LINE;
        if (value.equals("StraightArrow")) return STRAIGHT_ARROW;
        if (value.equals("ZigZag")) return ZIG_ZAG;
        throw new IOException("Cannot deserialize EditorLinkStyle");
    }
}
