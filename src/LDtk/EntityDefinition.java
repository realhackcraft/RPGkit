package LDtk;

import com.fasterxml.jackson.annotation.*;

public class EntityDefinition {
    private String color;
    private String doc;
    private boolean exportToToc;
    private FieldDefinition[] fieldDefs;
    private double fillOpacity;
    private long height;
    private boolean hollow;
    private String identifier;
    private boolean keepAspectRatio;
    private LimitBehavior limitBehavior;
    private LimitScope limitScope;
    private double lineOpacity;
    private long maxCount;
    private Long maxHeight;
    private Long maxWidth;
    private Long minHeight;
    private Long minWidth;
    private long[] nineSliceBorders;
    private double pivotX;
    private double pivotY;
    private RenderMode renderMode;
    private boolean resizableX;
    private boolean resizableY;
    private boolean showName;
    private String[] tags;
    private Long tileID;
    private double tileOpacity;
    private TilesetRectangle tileRect;
    private TileRenderMode tileRenderMode;
    private Long tilesetID;
    private long uid;
    private long width;

    /**
     * Base entity color
     */
    @JsonProperty("color")
    public String getColor() { return color; }
    @JsonProperty("color")
    public void setColor(String value) { this.color = value; }

    /**
     * User defined documentation for this element to provide help/tips to level designers.
     */
    @JsonProperty("doc")
    public String getDoc() { return doc; }
    @JsonProperty("doc")
    public void setDoc(String value) { this.doc = value; }

    /**
     * If enabled, all instances of this entity will be listed in the project "Table of content"
     * object.
     */
    @JsonProperty("exportToToc")
    public boolean getExportToToc() { return exportToToc; }
    @JsonProperty("exportToToc")
    public void setExportToToc(boolean value) { this.exportToToc = value; }

    /**
     * Array of field definitions
     */
    @JsonProperty("fieldDefs")
    public FieldDefinition[] getFieldDefs() { return fieldDefs; }
    @JsonProperty("fieldDefs")
    public void setFieldDefs(FieldDefinition[] value) { this.fieldDefs = value; }

    @JsonProperty("fillOpacity")
    public double getFillOpacity() { return fillOpacity; }
    @JsonProperty("fillOpacity")
    public void setFillOpacity(double value) { this.fillOpacity = value; }

    /**
     * Pixel height
     */
    @JsonProperty("height")
    public long getHeight() { return height; }
    @JsonProperty("height")
    public void setHeight(long value) { this.height = value; }

    @JsonProperty("hollow")
    public boolean getHollow() { return hollow; }
    @JsonProperty("hollow")
    public void setHollow(boolean value) { this.hollow = value; }

    /**
     * User defined unique identifier
     */
    @JsonProperty("identifier")
    public String getIdentifier() { return identifier; }
    @JsonProperty("identifier")
    public void setIdentifier(String value) { this.identifier = value; }

    /**
     * Only applies to entities resizable on both X/Y. If TRUE, the entity instance width/height
     * will keep the same aspect ratio as the definition.
     */
    @JsonProperty("keepAspectRatio")
    public boolean getKeepAspectRatio() { return keepAspectRatio; }
    @JsonProperty("keepAspectRatio")
    public void setKeepAspectRatio(boolean value) { this.keepAspectRatio = value; }

    /**
     * Possible values: `DiscardOldOnes`, `PreventAdding`, `MoveLastOne`
     */
    @JsonProperty("limitBehavior")
    public LimitBehavior getLimitBehavior() { return limitBehavior; }
    @JsonProperty("limitBehavior")
    public void setLimitBehavior(LimitBehavior value) { this.limitBehavior = value; }

    /**
     * If TRUE, the maxCount is a "per world" limit, if FALSE, it's a "per level". Possible
     * values: `PerLayer`, `PerLevel`, `PerWorld`
     */
    @JsonProperty("limitScope")
    public LimitScope getLimitScope() { return limitScope; }
    @JsonProperty("limitScope")
    public void setLimitScope(LimitScope value) { this.limitScope = value; }

    @JsonProperty("lineOpacity")
    public double getLineOpacity() { return lineOpacity; }
    @JsonProperty("lineOpacity")
    public void setLineOpacity(double value) { this.lineOpacity = value; }

    /**
     * Max instances count
     */
    @JsonProperty("maxCount")
    public long getMaxCount() { return maxCount; }
    @JsonProperty("maxCount")
    public void setMaxCount(long value) { this.maxCount = value; }

    /**
     * Max pixel height (only applies if the entity is resizable on Y)
     */
    @JsonProperty("maxHeight")
    public Long getMaxHeight() { return maxHeight; }
    @JsonProperty("maxHeight")
    public void setMaxHeight(Long value) { this.maxHeight = value; }

    /**
     * Max pixel width (only applies if the entity is resizable on X)
     */
    @JsonProperty("maxWidth")
    public Long getMaxWidth() { return maxWidth; }
    @JsonProperty("maxWidth")
    public void setMaxWidth(Long value) { this.maxWidth = value; }

    /**
     * Min pixel height (only applies if the entity is resizable on Y)
     */
    @JsonProperty("minHeight")
    public Long getMinHeight() { return minHeight; }
    @JsonProperty("minHeight")
    public void setMinHeight(Long value) { this.minHeight = value; }

    /**
     * Min pixel width (only applies if the entity is resizable on X)
     */
    @JsonProperty("minWidth")
    public Long getMinWidth() { return minWidth; }
    @JsonProperty("minWidth")
    public void setMinWidth(Long value) { this.minWidth = value; }

    /**
     * An array of 4 dimensions for the up/right/down/left borders (in this order) when using
     * 9-slice mode for `tileRenderMode`.<br/>  If the tileRenderMode is not NineSlice, then
     * this array is empty.<br/>  See: https://en.wikipedia.org/wiki/9-slice_scaling
     */
    @JsonProperty("nineSliceBorders")
    public long[] getNineSliceBorders() { return nineSliceBorders; }
    @JsonProperty("nineSliceBorders")
    public void setNineSliceBorders(long[] value) { this.nineSliceBorders = value; }

    /**
     * Pivot X coordinate (from 0 to 1.0)
     */
    @JsonProperty("pivotX")
    public double getPivotX() { return pivotX; }
    @JsonProperty("pivotX")
    public void setPivotX(double value) { this.pivotX = value; }

    /**
     * Pivot Y coordinate (from 0 to 1.0)
     */
    @JsonProperty("pivotY")
    public double getPivotY() { return pivotY; }
    @JsonProperty("pivotY")
    public void setPivotY(double value) { this.pivotY = value; }

    /**
     * Possible values: `Rectangle`, `Ellipse`, `Tile`, `Cross`
     */
    @JsonProperty("renderMode")
    public RenderMode getRenderMode() { return renderMode; }
    @JsonProperty("renderMode")
    public void setRenderMode(RenderMode value) { this.renderMode = value; }

    /**
     * If TRUE, the entity instances will be resizable horizontally
     */
    @JsonProperty("resizableX")
    public boolean getResizableX() { return resizableX; }
    @JsonProperty("resizableX")
    public void setResizableX(boolean value) { this.resizableX = value; }

    /**
     * If TRUE, the entity instances will be resizable vertically
     */
    @JsonProperty("resizableY")
    public boolean getResizableY() { return resizableY; }
    @JsonProperty("resizableY")
    public void setResizableY(boolean value) { this.resizableY = value; }

    /**
     * Display entity name in editor
     */
    @JsonProperty("showName")
    public boolean getShowName() { return showName; }
    @JsonProperty("showName")
    public void setShowName(boolean value) { this.showName = value; }

    /**
     * An array of strings that classifies this entity
     */
    @JsonProperty("tags")
    public String[] getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(String[] value) { this.tags = value; }

    /**
     * **WARNING**: this deprecated value is no longer exported since version 1.2.0  Replaced
     * by: `tileRect`
     */
    @JsonProperty("tileId")
    public Long getTileID() { return tileID; }
    @JsonProperty("tileId")
    public void setTileID(Long value) { this.tileID = value; }

    @JsonProperty("tileOpacity")
    public double getTileOpacity() { return tileOpacity; }
    @JsonProperty("tileOpacity")
    public void setTileOpacity(double value) { this.tileOpacity = value; }

    /**
     * An object representing a rectangle from an existing Tileset
     */
    @JsonProperty("tileRect")
    public TilesetRectangle getTileRect() { return tileRect; }
    @JsonProperty("tileRect")
    public void setTileRect(TilesetRectangle value) { this.tileRect = value; }

    /**
     * An enum describing how the the Entity tile is rendered inside the Entity bounds. Possible
     * values: `Cover`, `FitInside`, `Repeat`, `Stretch`, `FullSizeCropped`,
     * `FullSizeUncropped`, `NineSlice`
     */
    @JsonProperty("tileRenderMode")
    public TileRenderMode getTileRenderMode() { return tileRenderMode; }
    @JsonProperty("tileRenderMode")
    public void setTileRenderMode(TileRenderMode value) { this.tileRenderMode = value; }

    /**
     * Tileset ID used for optional tile display
     */
    @JsonProperty("tilesetId")
    public Long getTilesetID() { return tilesetID; }
    @JsonProperty("tilesetId")
    public void setTilesetID(Long value) { this.tilesetID = value; }

    /**
     * Unique Int identifier
     */
    @JsonProperty("uid")
    public long getUid() { return uid; }
    @JsonProperty("uid")
    public void setUid(long value) { this.uid = value; }

    /**
     * Pixel width
     */
    @JsonProperty("width")
    public long getWidth() { return width; }
    @JsonProperty("width")
    public void setWidth(long value) { this.width = value; }
}
