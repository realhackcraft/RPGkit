package ldtk.tile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TileProperties {
    private Interaction interaction;
    private Boolean solid;

    @JsonProperty("interaction")
    public Interaction getInteraction() {
        return interaction;
    }

    @JsonProperty("interaction")
    public void setInteraction(Interaction value) {
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
