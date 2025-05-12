package pages;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    @Step("Открыть базовую страницу")
    public BasePage openBasePage() {
        open(Configuration.baseUrl);
        return this;
    }

    @Step("Открыть страницу Text-box")
    public TextBoxPage openTextBoxPage() {
        open("/text-box");
        return new TextBoxPage();
    }
}
