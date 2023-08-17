package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This section is mostly only intended for the LDtk editor app itself. You can safely
 * ignore it.
 */
public class FieldDefinition {
    private String type;
    private String[] acceptFileTypes;
    private AllowedRefs allowedRefs;
    private Long allowedRefsEntityUid;
    private String[] allowedRefTags;
    private boolean allowOutOfLevelRef;
    private Long arrayMaxLength;
    private Long arrayMinLength;
    private boolean autoChainRef;
    private boolean canBeNull;
    private Object defaultOverride;
    private String doc;
    private boolean editorAlwaysShow;
    private boolean editorCutLongValues;
    private EditorDisplayMode editorDisplayMode;
    private EditorDisplayPos editorDisplayPos;
    private double editorDisplayScale;
    private EditorLinkStyle editorLinkStyle;
    private boolean editorShowInWorld;
    private String editorTextPrefix;
    private String editorTextSuffix;
    private String identifier;
    private boolean isArray;
    private Double max;
    private Double min;
    private String regex;
    private boolean symmetricalRef;
    private TextLanguageMode textLanguageMode;
    private Long tilesetUid;
    private String fieldDefinitionType;
    private long uid;
    private boolean useForSmartColor;

    /**
     * Human readable value type. Possible values: `Int, Float, String, Bool, Color,
     * ExternEnum.XXX, LocalEnum.XXX, Point, FilePath`.<br/>  If the field is an array, this
     * field will look like `Array<...>` (eg. `Array<Int>`, `Array<Point>` etc.)<br/>  NOTE: if
     * you enable the advanced option **Use Multilines type**, you will have "*Multilines*"
     * instead of "*String*" when relevant.
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
     * Optional list of accepted file extensions for FilePath value type. Includes the dot:
     * `.ext`
     */
    @JsonProperty("acceptFileTypes")
    public String[] getAcceptFileTypes() {
        return acceptFileTypes;
    }

    @JsonProperty("acceptFileTypes")
    public void setAcceptFileTypes(String[] value) {
        this.acceptFileTypes = value;
    }

    /**
     * Possible values: `Any`, `OnlySame`, `OnlyTags`, `OnlySpecificEntity`
     */
    @JsonProperty("allowedRefs")
    public AllowedRefs getAllowedRefs() {
        return allowedRefs;
    }

    @JsonProperty("allowedRefs")
    public void setAllowedRefs(AllowedRefs value) {
        this.allowedRefs = value;
    }

    @JsonProperty("allowedRefsEntityUid")
    public Long getAllowedRefsEntityUid() {
        return allowedRefsEntityUid;
    }

    @JsonProperty("allowedRefsEntityUid")
    public void setAllowedRefsEntityUid(Long value) {
        this.allowedRefsEntityUid = value;
    }

    @JsonProperty("allowedRefTags")
    public String[] getAllowedRefTags() {
        return allowedRefTags;
    }

    @JsonProperty("allowedRefTags")
    public void setAllowedRefTags(String[] value) {
        this.allowedRefTags = value;
    }

    @JsonProperty("allowOutOfLevelRef")
    public boolean getAllowOutOfLevelRef() {
        return allowOutOfLevelRef;
    }

    @JsonProperty("allowOutOfLevelRef")
    public void setAllowOutOfLevelRef(boolean value) {
        this.allowOutOfLevelRef = value;
    }

    /**
     * Array max length
     */
    @JsonProperty("arrayMaxLength")
    public Long getArrayMaxLength() {
        return arrayMaxLength;
    }

    @JsonProperty("arrayMaxLength")
    public void setArrayMaxLength(Long value) {
        this.arrayMaxLength = value;
    }

    /**
     * Array min length
     */
    @JsonProperty("arrayMinLength")
    public Long getArrayMinLength() {
        return arrayMinLength;
    }

    @JsonProperty("arrayMinLength")
    public void setArrayMinLength(Long value) {
        this.arrayMinLength = value;
    }

    @JsonProperty("autoChainRef")
    public boolean getAutoChainRef() {
        return autoChainRef;
    }

    @JsonProperty("autoChainRef")
    public void setAutoChainRef(boolean value) {
        this.autoChainRef = value;
    }

    /**
     * TRUE if the value can be null. For arrays, TRUE means it can contain null values
     * (exception: array of Points can't have null values).
     */
    @JsonProperty("canBeNull")
    public boolean getCanBeNull() {
        return canBeNull;
    }

    @JsonProperty("canBeNull")
    public void setCanBeNull(boolean value) {
        this.canBeNull = value;
    }

    /**
     * Default value if selected value is null or invalid.
     */
    @JsonProperty("defaultOverride")
    public Object getDefaultOverride() {
        return defaultOverride;
    }

    @JsonProperty("defaultOverride")
    public void setDefaultOverride(Object value) {
        this.defaultOverride = value;
    }

    /**
     * User defined documentation for this field to provide help/tips to level designers about
     * accepted values.
     */
    @JsonProperty("doc")
    public String getDoc() {
        return doc;
    }

    @JsonProperty("doc")
    public void setDoc(String value) {
        this.doc = value;
    }

    @JsonProperty("editorAlwaysShow")
    public boolean getEditorAlwaysShow() {
        return editorAlwaysShow;
    }

    @JsonProperty("editorAlwaysShow")
    public void setEditorAlwaysShow(boolean value) {
        this.editorAlwaysShow = value;
    }

    @JsonProperty("editorCutLongValues")
    public boolean getEditorCutLongValues() {
        return editorCutLongValues;
    }

    @JsonProperty("editorCutLongValues")
    public void setEditorCutLongValues(boolean value) {
        this.editorCutLongValues = value;
    }

    /**
     * Possible values: `Hidden`, `ValueOnly`, `NameAndValue`, `EntityTile`, `LevelTile`,
     * `Points`, `PointStar`, `PointPath`, `PointPathLoop`, `RadiusPx`, `RadiusGrid`,
     * `ArrayCountWithLabel`, `ArrayCountNoLabel`, `RefLinkBetweenPivots`,
     * `RefLinkBetweenCenters`
     */
    @JsonProperty("editorDisplayMode")
    public EditorDisplayMode getEditorDisplayMode() {
        return editorDisplayMode;
    }

    @JsonProperty("editorDisplayMode")
    public void setEditorDisplayMode(EditorDisplayMode value) {
        this.editorDisplayMode = value;
    }

    /**
     * Possible values: `Above`, `Center`, `Beneath`
     */
    @JsonProperty("editorDisplayPos")
    public EditorDisplayPos getEditorDisplayPos() {
        return editorDisplayPos;
    }

    @JsonProperty("editorDisplayPos")
    public void setEditorDisplayPos(EditorDisplayPos value) {
        this.editorDisplayPos = value;
    }

    @JsonProperty("editorDisplayScale")
    public double getEditorDisplayScale() {
        return editorDisplayScale;
    }

    @JsonProperty("editorDisplayScale")
    public void setEditorDisplayScale(double value) {
        this.editorDisplayScale = value;
    }

    /**
     * Possible values: `ZigZag`, `StraightArrow`, `CurvedArrow`, `ArrowsLine`, `DashedLine`
     */
    @JsonProperty("editorLinkStyle")
    public EditorLinkStyle getEditorLinkStyle() {
        return editorLinkStyle;
    }

    @JsonProperty("editorLinkStyle")
    public void setEditorLinkStyle(EditorLinkStyle value) {
        this.editorLinkStyle = value;
    }

    @JsonProperty("editorShowInWorld")
    public boolean getEditorShowInWorld() {
        return editorShowInWorld;
    }

    @JsonProperty("editorShowInWorld")
    public void setEditorShowInWorld(boolean value) {
        this.editorShowInWorld = value;
    }

    @JsonProperty("editorTextPrefix")
    public String getEditorTextPrefix() {
        return editorTextPrefix;
    }

    @JsonProperty("editorTextPrefix")
    public void setEditorTextPrefix(String value) {
        this.editorTextPrefix = value;
    }

    @JsonProperty("editorTextSuffix")
    public String getEditorTextSuffix() {
        return editorTextSuffix;
    }

    @JsonProperty("editorTextSuffix")
    public void setEditorTextSuffix(String value) {
        this.editorTextSuffix = value;
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
     * TRUE if the value is an array of multiple values
     */
    @JsonProperty("isArray")
    public boolean getIsArray() {
        return isArray;
    }

    @JsonProperty("isArray")
    public void setIsArray(boolean value) {
        this.isArray = value;
    }

    /**
     * Max limit for value, if applicable
     */
    @JsonProperty("max")
    public Double getMax() {
        return max;
    }

    @JsonProperty("max")
    public void setMax(Double value) {
        this.max = value;
    }

    /**
     * Min limit for value, if applicable
     */
    @JsonProperty("min")
    public Double getMin() {
        return min;
    }

    @JsonProperty("min")
    public void setMin(Double value) {
        this.min = value;
    }

    /**
     * Optional regular expression that needs to be matched to accept values. Expected format:
     * `/some_reg_ex/g`, with optional "i" flag.
     */
    @JsonProperty("regex")
    public String getRegex() {
        return regex;
    }

    @JsonProperty("regex")
    public void setRegex(String value) {
        this.regex = value;
    }

    @JsonProperty("symmetricalRef")
    public boolean getSymmetricalRef() {
        return symmetricalRef;
    }

    @JsonProperty("symmetricalRef")
    public void setSymmetricalRef(boolean value) {
        this.symmetricalRef = value;
    }

    /**
     * Possible values: &lt;`null`&gt;, `LangPython`, `LangRuby`, `LangJS`, `LangLua`, `LangC`,
     * `LangHaxe`, `LangMarkdown`, `LangJson`, `LangXml`, `LangLog`
     */
    @JsonProperty("textLanguageMode")
    public TextLanguageMode getTextLanguageMode() {
        return textLanguageMode;
    }

    @JsonProperty("textLanguageMode")
    public void setTextLanguageMode(TextLanguageMode value) {
        this.textLanguageMode = value;
    }

    /**
     * UID of the tileset used for a Tile
     */
    @JsonProperty("tilesetUid")
    public Long getTilesetUid() {
        return tilesetUid;
    }

    @JsonProperty("tilesetUid")
    public void setTilesetUid(Long value) {
        this.tilesetUid = value;
    }

    /**
     * Internal enum representing the possible field types. Possible values: F_Int, F_Float,
     * F_String, F_Text, F_Bool, F_Color, F_Enum(...), F_Point, F_Path, F_EntityRef, F_Tile
     */
    @JsonProperty("type")
    public String getFieldDefinitionType() {
        return fieldDefinitionType;
    }

    @JsonProperty("type")
    public void setFieldDefinitionType(String value) {
        this.fieldDefinitionType = value;
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

    /**
     * If TRUE, the color associated with this field will override the Entity or Level default
     * color in the editor UI. For Enum fields, this would be the color associated to their
     * values.
     */
    @JsonProperty("useForSmartColor")
    public boolean getUseForSmartColor() {
        return useForSmartColor;
    }

    @JsonProperty("useForSmartColor")
    public void setUseForSmartColor(boolean value) {
        this.useForSmartColor = value;
    }
}
