package utils;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * Utility methods for manipulating images.
 */

public class ImageUtils {
    /**
     * Flips the given BufferedImage image horizontally. The resulting image is a mirror image, where the left side is on the right and vice versa.
     *
     * @param image the BufferedImage to be flipped horizontally
     * @return the resulting BufferedImage containing the horizontally flipped image
     */
    public BufferedImage flipHorizontal(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(image, null);
    }

    /**
     * Flips the given BufferedImage image vertically. The resulting image is a mirror image, where the top is on the bottom and vice versa.
     *
     * @param image the BufferedImage to be flipped vertically
     * @return the resulting BufferedImage containing the vertically flipped image
     */
    public BufferedImage flipVertical(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -image.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(image, null);
    }

    /**
     * Flips the given BufferedImage image horizontally and vertically. The resulting image is a mirrored image where the left is on the right and vice versa and the top is on the bottom and vice versa.
     *
     * @param image the BufferedImage to be flipped horizontally and vertically
     * @return the resulting BufferedImage containing the horizontally and vertically flipped image
     */
    public BufferedImage flipAll(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, -1);
        tx.translate(-image.getWidth(null), -image.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(image, null);
    }
}
