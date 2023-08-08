package ldtk;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityInstance {
    private long[] grid;
    private String identifier;
    private double[] pivot;
    private String smartColor;
    private String[] tags;
    private TilesetRectangle tile;
    private long defUid;
    private FieldInstance[] fieldInstances;
    private long height;
    private String iid;
    private long[] px;
    private long width;

    /**
     * Grid-based coordinates (`[x,y]` format)
     */
    @JsonProperty("__grid")
    public long[] getGrid() {
        return grid;
    }

    @JsonProperty("__grid")
    public void setGrid(long[] value) {
        this.grid = value;
    }

    /**
     * Entity definition identifier
     */
    @JsonProperty("__identifier")
    public String getIdentifier() {
        return identifier;
    }

    @JsonProperty("__identifier")
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * Pivot coordinates  (`[x,y]` format, values are from 0 to 1) of the Entity
     */
    @JsonProperty("__pivot")
    public double[] getPivot() {
        return pivot;
    }

    @JsonProperty("__pivot")
    public void setPivot(double[] value) {
        this.pivot = value;
    }

    /**
     * The entity "smart" color, guessed from either Entity definition, or one its field
     * instances.
     */
    @JsonProperty("__smartColor")
    public String getSmartColor() {
        return smartColor;
    }

    @JsonProperty("__smartColor")
    public void setSmartColor(String value) {
        this.smartColor = value;
    }

    /**
     * Array of tags defined in this Entity definition
     */
    @JsonProperty("__tags")
    public String[] getTags() {
        return tags;
    }

    @JsonProperty("__tags")
    public void setTags(String[] value) {
        this.tags = value;
    }

    /**
     * Optional TilesetRect used to display this entity (it could either be the default Entity
     * tile, or some tile provided by a field value, like an Enum).
     */
    @JsonProperty("__tile")
    public TilesetRectangle getTile() {
        return tile;
    }

    @JsonProperty("__tile")
    public void setTile(TilesetRectangle value) {
        this.tile = value;
    }

    /**
     * Reference of the **Entity definition** UID
     */
    @JsonProperty("defUid")
    public long getDefUid() {
        return defUid;
    }

    @JsonProperty("defUid")
    public void setDefUid(long value) {
        this.defUid = value;
    }

    /**
     * An array of all custom fields and their values.
     */
    @JsonProperty("fieldInstances")
    public FieldInstance[] getFieldInstances() {
        return fieldInstances;
    }

    @JsonProperty("fieldInstances")
    public void setFieldInstances(FieldInstance[] value) {
        this.fieldInstances = value;
    }

    /**
     * Entity height in pixels. For non-resizable entities, it will be the same as Entity
     * definition.
     */
    @JsonProperty("height")
    public long getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(long value) {
        this.height = value;
    }

    /**
     * Unique instance identifier
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
     * Pixel coordinates (`[x,y]` format) in current level coordinate space. Don't forget
     * optional layer offsets, if they exist!
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
     * Entity width in pixels. For non-resizable entities, it will be the same as Entity
     * definition.
     */
    @JsonProperty("width")
    public long getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(long value) {
        this.width = value;
    }
}
