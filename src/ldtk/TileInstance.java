package ldtk;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This structure represents a single tile from a given Tileset.
 */
public class TileInstance {
    private double a;
    private long[] d;
    private long f;
    private long[] px;
    private long[] src;
    private long t;

    /**
     * Alpha/opacity of the tile (0-1, defaults to 1)
     */
    @JsonProperty("a")
    public double getA() {
        return a;
    }

    @JsonProperty("a")
    public void setA(double value) {
        this.a = value;
    }

    /**
     * Internal data used by the editor.<br/>  For auto-layer tiles: `[ruleId, coordId]`.<br/>
     * For tile-layer tiles: `[coordId]`.
     */
    @JsonProperty("d")
    public long[] getD() {
        return d;
    }

    @JsonProperty("d")
    public void setD(long[] value) {
        this.d = value;
    }

    /**
     * "Flip bits", a 2-bits integer to represent the mirror transformations of the tile.<br/>
     * - Bit 0 = X flip<br/>   - Bit 1 = Y flip<br/>   Examples: f=0 (no flip), f=1 (X flip
     * only), f=2 (Y flip only), f=3 (both flips)
     */
    @JsonProperty("f")
    public long getF() {
        return f;
    }

    @JsonProperty("f")
    public void setF(long value) {
        this.f = value;
    }

    /**
     * Pixel coordinates of the tile in the **layer** (`[x,y]` format). Don't forget optional
     * layer offsets, if they exist!
     */
    @JsonProperty("px")
    public long[] getPx() {
        return px;
    }

    @JsonProperty("px")
    public void setPx(long[] value) {
        this.px = value;
    }

    /**
     * Pixel coordinates of the tile in the **tileset** (`[x,y]` format)
     */
    @JsonProperty("src")
    public long[] getSrc() {
        return src;
    }

    @JsonProperty("src")
    public void setSrc(long[] value) {
        this.src = value;
    }

    /**
     * The *Tile ID* in the corresponding tileset.
     */
    @JsonProperty("t")
    public long getT() {
        return t;
    }

    @JsonProperty("t")
    public void setT(long value) {
        this.t = value;
    }
}
