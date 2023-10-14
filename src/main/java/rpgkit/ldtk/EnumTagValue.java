package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.*;

/**
 * In a tileset definition, enum based tag infos
 */
public class EnumTagValue {
    private String enumValueID;
    private long[] tileIDS;

    @JsonProperty("enumValueId")
    public String getEnumValueID() { return enumValueID; }
    @JsonProperty("enumValueId")
    public void setEnumValueID(String value) { this.enumValueID = value; }

    @JsonProperty("tileIds")
    public long[] getTileIDS() { return tileIDS; }
    @JsonProperty("tileIds")
    public void setTileIDS(long[] value) { this.tileIDS = value; }
}
