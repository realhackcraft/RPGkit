package ldtk;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This file is a JSON schema of files created by LDtk level editor (https://ldtk.io).
 * <p>
 * This is the root of any Project JSON file. It contains:  - the project settings, - an
 * array of levels, - a group of definitions (that can probably be safely ignored for most
 * users).
 */
public class LDtk {
    private ForcedRefs forcedRefs;
    private double appBuildID;
    private long backupLimit;
    private boolean backupOnSave;
    private String backupRelPath;
    private String bgColor;
    private LdtkCustomCommand[] customCommands;
    private long defaultGridSize;
    private String defaultLevelBgColor;
    private Long defaultLevelHeight;
    private Long defaultLevelWidth;
    private double defaultPivotX;
    private double defaultPivotY;
    private Definitions defs;
    private String dummyWorldIid;
    private boolean exportLevelBg;
    private Boolean exportPNG;
    private boolean exportTiled;
    private boolean externalLevels;
    private Flag[] flags;
    private IdentifierStyle identifierStyle;
    private String iid;
    private ImageExportMode imageExportMode;
    private String jsonVersion;
    private String levelNamePattern;
    private Level[] levels;
    private boolean minifyJSON;
    private long nextUid;
    private String pngFilePattern;
    private boolean simplifiedExport;
    private LdtkTableOfContentEntry[] toc;
    private String tutorialDesc;
    private Long worldGridHeight;
    private Long worldGridWidth;
    private WorldLayout worldLayout;
    private World[] worlds;

    /**
     * This object is not actually used by LDtk. It ONLY exists to force explicit references to
     * all types, to make sure QuickType finds them and integrate all of them. Otherwise,
     * Quicktype will drop types that are not explicitely used.
     */
    @JsonProperty("__FORCED_REFS")
    public ForcedRefs getForcedRefs() {
        return forcedRefs;
    }

    @JsonProperty("__FORCED_REFS")
    public void setForcedRefs(ForcedRefs value) {
        this.forcedRefs = value;
    }

    /**
     * LDtk application build identifier.<br/>  This is only used to identify the LDtk version
     * that generated this particular project file, which can be useful for specific bug fixing.
     * Note that the build identifier is just the date of the release, so it's not unique to
     * each user (one single global ID per LDtk public release), and as a result, completely
     * anonymous.
     */
    @JsonProperty("appBuildId")
    public double getAppBuildID() {
        return appBuildID;
    }

    @JsonProperty("appBuildId")
    public void setAppBuildID(double value) {
        this.appBuildID = value;
    }

    /**
     * Number of backup files to keep, if the `backupOnSave` is TRUE
     */
    @JsonProperty("backupLimit")
    public long getBackupLimit() {
        return backupLimit;
    }

    @JsonProperty("backupLimit")
    public void setBackupLimit(long value) {
        this.backupLimit = value;
    }

    /**
     * If TRUE, an extra copy of the project will be created in a sub folder, when saving.
     */
    @JsonProperty("backupOnSave")
    public boolean getBackupOnSave() {
        return backupOnSave;
    }

    @JsonProperty("backupOnSave")
    public void setBackupOnSave(boolean value) {
        this.backupOnSave = value;
    }

    /**
     * Target relative path to store backup files
     */
    @JsonProperty("backupRelPath")
    public String getBackupRelPath() {
        return backupRelPath;
    }

    @JsonProperty("backupRelPath")
    public void setBackupRelPath(String value) {
        this.backupRelPath = value;
    }

    /**
     * Project background color
     */
    @JsonProperty("bgColor")
    public String getBgColor() {
        return bgColor;
    }

    @JsonProperty("bgColor")
    public void setBgColor(String value) {
        this.bgColor = value;
    }

    /**
     * An array of command lines that can be ran manually by the user
     */
    @JsonProperty("customCommands")
    public LdtkCustomCommand[] getCustomCommands() {
        return customCommands;
    }

    @JsonProperty("customCommands")
    public void setCustomCommands(LdtkCustomCommand[] value) {
        this.customCommands = value;
    }

    /**
     * Default grid size for new layers
     */
    @JsonProperty("defaultGridSize")
    public long getDefaultGridSize() {
        return defaultGridSize;
    }

    @JsonProperty("defaultGridSize")
    public void setDefaultGridSize(long value) {
        this.defaultGridSize = value;
    }

    /**
     * Default background color of levels
     */
    @JsonProperty("defaultLevelBgColor")
    public String getDefaultLevelBgColor() {
        return defaultLevelBgColor;
    }

    @JsonProperty("defaultLevelBgColor")
    public void setDefaultLevelBgColor(String value) {
        this.defaultLevelBgColor = value;
    }

    /**
     * **WARNING**: this field will move to the `worlds` array after the "multi-worlds" update.
     * It will then be `null`. You can enable the Multi-worlds advanced project option to enable
     * the change immediately.<br/><br/>  Default new level height
     */
    @JsonProperty("defaultLevelHeight")
    public Long getDefaultLevelHeight() {
        return defaultLevelHeight;
    }

    @JsonProperty("defaultLevelHeight")
    public void setDefaultLevelHeight(Long value) {
        this.defaultLevelHeight = value;
    }

    /**
     * **WARNING**: this field will move to the `worlds` array after the "multi-worlds" update.
     * It will then be `null`. You can enable the Multi-worlds advanced project option to enable
     * the change immediately.<br/><br/>  Default new level width
     */
    @JsonProperty("defaultLevelWidth")
    public Long getDefaultLevelWidth() {
        return defaultLevelWidth;
    }

    @JsonProperty("defaultLevelWidth")
    public void setDefaultLevelWidth(Long value) {
        this.defaultLevelWidth = value;
    }

    /**
     * Default X pivot (0 to 1) for new entities
     */
    @JsonProperty("defaultPivotX")
    public double getDefaultPivotX() {
        return defaultPivotX;
    }

    @JsonProperty("defaultPivotX")
    public void setDefaultPivotX(double value) {
        this.defaultPivotX = value;
    }

    /**
     * Default Y pivot (0 to 1) for new entities
     */
    @JsonProperty("defaultPivotY")
    public double getDefaultPivotY() {
        return defaultPivotY;
    }

    @JsonProperty("defaultPivotY")
    public void setDefaultPivotY(double value) {
        this.defaultPivotY = value;
    }

    /**
     * A structure containing all the definitions of this project
     */
    @JsonProperty("defs")
    public Definitions getDefs() {
        return defs;
    }

    @JsonProperty("defs")
    public void setDefs(Definitions value) {
        this.defs = value;
    }

    /**
     * If the project isn't in MultiWorlds mode, this is the IID of the internal "dummy" World.
     */
    @JsonProperty("dummyWorldIid")
    public String getDummyWorldIid() {
        return dummyWorldIid;
    }

    @JsonProperty("dummyWorldIid")
    public void setDummyWorldIid(String value) {
        this.dummyWorldIid = value;
    }

    /**
     * If TRUE, the exported PNGs will include the level background (color or image).
     */
    @JsonProperty("exportLevelBg")
    public boolean getExportLevelBg() {
        return exportLevelBg;
    }

    @JsonProperty("exportLevelBg")
    public void setExportLevelBg(boolean value) {
        this.exportLevelBg = value;
    }

    /**
     * **WARNING**: this deprecated value is no longer exported since version 0.9.3  Replaced
     * by: `imageExportMode`
     */
    @JsonProperty("exportPng")
    public Boolean getExportPNG() {
        return exportPNG;
    }

    @JsonProperty("exportPng")
    public void setExportPNG(Boolean value) {
        this.exportPNG = value;
    }

    /**
     * If TRUE, a Tiled compatible file will also be generated along with the LDtk JSON file
     * (default is FALSE)
     */
    @JsonProperty("exportTiled")
    public boolean getExportTiled() {
        return exportTiled;
    }

    @JsonProperty("exportTiled")
    public void setExportTiled(boolean value) {
        this.exportTiled = value;
    }

    /**
     * If TRUE, one file will be saved for the project (incl. all its definitions) and one file
     * in a sub-folder for each level.
     */
    @JsonProperty("externalLevels")
    public boolean getExternalLevels() {
        return externalLevels;
    }

    @JsonProperty("externalLevels")
    public void setExternalLevels(boolean value) {
        this.externalLevels = value;
    }

    /**
     * An array containing various advanced flags (ie. options or other states). Possible
     * values: `DiscardPreCsvIntGrid`, `ExportPreCsvIntGridFormat`, `IgnoreBackupSuggest`,
     * `PrependIndexToLevelFileNames`, `MultiWorlds`, `UseMultilinesType`
     */
    @JsonProperty("flags")
    public Flag[] getFlags() {
        return flags;
    }

    @JsonProperty("flags")
    public void setFlags(Flag[] value) {
        this.flags = value;
    }

    /**
     * Naming convention for Identifiers (first-letter uppercase, full uppercase etc.) Possible
     * values: `Capitalize`, `Uppercase`, `Lowercase`, `Free`
     */
    @JsonProperty("identifierStyle")
    public IdentifierStyle getIdentifierStyle() {
        return identifierStyle;
    }

    @JsonProperty("identifierStyle")
    public void setIdentifierStyle(IdentifierStyle value) {
        this.identifierStyle = value;
    }

    /**
     * Unique project identifier
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
     * "Image export" option when saving project. Possible values: `None`, `OneImagePerLayer`,
     * `OneImagePerLevel`, `LayersAndLevels`
     */
    @JsonProperty("imageExportMode")
    public ImageExportMode getImageExportMode() {
        return imageExportMode;
    }

    @JsonProperty("imageExportMode")
    public void setImageExportMode(ImageExportMode value) {
        this.imageExportMode = value;
    }

    /**
     * File format version
     */
    @JsonProperty("jsonVersion")
    public String getJSONVersion() {
        return jsonVersion;
    }

    @JsonProperty("jsonVersion")
    public void setJSONVersion(String value) {
        this.jsonVersion = value;
    }

    /**
     * The default naming convention for level identifiers.
     */
    @JsonProperty("levelNamePattern")
    public String getLevelNamePattern() {
        return levelNamePattern;
    }

    @JsonProperty("levelNamePattern")
    public void setLevelNamePattern(String value) {
        this.levelNamePattern = value;
    }

    /**
     * All levels. The order of this array is only relevant in `LinearHorizontal` and
     * `linearVertical` world layouts (see `worldLayout` value).<br/>  Otherwise, you should
     * refer to the `worldX`,`worldY` coordinates of each Level.
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
     * If TRUE, the Json is partially minified (no indentation, nor line breaks, default is
     * FALSE)
     */
    @JsonProperty("minifyJson")
    public boolean getMinifyJSON() {
        return minifyJSON;
    }

    @JsonProperty("minifyJson")
    public void setMinifyJSON(boolean value) {
        this.minifyJSON = value;
    }

    /**
     * Next Unique integer ID available
     */
    @JsonProperty("nextUid")
    public long getNextUid() {
        return nextUid;
    }

    @JsonProperty("nextUid")
    public void setNextUid(long value) {
        this.nextUid = value;
    }

    /**
     * File naming pattern for exported PNGs
     */
    @JsonProperty("pngFilePattern")
    public String getPNGFilePattern() {
        return pngFilePattern;
    }

    @JsonProperty("pngFilePattern")
    public void setPNGFilePattern(String value) {
        this.pngFilePattern = value;
    }

    /**
     * If TRUE, a very simplified will be generated on saving, for quicker & easier engine
     * integration.
     */
    @JsonProperty("simplifiedExport")
    public boolean getSimplifiedExport() {
        return simplifiedExport;
    }

    @JsonProperty("simplifiedExport")
    public void setSimplifiedExport(boolean value) {
        this.simplifiedExport = value;
    }

    /**
     * All instances of entities that have their `exportToToc` flag enabled are listed in this
     * array.
     */
    @JsonProperty("toc")
    public LdtkTableOfContentEntry[] getToc() {
        return toc;
    }

    @JsonProperty("toc")
    public void setToc(LdtkTableOfContentEntry[] value) {
        this.toc = value;
    }

    /**
     * This optional description is used by LDtk Samples to show up some informations and
     * instructions.
     */
    @JsonProperty("tutorialDesc")
    public String getTutorialDesc() {
        return tutorialDesc;
    }

    @JsonProperty("tutorialDesc")
    public void setTutorialDesc(String value) {
        this.tutorialDesc = value;
    }

    /**
     * **WARNING**: this field will move to the `worlds` array after the "multi-worlds" update.
     * It will then be `null`. You can enable the Multi-worlds advanced project option to enable
     * the change immediately.<br/><br/>  Height of the world grid in pixels.
     */
    @JsonProperty("worldGridHeight")
    public Long getWorldGridHeight() {
        return worldGridHeight;
    }

    @JsonProperty("worldGridHeight")
    public void setWorldGridHeight(Long value) {
        this.worldGridHeight = value;
    }

    /**
     * **WARNING**: this field will move to the `worlds` array after the "multi-worlds" update.
     * It will then be `null`. You can enable the Multi-worlds advanced project option to enable
     * the change immediately.<br/><br/>  Width of the world grid in pixels.
     */
    @JsonProperty("worldGridWidth")
    public Long getWorldGridWidth() {
        return worldGridWidth;
    }

    @JsonProperty("worldGridWidth")
    public void setWorldGridWidth(Long value) {
        this.worldGridWidth = value;
    }

    /**
     * **WARNING**: this field will move to the `worlds` array after the "multi-worlds" update.
     * It will then be `null`. You can enable the Multi-worlds advanced project option to enable
     * the change immediately.<br/><br/>  An enum that describes how levels are organized in
     * this project (ie. linearly or in a 2D space). Possible values: &lt;`null`&gt;, `Free`,
     * `GridVania`, `LinearHorizontal`, `LinearVertical`
     */
    @JsonProperty("worldLayout")
    public WorldLayout getWorldLayout() {
        return worldLayout;
    }

    @JsonProperty("worldLayout")
    public void setWorldLayout(WorldLayout value) {
        this.worldLayout = value;
    }

    /**
     * This array will be empty, unless you enable the Multi-Worlds in the project advanced
     * settings.<br/><br/> - in current version, a LDtk project file can only contain a single
     * world with multiple levels in it. In this case, levels and world layout related settings
     * are stored in the root of the JSON.<br/> - with "Multi-worlds" enabled, there will be a
     * `worlds` array in root, each world containing levels and layout settings. Basically, it's
     * pretty much only about moving the `levels` array to the `worlds` array, along with world
     * layout related values (eg. `worldGridWidth` etc).<br/><br/>If you want to start
     * supporting this future update easily, please refer to this documentation:
     * <a href="https://github.com/deepnight/ldtk/issues/231">issue 231</a>.
     */
    @JsonProperty("worlds")
    public World[] getWorlds() {
        return worlds;
    }

    @JsonProperty("worlds")
    public void setWorlds(World[] value) {
        this.worlds = value;
    }
}
