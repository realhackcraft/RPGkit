package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.*;

public class EnumValueDefinition {
    private long[] tileSrcRect;
    private long color;
    private String id;
    private Long tileID;
    private TilesetRectangle tileRect;

    /**
     * **WARNING**: this deprecated value is no longer exported since version 1.4.0  Replaced
     * by: `tileRect`
     */
    @JsonProperty("__tileSrcRect")
    public long[] getTileSrcRect() { return tileSrcRect; }
    @JsonProperty("__tileSrcRect")
    public void setTileSrcRect(long[] value) { this.tileSrcRect = value; }

    /**
     * Optional color
     */
    @JsonProperty("color")
    public long getColor() { return color; }
    @JsonProperty("color")
    public void setColor(long value) { this.color = value; }

    /**
     * Enum value
     */
    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    /**
     * **WARNING**: this deprecated value is no longer exported since version 1.4.0  Replaced
     * by: `tileRect`
     */
    @JsonProperty("tileId")
    public Long getTileID() { return tileID; }
    @JsonProperty("tileId")
    public void setTileID(Long value) { this.tileID = value; }

    /**
     * Optional tileset rectangle to represents this value
     */
    @JsonProperty("tileRect")
    public TilesetRectangle getTileRect() { return tileRect; }
    @JsonProperty("tileRect")
    public void setTileRect(TilesetRectangle value) { this.tileRect = value; }
}
