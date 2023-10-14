package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.*;

/**
 * Nearby level info
 */
public class NeighbourLevel {
    private String dir;
    private String levelIid;
    private Long levelUid;

    /**
     * A single lowercase character tipping on the level location (`n`orth, `s`outh, `w`est,
     * `e`ast).<br/>  Since 1.4.0, this character value can also be `<` (neighbour depth is
     * lower), `>` (neighbour depth is greater) or `o` (levels overlap and share the same world
     * depth).
     */
    @JsonProperty("dir")
    public String getDir() { return dir; }
    @JsonProperty("dir")
    public void setDir(String value) { this.dir = value; }

    /**
     * Neighbour Instance Identifier
     */
    @JsonProperty("levelIid")
    public String getLevelIid() { return levelIid; }
    @JsonProperty("levelIid")
    public void setLevelIid(String value) { this.levelIid = value; }

    /**
     * **WARNING**: this deprecated value is no longer exported since version 1.2.0  Replaced
     * by: `levelIid`
     */
    @JsonProperty("levelUid")
    public Long getLevelUid() { return levelUid; }
    @JsonProperty("levelUid")
    public void setLevelUid(Long value) { this.levelUid = value; }
}
