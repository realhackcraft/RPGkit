package LDtk;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum WorldLayout {
    FREE, GRID_VANIA, LINEAR_HORIZONTAL, LINEAR_VERTICAL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case FREE: return "Free";
            case GRID_VANIA: return "GridVania";
            case LINEAR_HORIZONTAL: return "LinearHorizontal";
            case LINEAR_VERTICAL: return "LinearVertical";
        }
        return null;
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
