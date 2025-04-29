package test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestProperties;

import static io.restassured.RestAssured.given;

@DisplayName("Тест")
@Epic("Тестовый эпик")
@Feature("Тестовая фича")
public class BaseTest {

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = TestProperties.get("base.url");
//        RestAssured.basePath = "/v1";
        RestAssured.filters(
                new RequestLoggingFilter(LogDetail.ALL),
                new ResponseLoggingFilter(LogDetail.ALL)
        );
    }
}
