package rpgkit.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * Utility methods for working with Strings.
 */

public class StringUtils {
    /**
     * Loads a file as a string given a path and a charset.
     *
     * @param path    the path of the file to be loaded
     * @param charset the charset to be used to encode the string
     * @return the contents of the file as a string
     * @throws IOException if there is an error reading the file
     */
    public String loadFileAsString(String path, Charset charset) throws IOException {
        URL url = Objects.requireNonNull(getClass().getResource(path));
        InputStream is = url.openStream();
        return new String(is.readAllBytes(), charset);
    }

    /**
     * Loads a file as a string given a path.
     *
     * @param path the path of the file to be loaded
     * @return the contents of the file as a string
     * @throws IOException if there is an error reading the file
     */
    public String loadFileAsString(String path) throws IOException {
        URL url = Objects.requireNonNull(getClass().getResource(path));
        InputStream is = url.openStream();
        return new String(is.readAllBytes());
    }
}
