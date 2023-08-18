package rpgkit.ldtk.tile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TileProperties {
    private String interaction;
    private Boolean solid;

    @JsonProperty("interaction")
    public String getInteraction() {
        return interaction;
    }

    @JsonProperty("interaction")
    public void setInteraction(String value) {
        this.interaction = value;
    }

    @JsonProperty("solid")
    public Boolean getSolid() {
        return solid;
    }

    @JsonProperty("solid")
    public void setSolid(Boolean value) {
        this.solid = value;
    }
}
