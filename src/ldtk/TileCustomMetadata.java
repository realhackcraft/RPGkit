package ldtk;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * In a tileset definition, user defined meta-data of a tile.
 */
public class TileCustomMetadata {
    private String data;
    private long tileID;

    @JsonProperty("data")
    public String getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(String value) {
        this.data = value;
    }

    @JsonProperty("tileId")
    public long getTileID() {
        return tileID;
    }

    @JsonProperty("tileId")
    public void setTileID(long value) {
        this.tileID = value;
    }
}
