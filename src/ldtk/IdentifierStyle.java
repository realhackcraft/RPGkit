package ldtk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

/**
 * Naming convention for Identifiers (first-letter uppercase, full uppercase etc.) Possible
 * values: `Capitalize`, `Uppercase`, `Lowercase`, `Free`
 */
public enum IdentifierStyle {
    CAPITALIZE, FREE, LOWERCASE, UPPERCASE;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case CAPITALIZE -> "Capitalize";
            case FREE -> "Free";
            case LOWERCASE -> "Lowercase";
            case UPPERCASE -> "Uppercase";
        };
    }

    @JsonCreator
    public static IdentifierStyle forValue(String value) throws IOException {
        if (value.equals("Capitalize")) return CAPITALIZE;
        if (value.equals("Free")) return FREE;
        if (value.equals("Lowercase")) return LOWERCASE;
        if (value.equals("Uppercase")) return UPPERCASE;
        throw new IOException("Cannot deserialize IdentifierStyle");
    }
}
