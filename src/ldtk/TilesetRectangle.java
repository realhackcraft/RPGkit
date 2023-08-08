package ldtk;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents a custom sub rectangle in a Tileset image.
 */
public class TilesetRectangle {
    private long h;
    private long tilesetUid;
    private long w;
    private long x;
    private long y;

    /**
     * Height in pixels
     */
    @JsonProperty("h")
    public long getH() {
        return h;
    }

    @JsonProperty("h")
    public void setH(long value) {
        this.h = value;
    }

    /**
     * UID of the tileset
     */
    @JsonProperty("tilesetUid")
    public long getTilesetUid() {
        return tilesetUid;
    }

    @JsonProperty("tilesetUid")
    public void setTilesetUid(long value) {
        this.tilesetUid = value;
    }

    /**
     * Width in pixels
     */
    @JsonProperty("w")
    public long getW() {
        return w;
    }

    @JsonProperty("w")
    public void setW(long value) {
        this.w = value;
    }

    /**
     * X pixels coordinate of the top-left corner in the Tileset image
     */
    @JsonProperty("x")
    public long getX() {
        return x;
    }

    @JsonProperty("x")
    public void setX(long value) {
        this.x = value;
    }

    /**
     * Y pixels coordinate of the top-left corner in the Tileset image
     */
    @JsonProperty("y")
    public long getY() {
        return y;
    }

    @JsonProperty("y")
    public void setY(long value) {
        this.y = value;
    }
}
