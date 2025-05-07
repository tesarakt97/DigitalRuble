package test;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestProperties;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тест front")
@Epic("Тестовый эпик")
@Feature("Тестовая фича")
public class BaseTest {

    @BeforeAll
    public static void beforeAll() {
        Configuration.baseUrl = TestProperties.get("base.url");
    }

    @Test
    public void test() {
        open("https://www.google.kz");
    }
}
