package rpgkit.ldtk.tile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TileProperties {
    private Animation animation;
    private String interaction;
    private Boolean solid;

    @JsonProperty("animation")
    public Animation getAnimation() {
        return animation;
    }

    @JsonProperty("animation")
    public void setAnimation(Animation value) {
        this.animation = value;
    }

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
