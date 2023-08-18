package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum EmbedAtlas {
    LDTK_ICONS;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case LDTK_ICONS -> "LdtkIcons";
        };
    }

    @JsonCreator
    public static EmbedAtlas forValue(String value) throws IOException {
        if (value.equals("LdtkIcons")) return LDTK_ICONS;
        throw new IOException("Cannot deserialize EmbedAtlas");
    }
}
