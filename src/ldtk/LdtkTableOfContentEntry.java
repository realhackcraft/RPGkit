package ldtk;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LdtkTableOfContentEntry {
    private String identifier;
    private ReferenceToAnEntityInstance[] instances;

    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    @JsonProperty("identifier")
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    @JsonProperty("instances")
    public ReferenceToAnEntityInstance[] getInstances() {
        return instances;
    }

    @JsonProperty("instances")
    public void setInstances(ReferenceToAnEntityInstance[] value) {
        this.instances = value;
    }
}
