package LDtk;

import com.fasterxml.jackson.annotation.*;

/**
 * IntGrid value instance
 */
public class IntGridValueInstance {
    private long coordID;
    private long v;

    /**
     * Coordinate ID in the layer grid
     */
    @JsonProperty("coordId")
    public long getCoordID() { return coordID; }
    @JsonProperty("coordId")
    public void setCoordID(long value) { this.coordID = value; }

    /**
     * IntGrid value
     */
    @JsonProperty("v")
    public long getV() { return v; }
    @JsonProperty("v")
    public void setV(long value) { this.v = value; }
}
