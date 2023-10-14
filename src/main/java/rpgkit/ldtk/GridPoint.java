package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.*;

/**
 * This object is just a grid-based coordinate used in Field values.
 */
public class GridPoint {
    private long cx;
    private long cy;

    /**
     * X grid-based coordinate
     */
    @JsonProperty("cx")
    public long getCx() { return cx; }
    @JsonProperty("cx")
    public void setCx(long value) { this.cx = value; }

    /**
     * Y grid-based coordinate
     */
    @JsonProperty("cy")
    public long getCy() { return cy; }
    @JsonProperty("cy")
    public void setCy(long value) { this.cy = value; }
}
