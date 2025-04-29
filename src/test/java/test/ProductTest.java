package test;

import org.junit.jupiter.api.Test;
import steps.ProductRequest;

import static io.restassured.RestAssured.given;

public class ProductTest extends BaseTest {

    final ProductRequest productRequest = new ProductRequest();

    @Test
    public void test() {
        productRequest.getProductRequest();
    }

}
