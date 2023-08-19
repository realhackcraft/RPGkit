package rpgkit.ldtk.tile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Animation {
    private long delay;
    private long next;

    @JsonProperty("delay")
    public long getDelay() {
        return delay;
    }

    @JsonProperty("delay")
    public void setDelay(long value) {
        this.delay = value;
    }

    @JsonProperty("next")
    public long getNext() {
        return next;
    }

    @JsonProperty("next")
    public void setNext(long value) {
        this.next = value;
    }
}
