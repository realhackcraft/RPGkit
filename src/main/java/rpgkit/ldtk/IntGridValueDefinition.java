package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * IntGrid value definition
 */
public class IntGridValueDefinition {
    private String color;
    private String identifier;
    private TilesetRectangle tile;
    private long value;

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * User defined unique identifier
     */
    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    @JsonProperty("identifier")
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    @JsonProperty("tile")
    public TilesetRectangle getTile() {
        return tile;
    }

    @JsonProperty("tile")
    public void setTile(TilesetRectangle value) {
        this.tile = value;
    }

    /**
     * The IntGrid value itself
     */
    @JsonProperty("value")
    public long getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(long value) {
        this.value = value;
    }
}
