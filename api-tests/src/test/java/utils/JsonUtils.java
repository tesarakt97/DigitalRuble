package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String jsonToString(String pathToJsonFile) {
        try {
            return objectMapper.writeValueAsString(new File(pathToJsonFile));
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Или можно выбросить исключение
        }
    }

    public static <T> T jsonStringToObject(String pathToJsonFile, Class<T> clazz) {
        try {
            return objectMapper.readValue(new File(pathToJsonFile), clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Или можно выбросить исключение
        }
    }

    public static String updateJsonFile(String jsonFilePath, HashMap<String, Object> updates) {
        try {
            // Чтение JSON файла
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

            // Обновление значений по указанным путям
            for (Map.Entry<String, Object> entry : updates.entrySet()) {
                String path = entry.getKey();
                Object value = entry.getValue();
                updateValue(rootNode, path, value);
            }

            // Возврат обновленного JSON как строки
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);

        } catch (IOException e) {
            e.printStackTrace();
            return null; // Или можно выбросить исключение
        }
    }

    private static void updateValue(JsonNode node, String path, Object value) {
        String[] keys = path.split("\\.");
        JsonNode currentNode = node;

        for (int i = 0; i < keys.length - 1; i++) {
            currentNode = currentNode.path(keys[i]);
            if (currentNode.isMissingNode()) {
                return; // Если путь не существует, выходим
            }
        }

        if (currentNode instanceof ObjectNode) {
            ((ObjectNode) currentNode).put(keys[keys.length - 1], value.toString());
        }
    }
}
