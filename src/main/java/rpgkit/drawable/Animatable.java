package rpgkit.drawable;

import java.awt.image.BufferedImage;

public interface Animatable extends Drawable {
    BufferedImage getNextFrame();
}
