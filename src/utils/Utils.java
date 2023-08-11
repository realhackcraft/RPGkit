package utils;

/**
 * Static utility objects for common problems.
 * These utility objects are accessible through static fields and can be used across different parts of the application.
 * The purpose of this class is to provide common functionalities which are frequently used and can be abstracted away from the rest of the application code.
 */

public class Utils {
    /**
     * A utility class that provides common image manipulation operations.
     */
    public static final ImageUtils images = new ImageUtils();

    /**
     * A utility class that provides common string manipulation operations.
     */
    public static final StringUtils strings = new StringUtils();

    /**
     * A utility class providing convenient access to file paths.
     */
    public static final PathUtils paths = new PathUtils();

    /**
     * A utility class for working with Java objects.
     */
    public static final ObjectUtils objects = new ObjectUtils();
    public static final GameUtils game = new GameUtils();
}
