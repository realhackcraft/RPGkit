package ldtk;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LayerDefinition {
    private String type;
    private AutoLayerRuleGroup[] autoRuleGroups;
    private Long autoSourceLayerDefUid;
    private Long autoTilesetDefUid;
    private boolean canSelectWhenInactive;
    private double displayOpacity;
    private String doc;
    private String[] excludedTags;
    private long gridSize;
    private long guideGridHei;
    private long guideGridWid;
    private boolean hideFieldsWhenInactive;
    private boolean hideInList;
    private String identifier;
    private double inactiveOpacity;
    private IntGridValueDefinition[] intGridValues;
    private double parallaxFactorX;
    private double parallaxFactorY;
    private boolean parallaxScaling;
    private long pxOffsetX;
    private long pxOffsetY;
    private boolean renderInWorldView;
    private String[] requiredTags;
    private double tilePivotX;
    private double tilePivotY;
    private Long tilesetDefUid;
    private Type layerDefinitionType;
    private String uiColor;
    private long uid;

    /**
     * Type of the layer (*IntGrid, Entities, Tiles or AutoLayer*)
     */
    @JsonProperty("__type")
    public String getType() {
        return type;
    }

    @JsonProperty("__type")
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Contains all the auto-layer rule definitions.
     */
    @JsonProperty("autoRuleGroups")
    public AutoLayerRuleGroup[] getAutoRuleGroups() {
        return autoRuleGroups;
    }

    @JsonProperty("autoRuleGroups")
    public void setAutoRuleGroups(AutoLayerRuleGroup[] value) {
        this.autoRuleGroups = value;
    }

    @JsonProperty("autoSourceLayerDefUid")
    public Long getAutoSourceLayerDefUid() {
        return autoSourceLayerDefUid;
    }

    @JsonProperty("autoSourceLayerDefUid")
    public void setAutoSourceLayerDefUid(Long value) {
        this.autoSourceLayerDefUid = value;
    }

    /**
     * **WARNING**: this deprecated value is no longer exported since version 1.2.0  Replaced
     * by: `tilesetDefUid`
     */
    @JsonProperty("autoTilesetDefUid")
    public Long getAutoTilesetDefUid() {
        return autoTilesetDefUid;
    }

    @JsonProperty("autoTilesetDefUid")
    public void setAutoTilesetDefUid(Long value) {
        this.autoTilesetDefUid = value;
    }

    /**
     * Allow editor selections when the layer is not currently active.
     */
    @JsonProperty("canSelectWhenInactive")
    public boolean getCanSelectWhenInactive() {
        return canSelectWhenInactive;
    }

    @JsonProperty("canSelectWhenInactive")
    public void setCanSelectWhenInactive(boolean value) {
        this.canSelectWhenInactive = value;
    }

    /**
     * Opacity of the layer (0 to 1.0)
     */
    @JsonProperty("displayOpacity")
    public double getDisplayOpacity() {
        return displayOpacity;
    }

    @JsonProperty("displayOpacity")
    public void setDisplayOpacity(double value) {
        this.displayOpacity = value;
    }

    /**
     * User defined documentation for this element to provide help/tips to level designers.
     */
    @JsonProperty("doc")
    public String getDoc() {
        return doc;
    }

    @JsonProperty("doc")
    public void setDoc(String value) {
        this.doc = value;
    }

    /**
     * An array of tags to forbid some Entities in this layer
     */
    @JsonProperty("excludedTags")
    public String[] getExcludedTags() {
        return excludedTags;
    }

    @JsonProperty("excludedTags")
    public void setExcludedTags(String[] value) {
        this.excludedTags = value;
    }

    /**
     * Width and height of the grid in pixels
     */
    @JsonProperty("gridSize")
    public long getGridSize() {
        return gridSize;
    }

    @JsonProperty("gridSize")
    public void setGridSize(long value) {
        this.gridSize = value;
    }

    /**
     * Height of the optional "guide" grid in pixels
     */
    @JsonProperty("guideGridHei")
    public long getGuideGridHei() {
        return guideGridHei;
    }

    @JsonProperty("guideGridHei")
    public void setGuideGridHei(long value) {
        this.guideGridHei = value;
    }

    /**
     * Width of the optional "guide" grid in pixels
     */
    @JsonProperty("guideGridWid")
    public long getGuideGridWid() {
        return guideGridWid;
    }

    @JsonProperty("guideGridWid")
    public void setGuideGridWid(long value) {
        this.guideGridWid = value;
    }

    @JsonProperty("hideFieldsWhenInactive")
    public boolean getHideFieldsWhenInactive() {
        return hideFieldsWhenInactive;
    }

    @JsonProperty("hideFieldsWhenInactive")
    public void setHideFieldsWhenInactive(boolean value) {
        this.hideFieldsWhenInactive = value;
    }

    /**
     * Hide the layer from the list on the side of the editor view.
     */
    @JsonProperty("hideInList")
    public boolean getHideInList() {
        return hideInList;
    }

    @JsonProperty("hideInList")
    public void setHideInList(boolean value) {
        this.hideInList = value;
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
     * Alpha of this layer when it is not the active one.
     */
    @JsonProperty("inactiveOpacity")
    public double getInactiveOpacity() {
        return inactiveOpacity;
    }

    @JsonProperty("inactiveOpacity")
    public void setInactiveOpacity(double value) {
        this.inactiveOpacity = value;
    }

    /**
     * An array that defines extra optional info for each IntGrid value.<br/>  WARNING: the
     * array order is not related to actual IntGrid values! As user can re-order IntGrid values
     * freely, you may value "2" before value "1" in this array.
     */
    @JsonProperty("intGridValues")
    public IntGridValueDefinition[] getIntGridValues() {
        return intGridValues;
    }

    @JsonProperty("intGridValues")
    public void setIntGridValues(IntGridValueDefinition[] value) {
        this.intGridValues = value;
    }

    /**
     * Parallax horizontal factor (from -1 to 1, defaults to 0) which affects the scrolling
     * speed of this layer, creating a fake 3D (parallax) effect.
     */
    @JsonProperty("parallaxFactorX")
    public double getParallaxFactorX() {
        return parallaxFactorX;
    }

    @JsonProperty("parallaxFactorX")
    public void setParallaxFactorX(double value) {
        this.parallaxFactorX = value;
    }

    /**
     * Parallax vertical factor (from -1 to 1, defaults to 0) which affects the scrolling speed
     * of this layer, creating a fake 3D (parallax) effect.
     */
    @JsonProperty("parallaxFactorY")
    public double getParallaxFactorY() {
        return parallaxFactorY;
    }

    @JsonProperty("parallaxFactorY")
    public void setParallaxFactorY(double value) {
        this.parallaxFactorY = value;
    }

    /**
     * If true (default), a layer with a parallax factor will also be scaled up/down accordingly.
     */
    @JsonProperty("parallaxScaling")
    public boolean getParallaxScaling() {
        return parallaxScaling;
    }

    @JsonProperty("parallaxScaling")
    public void setParallaxScaling(boolean value) {
        this.parallaxScaling = value;
    }

    /**
     * X offset of the layer, in pixels (IMPORTANT: this should be added to the `LayerInstance`
     * optional offset)
     */
    @JsonProperty("pxOffsetX")
    public long getPxOffsetX() {
        return pxOffsetX;
    }

    @JsonProperty("pxOffsetX")
    public void setPxOffsetX(long value) {
        this.pxOffsetX = value;
    }

    /**
     * Y offset of the layer, in pixels (IMPORTANT: this should be added to the `LayerInstance`
     * optional offset)
     */
    @JsonProperty("pxOffsetY")
    public long getPxOffsetY() {
        return pxOffsetY;
    }

    @JsonProperty("pxOffsetY")
    public void setPxOffsetY(long value) {
        this.pxOffsetY = value;
    }

    /**
     * If TRUE, the content of this layer will be used when rendering levels in a simplified way
     * for the world view
     */
    @JsonProperty("renderInWorldView")
    public boolean getRenderInWorldView() {
        return renderInWorldView;
    }

    @JsonProperty("renderInWorldView")
    public void setRenderInWorldView(boolean value) {
        this.renderInWorldView = value;
    }

    /**
     * An array of tags to filter Entities that can be added to this layer
     */
    @JsonProperty("requiredTags")
    public String[] getRequiredTags() {
        return requiredTags;
    }

    @JsonProperty("requiredTags")
    public void setRequiredTags(String[] value) {
        this.requiredTags = value;
    }

    /**
     * If the tiles are smaller or larger than the layer grid, the pivot value will be used to
     * position the tile relatively its grid cell.
     */
    @JsonProperty("tilePivotX")
    public double getTilePivotX() {
        return tilePivotX;
    }

    @JsonProperty("tilePivotX")
    public void setTilePivotX(double value) {
        this.tilePivotX = value;
    }

    /**
     * If the tiles are smaller or larger than the layer grid, the pivot value will be used to
     * position the tile relatively its grid cell.
     */
    @JsonProperty("tilePivotY")
    public double getTilePivotY() {
        return tilePivotY;
    }

    @JsonProperty("tilePivotY")
    public void setTilePivotY(double value) {
        this.tilePivotY = value;
    }

    /**
     * Reference to the default Tileset UID being used by this layer definition.<br/>
     * **WARNING**: some layer *instances* might use a different tileset. So most of the time,
     * you should probably use the `__tilesetDefUid` value found in layer instances.<br/>  Note:
     * since version 1.0.0, the old `autoTilesetDefUid` was removed and merged into this value.
     */
    @JsonProperty("tilesetDefUid")
    public Long getTilesetDefUid() {
        return tilesetDefUid;
    }

    @JsonProperty("tilesetDefUid")
    public void setTilesetDefUid(Long value) {
        this.tilesetDefUid = value;
    }

    /**
     * Type of the layer as Haxe Enum Possible values: `IntGrid`, `Entities`, `Tiles`,
     * `AutoLayer`
     */
    @JsonProperty("type")
    public Type getLayerDefinitionType() {
        return layerDefinitionType;
    }

    @JsonProperty("type")
    public void setLayerDefinitionType(Type value) {
        this.layerDefinitionType = value;
    }

    /**
     * User defined color for the UI
     */
    @JsonProperty("uiColor")
    public String getUIColor() {
        return uiColor;
    }

    @JsonProperty("uiColor")
    public void setUIColor(String value) {
        this.uiColor = value;
    }

    /**
     * Unique Int identifier
     */
    @JsonProperty("uid")
    public long getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(long value) {
        this.uid = value;
    }
}
