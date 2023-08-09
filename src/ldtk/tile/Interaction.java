package ldtk.tile;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum Interaction {
    FARM;

    @JsonValue
    public String toValue() {
        switch (this) {
            case FARM:
                return "Farm";
        }
        return null;
    }

    @JsonCreator
    public static Interaction forValue(String value) throws IOException {
        if (value.equals("Farm")) return FARM;
        throw new IOException("Cannot deserialize Interaction");
    }
}
