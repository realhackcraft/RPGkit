package ldtk.tile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TileProperties {
    private boolean solid;

    @JsonProperty("solid")
    public boolean getSolid() {
        return solid;
    }

    @JsonProperty("solid")
    public void setSolid(boolean value) {
        this.solid = value;
    }
}
