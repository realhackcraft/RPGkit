package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

/**
 * Possible values: `Any`, `OnlySame`, `OnlyTags`, `OnlySpecificEntity`
 */
public enum AllowedRefs {
    ANY, ONLY_SAME, ONLY_SPECIFIC_ENTITY, ONLY_TAGS;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case ANY -> "Any";
            case ONLY_SAME -> "OnlySame";
            case ONLY_SPECIFIC_ENTITY -> "OnlySpecificEntity";
            case ONLY_TAGS -> "OnlyTags";
        };
    }

    @JsonCreator
    public static AllowedRefs forValue(String value) throws IOException {
        if (value.equals("Any")) return ANY;
        if (value.equals("OnlySame")) return ONLY_SAME;
        if (value.equals("OnlySpecificEntity")) return ONLY_SPECIFIC_ENTITY;
        if (value.equals("OnlyTags")) return ONLY_TAGS;
        throw new IOException("Cannot deserialize AllowedRefs");
    }
}
