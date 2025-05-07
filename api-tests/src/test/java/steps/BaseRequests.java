package steps;

import data.Product;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class BaseRequests {

    // 1. GET запрос
    public <T> T getRequest(String url, int statusCode, Class<T> responseType) {
        return given()
                .when()
                .get(url)
                .then()
                .statusCode(statusCode)
                .extract()
                .as(responseType);
    }

    // 2. POST запрос с JSON телом
    public <T> T postRequest(String url, String jsonString, int statusCode, Class<T> responseType) {
        return given()
                .contentType(ContentType.JSON)
                .body(jsonString)
                .when()
                .post(url)
                .then()
                .statusCode(statusCode)
                .extract()
                .as(responseType);
    }

    // 3. PUT запрос
    public <T> T  putRequest(String url, String jsonString, int statusCode, Class<T> responseType) {
        return given()
                .contentType(ContentType.JSON)
                .body(jsonString)
                .when()
                .put(url)
                .then()
                .statusCode(statusCode)
                .extract()
                .as(responseType);
    }

    // 4. DELETE запрос
    public <T> T  deleteRequest(String url, int statusCode, Class<T> responseType) {
        return given()
                .when()
                .delete(url)
                .then()
                .statusCode(statusCode)
                .extract()
                .as(responseType);
    }
}
