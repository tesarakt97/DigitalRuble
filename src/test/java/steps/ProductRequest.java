package steps;

import org.junit.jupiter.api.DisplayName;

import static io.restassured.RestAssured.given;

public class ProductRequest extends BaseRequests {

    @DisplayName("Получить все продукты")
    public ProductRequest[] getProductRequest() {
        return getRequest("/products",200, ProductRequest[].class);
    }

}
