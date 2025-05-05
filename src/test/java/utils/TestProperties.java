package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = TestProperties.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}