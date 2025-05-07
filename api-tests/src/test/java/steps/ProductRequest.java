package steps;

import data.Product;
import org.junit.jupiter.api.DisplayName;

public class ProductRequest extends BaseRequests {

    @DisplayName("Получить все продукты")
    public Product[] getProductRequest() {
        return getRequest("/products", 200, Product[].class);
    }

    @DisplayName("Отправить продукт")
    public Product postProductRequest(String jsonString) {
        return postRequest("/products", jsonString, 201, Product.class);
    }

}
