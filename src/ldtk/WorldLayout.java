package ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum WorldLayout {
    FREE, GRID_VANIA, LINEAR_HORIZONTAL, LINEAR_VERTICAL;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case FREE -> "Free";
            case GRID_VANIA -> "GridVania";
            case LINEAR_HORIZONTAL -> "LinearHorizontal";
            case LINEAR_VERTICAL -> "LinearVertical";
        };
    }

    @JsonCreator
    public static WorldLayout forValue(String value) throws IOException {
        if (value.equals("Free")) return FREE;
        if (value.equals("GridVania")) return GRID_VANIA;
        if (value.equals("LinearHorizontal")) return LINEAR_HORIZONTAL;
        if (value.equals("LinearVertical")) return LINEAR_VERTICAL;
        throw new IOException("Cannot deserialize WorldLayout");
    }
}
