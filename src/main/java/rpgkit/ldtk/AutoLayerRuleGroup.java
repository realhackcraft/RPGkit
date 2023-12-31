package rpgkit.ldtk;

import com.fasterxml.jackson.annotation.*;

public class AutoLayerRuleGroup {
    private boolean active;
    private Boolean collapsed;
    private String color;
    private TilesetRectangle icon;
    private boolean isOptional;
    private String name;
    private AutoLayerRuleDefinition[] rules;
    private long uid;
    private boolean usesWizard;

    @JsonProperty("active")
    public boolean getActive() { return active; }
    @JsonProperty("active")
    public void setActive(boolean value) { this.active = value; }

    /**
     * *This field was removed in 1.0.0 and should no longer be used.*
     */
    @JsonProperty("collapsed")
    public Boolean getCollapsed() { return collapsed; }
    @JsonProperty("collapsed")
    public void setCollapsed(Boolean value) { this.collapsed = value; }

    @JsonProperty("color")
    public String getColor() { return color; }
    @JsonProperty("color")
    public void setColor(String value) { this.color = value; }

    @JsonProperty("icon")
    public TilesetRectangle getIcon() { return icon; }
    @JsonProperty("icon")
    public void setIcon(TilesetRectangle value) { this.icon = value; }

    @JsonProperty("isOptional")
    public boolean getIsOptional() { return isOptional; }
    @JsonProperty("isOptional")
    public void setIsOptional(boolean value) { this.isOptional = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("rules")
    public AutoLayerRuleDefinition[] getRules() { return rules; }
    @JsonProperty("rules")
    public void setRules(AutoLayerRuleDefinition[] value) { this.rules = value; }

    @JsonProperty("uid")
    public long getUid() { return uid; }
    @JsonProperty("uid")
    public void setUid(long value) { this.uid = value; }

    @JsonProperty("usesWizard")
    public boolean getUsesWizard() { return usesWizard; }
    @JsonProperty("usesWizard")
    public void setUsesWizard(boolean value) { this.usesWizard = value; }
}
