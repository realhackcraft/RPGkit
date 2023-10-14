package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.*;
import java.util.Map;

/**
 * The `Tileset` definition is the most important part among project definitions. It
 * contains some extra informations about each integrated tileset. If you only had to parse
 * one definition section, that would be the one.
 */
public class TilesetDefinition {
    private long cHei;
    private long cWid;
    private Map<String, Object> cachedPixelData;
    private TileCustomMetadata[] customData;
    private EmbedAtlas embedAtlas;
    private EnumTagValue[] enumTags;
    private String identifier;
    private long padding;
    private long pxHei;
    private long pxWid;
    private String relPath;
    private Map<String, Object>[] savedSelections;
    private long spacing;
    private String[] tags;
    private Long tagsSourceEnumUid;
    private long tileGridSize;
    private long uid;

    /**
     * Grid-based height
     */
    @JsonProperty("__cHei")
    public long getCHei() { return cHei; }
    @JsonProperty("__cHei")
    public void setCHei(long value) { this.cHei = value; }

    /**
     * Grid-based width
     */
    @JsonProperty("__cWid")
    public long getCWid() { return cWid; }
    @JsonProperty("__cWid")
    public void setCWid(long value) { this.cWid = value; }

    /**
     * The following data is used internally for various optimizations. It's always synced with
     * source image changes.
     */
    @JsonProperty("cachedPixelData")
    public Map<String, Object> getCachedPixelData() { return cachedPixelData; }
    @JsonProperty("cachedPixelData")
    public void setCachedPixelData(Map<String, Object> value) { this.cachedPixelData = value; }

    /**
     * An array of custom tile metadata
     */
    @JsonProperty("customData")
    public TileCustomMetadata[] getCustomData() { return customData; }
    @JsonProperty("customData")
    public void setCustomData(TileCustomMetadata[] value) { this.customData = value; }

    /**
     * If this value is set, then it means that this atlas uses an internal LDtk atlas image
     * instead of a loaded one. Possible values: &lt;`null`&gt;, `LdtkIcons`
     */
    @JsonProperty("embedAtlas")
    public EmbedAtlas getEmbedAtlas() { return embedAtlas; }
    @JsonProperty("embedAtlas")
    public void setEmbedAtlas(EmbedAtlas value) { this.embedAtlas = value; }

    /**
     * Tileset tags using Enum values specified by `tagsSourceEnumId`. This array contains 1
     * element per Enum value, which contains an array of all Tile IDs that are tagged with it.
     */
    @JsonProperty("enumTags")
    public EnumTagValue[] getEnumTags() { return enumTags; }
    @JsonProperty("enumTags")
    public void setEnumTags(EnumTagValue[] value) { this.enumTags = value; }

    /**
     * User defined unique identifier
     */
    @JsonProperty("identifier")
    public String getIdentifier() { return identifier; }
    @JsonProperty("identifier")
    public void setIdentifier(String value) { this.identifier = value; }

    /**
     * Distance in pixels from image borders
     */
    @JsonProperty("padding")
    public long getPadding() { return padding; }
    @JsonProperty("padding")
    public void setPadding(long value) { this.padding = value; }

    /**
     * Image height in pixels
     */
    @JsonProperty("pxHei")
    public long getPxHei() { return pxHei; }
    @JsonProperty("pxHei")
    public void setPxHei(long value) { this.pxHei = value; }

    /**
     * Image width in pixels
     */
    @JsonProperty("pxWid")
    public long getPxWid() { return pxWid; }
    @JsonProperty("pxWid")
    public void setPxWid(long value) { this.pxWid = value; }

    /**
     * Path to the source file, relative to the current project JSON file<br/>  It can be null
     * if no image was provided, or when using an embed atlas.
     */
    @JsonProperty("relPath")
    public String getRelPath() { return relPath; }
    @JsonProperty("relPath")
    public void setRelPath(String value) { this.relPath = value; }

    /**
     * Array of group of tiles selections, only meant to be used in the editor
     */
    @JsonProperty("savedSelections")
    public Map<String, Object>[] getSavedSelections() { return savedSelections; }
    @JsonProperty("savedSelections")
    public void setSavedSelections(Map<String, Object>[] value) { this.savedSelections = value; }

    /**
     * Space in pixels between all tiles
     */
    @JsonProperty("spacing")
    public long getSpacing() { return spacing; }
    @JsonProperty("spacing")
    public void setSpacing(long value) { this.spacing = value; }

    /**
     * An array of user-defined tags to organize the Tilesets
     */
    @JsonProperty("tags")
    public String[] getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(String[] value) { this.tags = value; }

    /**
     * Optional Enum definition UID used for this tileset meta-data
     */
    @JsonProperty("tagsSourceEnumUid")
    public Long getTagsSourceEnumUid() { return tagsSourceEnumUid; }
    @JsonProperty("tagsSourceEnumUid")
    public void setTagsSourceEnumUid(Long value) { this.tagsSourceEnumUid = value; }

    @JsonProperty("tileGridSize")
    public long getTileGridSize() { return tileGridSize; }
    @JsonProperty("tileGridSize")
    public void setTileGridSize(long value) { this.tileGridSize = value; }

    /**
     * Unique Intidentifier
     */
    @JsonProperty("uid")
    public long getUid() { return uid; }
    @JsonProperty("uid")
    public void setUid(long value) { this.uid = value; }
}
