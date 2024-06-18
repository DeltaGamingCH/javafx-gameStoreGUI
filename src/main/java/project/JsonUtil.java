package project;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class JsonUtil {

    public static String readFileAsString(String resourcePath) throws IOException {
        InputStream inputStream = JsonUtil.class.getResourceAsStream(resourcePath);
        if (inputStream == null) {
            throw new IOException("Resource not found: " + resourcePath);
        }

        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            return scanner.useDelimiter("\\A").next();
        }
    }
}
