package ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

/**
 * Possible values: `DiscardOldOnes`, `PreventAdding`, `MoveLastOne`
 */
public enum LimitBehavior {
    DISCARD_OLD_ONES, MOVE_LAST_ONE, PREVENT_ADDING;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case DISCARD_OLD_ONES -> "DiscardOldOnes";
            case MOVE_LAST_ONE -> "MoveLastOne";
            case PREVENT_ADDING -> "PreventAdding";
        };
    }

    @JsonCreator
    public static LimitBehavior forValue(String value) throws IOException {
        if (value.equals("DiscardOldOnes")) return DISCARD_OLD_ONES;
        if (value.equals("MoveLastOne")) return MOVE_LAST_ONE;
        if (value.equals("PreventAdding")) return PREVENT_ADDING;
        throw new IOException("Cannot deserialize LimitBehavior");
    }
}
