package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public SelenideElement usernameField = $(By.name("username"));
    public SelenideElement passwordField = $(By.name("password"));
    public SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));
    public SelenideElement errorMessage = $(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']"));

    @Step("Логин")
    public void login(String login, String password) {
        usernameField.shouldBe(Condition.visible, Duration.ofSeconds(10));
        usernameField.setValue(login);
        // usernameField должен иметь точное значение логина
        usernameField.shouldHave(Condition.exactValue(login));
        passwordField.setValue(password);
        passwordField.shouldHave(Condition.exactValue(password));
        loginButton.click();
//        return new AdminPage();

    }

}
