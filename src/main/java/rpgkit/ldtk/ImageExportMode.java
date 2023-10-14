package rpgkit.ldtk;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * "Image export" option when saving project. Possible values: `None`, `OneImagePerLayer`,
 * `OneImagePerLevel`, `LayersAndLevels`
 */
public enum ImageExportMode {
    LAYERS_AND_LEVELS, NONE, ONE_IMAGE_PER_LAYER, ONE_IMAGE_PER_LEVEL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case LAYERS_AND_LEVELS: return "LayersAndLevels";
            case NONE: return "None";
            case ONE_IMAGE_PER_LAYER: return "OneImagePerLayer";
            case ONE_IMAGE_PER_LEVEL: return "OneImagePerLevel";
        }
        return null;
    }

    @JsonCreator
    public static ImageExportMode forValue(String value) throws IOException {
        if (value.equals("LayersAndLevels")) return LAYERS_AND_LEVELS;
        if (value.equals("None")) return NONE;
        if (value.equals("OneImagePerLayer")) return ONE_IMAGE_PER_LAYER;
        if (value.equals("OneImagePerLevel")) return ONE_IMAGE_PER_LEVEL;
        throw new IOException("Cannot deserialize ImageExportMode");
    }
}
