package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnumDefinition {
    private String externalFileChecksum;
    private String externalRelPath;
    private Long iconTilesetUid;
    private String identifier;
    private String[] tags;
    private long uid;
    private EnumValueDefinition[] values;

    @JsonProperty("externalFileChecksum")
    public String getExternalFileChecksum() {
        return externalFileChecksum;
    }

    @JsonProperty("externalFileChecksum")
    public void setExternalFileChecksum(String value) {
        this.externalFileChecksum = value;
    }

    /**
     * Relative path to the external file providing this Enum
     */
    @JsonProperty("externalRelPath")
    public String getExternalRelPath() {
        return externalRelPath;
    }

    @JsonProperty("externalRelPath")
    public void setExternalRelPath(String value) {
        this.externalRelPath = value;
    }

    /**
     * Tileset UID if provided
     */
    @JsonProperty("iconTilesetUid")
    public Long getIconTilesetUid() {
        return iconTilesetUid;
    }

    @JsonProperty("iconTilesetUid")
    public void setIconTilesetUid(Long value) {
        this.iconTilesetUid = value;
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
     * An array of user-defined tags to organize the Enums
     */
    @JsonProperty("tags")
    public String[] getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(String[] value) {
        this.tags = value;
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
     * All possible enum values, with their optional Tile infos.
     */
    @JsonProperty("values")
    public EnumValueDefinition[] getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(EnumValueDefinition[] value) {
        this.values = value;
    }
}
