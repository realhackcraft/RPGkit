package ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

/**
 * Possible values: `Manual`, `AfterLoad`, `BeforeSave`, `AfterSave`
 */
public enum When {
    AFTER_LOAD, AFTER_SAVE, BEFORE_SAVE, MANUAL;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case AFTER_LOAD -> "AfterLoad";
            case AFTER_SAVE -> "AfterSave";
            case BEFORE_SAVE -> "BeforeSave";
            case MANUAL -> "Manual";
        };
    }

    @JsonCreator
    public static When forValue(String value) throws IOException {
        if (value.equals("AfterLoad")) return AFTER_LOAD;
        if (value.equals("AfterSave")) return AFTER_SAVE;
        if (value.equals("BeforeSave")) return BEFORE_SAVE;
        if (value.equals("Manual")) return MANUAL;
        throw new IOException("Cannot deserialize When");
    }
}
