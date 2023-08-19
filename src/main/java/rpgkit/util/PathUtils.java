package rpgkit.util;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Utility methods for manipulating paths.
 */

public class PathUtils {
    /**
     * Normalizes the inputPath parameter by creating a Path object using {@link Paths#get} method and normalizing it using
     * {@link Path#normalize} method. The normalized path is then converted to a string using {@link Path#toString} method.
     *
     * @param inputPath the input path to be normalized
     * @return the normalized path as a string
     */
    public String normalizePath(String inputPath) {
        Path path = Paths.get(inputPath);
        Path normalizedPath = path.normalize();
        return normalizedPath.toString();
    }
}
