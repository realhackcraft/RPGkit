package utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Objects;

public class StringUtils {
    //    TODO
    public String loadFileAsString(String path, Charset charset) throws IOException {
        URL url = Objects.requireNonNull(getClass().getResource(path));
        InputStream is = url.openStream();
        return new String(is.readAllBytes(), charset);
    }

    public String loadFileAsString(String path) throws IOException {
        URL url = Objects.requireNonNull(getClass().getResource(path));
        InputStream is = url.openStream();
        return new String(is.readAllBytes());
    }
}
