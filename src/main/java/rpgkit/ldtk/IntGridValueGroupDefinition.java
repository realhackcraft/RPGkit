package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.*;

/**
 * IntGrid value group definition
 */
public class IntGridValueGroupDefinition {
    private String color;
    private String identifier;
    private long uid;

    /**
     * User defined color
     */
    @JsonProperty("color")
    public String getColor() { return color; }
    @JsonProperty("color")
    public void setColor(String value) { this.color = value; }

    /**
     * User defined string identifier
     */
    @JsonProperty("identifier")
    public String getIdentifier() { return identifier; }
    @JsonProperty("identifier")
    public void setIdentifier(String value) { this.identifier = value; }

    /**
     * Group unique ID
     */
    @JsonProperty("uid")
    public long getUid() { return uid; }
    @JsonProperty("uid")
    public void setUid(long value) { this.uid = value; }
}
