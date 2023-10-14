package rpgkit.ldtk;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum EmbedAtlas {
    LDTK_ICONS;

    @JsonValue
    public String toValue() {
        switch (this) {
            case LDTK_ICONS: return "LdtkIcons";
        }
        return null;
    }

    @JsonCreator
    public static EmbedAtlas forValue(String value) throws IOException {
        if (value.equals("LdtkIcons")) return LDTK_ICONS;
        throw new IOException("Cannot deserialize EmbedAtlas");
    }
}
