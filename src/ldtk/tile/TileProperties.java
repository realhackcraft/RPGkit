package ldtk.tile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TileProperties {
    private Interaction interaction;
    private boolean solid;

    @JsonProperty("interaction")
    public Interaction getInteraction() {
        return interaction;
    }

    @JsonProperty("interaction")
    public void setInteraction(Interaction value) {
        this.interaction = value;
    }

    @JsonProperty("solid")
    public boolean getSolid() {
        return solid;
    }

    @JsonProperty("solid")
    public void setSolid(boolean value) {
        this.solid = value;
    }
}
