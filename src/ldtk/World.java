package ldtk;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * **IMPORTANT**: this type is available as a preview. You can rely on it to update your
 * importers, for when it will be officially available.  A World contains multiple levels,
 * and it has its own layout settings.
 */
public class World {
    private long defaultLevelHeight;
    private long defaultLevelWidth;
    private String identifier;
    private String iid;
    private Level[] levels;
    private long worldGridHeight;
    private long worldGridWidth;
    private WorldLayout worldLayout;

    /**
     * Default new level height
     */
    @JsonProperty("defaultLevelHeight")
    public long getDefaultLevelHeight() {
        return defaultLevelHeight;
    }

    @JsonProperty("defaultLevelHeight")
    public void setDefaultLevelHeight(long value) {
        this.defaultLevelHeight = value;
    }

    /**
     * Default new level width
     */
    @JsonProperty("defaultLevelWidth")
    public long getDefaultLevelWidth() {
        return defaultLevelWidth;
    }

    @JsonProperty("defaultLevelWidth")
    public void setDefaultLevelWidth(long value) {
        this.defaultLevelWidth = value;
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

    /**
     * Unique instance identifer
     */
    @JsonProperty("iid")
    public String getIid() {
        return iid;
    }

    @JsonProperty("iid")
    public void setIid(String value) {
        this.iid = value;
    }

    /**
     * All levels from this world. The order of this array is only relevant in
     * `LinearHorizontal` and `linearVertical` world layouts (see `worldLayout` value).
     * Otherwise, you should refer to the `worldX`,`worldY` coordinates of each Level.
     */
    @JsonProperty("levels")
    public Level[] getLevels() {
        return levels;
    }

    @JsonProperty("levels")
    public void setLevels(Level[] value) {
        this.levels = value;
    }

    /**
     * Height of the world grid in pixels.
     */
    @JsonProperty("worldGridHeight")
    public long getWorldGridHeight() {
        return worldGridHeight;
    }

    @JsonProperty("worldGridHeight")
    public void setWorldGridHeight(long value) {
        this.worldGridHeight = value;
    }

    /**
     * Width of the world grid in pixels.
     */
    @JsonProperty("worldGridWidth")
    public long getWorldGridWidth() {
        return worldGridWidth;
    }

    @JsonProperty("worldGridWidth")
    public void setWorldGridWidth(long value) {
        this.worldGridWidth = value;
    }

    /**
     * An enum that describes how levels are organized in this project (ie. linearly or in a 2D
     * space). Possible values: `Free`, `GridVania`, `LinearHorizontal`, `LinearVertical`, `null`
     */
    @JsonProperty("worldLayout")
    public WorldLayout getWorldLayout() {
        return worldLayout;
    }

    @JsonProperty("worldLayout")
    public void setWorldLayout(WorldLayout value) {
        this.worldLayout = value;
    }
}
