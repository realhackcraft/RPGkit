package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object is not actually used by LDtk. It ONLY exists to force explicit references to
 * all types, to make sure QuickType finds them and integrate all of them. Otherwise,
 * Quicktype will drop types that are not explicitely used.
 */
public class ForcedRefs {
    private AutoLayerRuleGroup autoLayerRuleGroup;
    private AutoLayerRuleDefinition autoRuleDef;
    private LdtkCustomCommand customCommand;
    private Definitions definitions;
    private EntityDefinition entityDef;
    private EntityInstance entityInstance;
    private ReferenceToAnEntityInstance entityReferenceInfos;
    private EnumDefinition enumDef;
    private EnumValueDefinition enumDefValues;
    private EnumTagValue enumTagValue;
    private FieldDefinition fieldDef;
    private FieldInstance fieldInstance;
    private GridPoint gridPoint;
    private IntGridValueDefinition intGridValueDef;
    private IntGridValueInstance intGridValueInstance;
    private LayerDefinition layerDef;
    private LayerInstance layerInstance;
    private Level level;
    private LevelBackgroundPosition levelBgPosInfos;
    private NeighbourLevel neighbourLevel;
    private LdtkTableOfContentEntry tableOfContentEntry;
    private TileInstance tile;
    private TileCustomMetadata tileCustomMetadata;
    private TilesetDefinition tilesetDef;
    private TilesetRectangle tilesetRect;
    private World world;

    @JsonProperty("AutoLayerRuleGroup")
    public AutoLayerRuleGroup getAutoLayerRuleGroup() {
        return autoLayerRuleGroup;
    }

    @JsonProperty("AutoLayerRuleGroup")
    public void setAutoLayerRuleGroup(AutoLayerRuleGroup value) {
        this.autoLayerRuleGroup = value;
    }

    @JsonProperty("AutoRuleDef")
    public AutoLayerRuleDefinition getAutoRuleDef() {
        return autoRuleDef;
    }

    @JsonProperty("AutoRuleDef")
    public void setAutoRuleDef(AutoLayerRuleDefinition value) {
        this.autoRuleDef = value;
    }

    @JsonProperty("CustomCommand")
    public LdtkCustomCommand getCustomCommand() {
        return customCommand;
    }

    @JsonProperty("CustomCommand")
    public void setCustomCommand(LdtkCustomCommand value) {
        this.customCommand = value;
    }

    @JsonProperty("Definitions")
    public Definitions getDefinitions() {
        return definitions;
    }

    @JsonProperty("Definitions")
    public void setDefinitions(Definitions value) {
        this.definitions = value;
    }

    @JsonProperty("EntityDef")
    public EntityDefinition getEntityDef() {
        return entityDef;
    }

    @JsonProperty("EntityDef")
    public void setEntityDef(EntityDefinition value) {
        this.entityDef = value;
    }

    @JsonProperty("EntityInstance")
    public EntityInstance getEntityInstance() {
        return entityInstance;
    }

    @JsonProperty("EntityInstance")
    public void setEntityInstance(EntityInstance value) {
        this.entityInstance = value;
    }

    @JsonProperty("EntityReferenceInfos")
    public ReferenceToAnEntityInstance getEntityReferenceInfos() {
        return entityReferenceInfos;
    }

    @JsonProperty("EntityReferenceInfos")
    public void setEntityReferenceInfos(ReferenceToAnEntityInstance value) {
        this.entityReferenceInfos = value;
    }

    @JsonProperty("EnumDef")
    public EnumDefinition getEnumDef() {
        return enumDef;
    }

    @JsonProperty("EnumDef")
    public void setEnumDef(EnumDefinition value) {
        this.enumDef = value;
    }

    @JsonProperty("EnumDefValues")
    public EnumValueDefinition getEnumDefValues() {
        return enumDefValues;
    }

    @JsonProperty("EnumDefValues")
    public void setEnumDefValues(EnumValueDefinition value) {
        this.enumDefValues = value;
    }

    @JsonProperty("EnumTagValue")
    public EnumTagValue getEnumTagValue() {
        return enumTagValue;
    }

    @JsonProperty("EnumTagValue")
    public void setEnumTagValue(EnumTagValue value) {
        this.enumTagValue = value;
    }

    @JsonProperty("FieldDef")
    public FieldDefinition getFieldDef() {
        return fieldDef;
    }

    @JsonProperty("FieldDef")
    public void setFieldDef(FieldDefinition value) {
        this.fieldDef = value;
    }

    @JsonProperty("FieldInstance")
    public FieldInstance getFieldInstance() {
        return fieldInstance;
    }

    @JsonProperty("FieldInstance")
    public void setFieldInstance(FieldInstance value) {
        this.fieldInstance = value;
    }

    @JsonProperty("GridPoint")
    public GridPoint getGridPoint() {
        return gridPoint;
    }

    @JsonProperty("GridPoint")
    public void setGridPoint(GridPoint value) {
        this.gridPoint = value;
    }

    @JsonProperty("IntGridValueDef")
    public IntGridValueDefinition getIntGridValueDef() {
        return intGridValueDef;
    }

    @JsonProperty("IntGridValueDef")
    public void setIntGridValueDef(IntGridValueDefinition value) {
        this.intGridValueDef = value;
    }

    @JsonProperty("IntGridValueInstance")
    public IntGridValueInstance getIntGridValueInstance() {
        return intGridValueInstance;
    }

    @JsonProperty("IntGridValueInstance")
    public void setIntGridValueInstance(IntGridValueInstance value) {
        this.intGridValueInstance = value;
    }

    @JsonProperty("LayerDef")
    public LayerDefinition getLayerDef() {
        return layerDef;
    }

    @JsonProperty("LayerDef")
    public void setLayerDef(LayerDefinition value) {
        this.layerDef = value;
    }

    @JsonProperty("LayerInstance")
    public LayerInstance getLayerInstance() {
        return layerInstance;
    }

    @JsonProperty("LayerInstance")
    public void setLayerInstance(LayerInstance value) {
        this.layerInstance = value;
    }

    @JsonProperty("Level")
    public Level getLevel() {
        return level;
    }

    @JsonProperty("Level")
    public void setLevel(Level value) {
        this.level = value;
    }

    @JsonProperty("LevelBgPosInfos")
    public LevelBackgroundPosition getLevelBgPosInfos() {
        return levelBgPosInfos;
    }

    @JsonProperty("LevelBgPosInfos")
    public void setLevelBgPosInfos(LevelBackgroundPosition value) {
        this.levelBgPosInfos = value;
    }

    @JsonProperty("NeighbourLevel")
    public NeighbourLevel getNeighbourLevel() {
        return neighbourLevel;
    }

    @JsonProperty("NeighbourLevel")
    public void setNeighbourLevel(NeighbourLevel value) {
        this.neighbourLevel = value;
    }

    @JsonProperty("TableOfContentEntry")
    public LdtkTableOfContentEntry getTableOfContentEntry() {
        return tableOfContentEntry;
    }

    @JsonProperty("TableOfContentEntry")
    public void setTableOfContentEntry(LdtkTableOfContentEntry value) {
        this.tableOfContentEntry = value;
    }

    @JsonProperty("Tile")
    public TileInstance getTile() {
        return tile;
    }

    @JsonProperty("Tile")
    public void setTile(TileInstance value) {
        this.tile = value;
    }

    @JsonProperty("TileCustomMetadata")
    public TileCustomMetadata getTileCustomMetadata() {
        return tileCustomMetadata;
    }

    @JsonProperty("TileCustomMetadata")
    public void setTileCustomMetadata(TileCustomMetadata value) {
        this.tileCustomMetadata = value;
    }

    @JsonProperty("TilesetDef")
    public TilesetDefinition getTilesetDef() {
        return tilesetDef;
    }

    @JsonProperty("TilesetDef")
    public void setTilesetDef(TilesetDefinition value) {
        this.tilesetDef = value;
    }

    @JsonProperty("TilesetRect")
    public TilesetRectangle getTilesetRect() {
        return tilesetRect;
    }

    @JsonProperty("TilesetRect")
    public void setTilesetRect(TilesetRectangle value) {
        this.tilesetRect = value;
    }

    @JsonProperty("World")
    public World getWorld() {
        return world;
    }

    @JsonProperty("World")
    public void setWorld(World value) {
        this.world = value;
    }
}
