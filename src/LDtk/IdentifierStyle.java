package LDtk;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

/**
 * Naming convention for Identifiers (first-letter uppercase, full uppercase etc.) Possible
 * values: `Capitalize`, `Uppercase`, `Lowercase`, `Free`
 */
public enum IdentifierStyle {
    CAPITALIZE, FREE, LOWERCASE, UPPERCASE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CAPITALIZE: return "Capitalize";
            case FREE: return "Free";
            case LOWERCASE: return "Lowercase";
            case UPPERCASE: return "Uppercase";
        }
        return null;
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
