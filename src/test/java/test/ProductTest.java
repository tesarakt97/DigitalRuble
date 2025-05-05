package test;

import data.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.ProductRequest;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static utils.JsonUtils.*;

public class ProductTest extends BaseTest {

    final ProductRequest productRequest = new ProductRequest();

    @Test
    @DisplayName("Тестовый тест API")
    public void getTest() {
        Product[] products = productRequest.getProductRequest();
        System.out.println(products.length);
    }

    @Test
    @DisplayName("Тестовый тест API")
    public void postTest() {
        HashMap<String, Object> updates = new HashMap<>();
        updates.put("id", 1);
        updates.put("category", "Max");

        String updatedJson = updateJsonFile("src/test/resources/json/Product.json", updates);

        System.out.println(updatedJson); // Вывод обновленного JSON

//        Product products = productRequest.postProductRequest(jsonToString("src/test/resources/json/Product.json"));
//        System.out.println(products);
    }
}
