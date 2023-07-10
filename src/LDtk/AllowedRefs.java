package LDtk;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Possible values: `Any`, `OnlySame`, `OnlyTags`, `OnlySpecificEntity`
 */
public enum AllowedRefs {
    ANY, ONLY_SAME, ONLY_SPECIFIC_ENTITY, ONLY_TAGS;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ANY: return "Any";
            case ONLY_SAME: return "OnlySame";
            case ONLY_SPECIFIC_ENTITY: return "OnlySpecificEntity";
            case ONLY_TAGS: return "OnlyTags";
        }
        return null;
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
