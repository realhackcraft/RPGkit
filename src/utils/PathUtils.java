package utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {
    public String normalizePath(String inputPath) {
        Path path = Paths.get(inputPath);
        Path normalizedPath = path.normalize();
        return normalizedPath.toString();
    }
}
