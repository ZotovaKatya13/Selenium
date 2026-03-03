package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.testng.Tag;
import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

   // LoginPage loginPage = new LoginPage();

    @Test
    @Tag("smoke")
    @Link("12345")
    @Epic("12345")
    public void loginWithValidCreds() {
       app.loginPage.usernameField.setValue("Admin");
        //проверка на невалидный логин
        app.loginPage.usernameField.shouldHave(Condition.exactValue("Admin"));
        app.loginPage.passwordField.setValue("admin123");
        app.loginPage.passwordField.shouldHave(Condition.exactValue("admin123"));
        app.loginPage.loginButton.click();
    }

    @Test
    @Tag("smoke")
    @Link("12345")
    @Epic("12345")
    @Flaky
    public void loginWithInvalidCreds() {
        app.loginPage.usernameField.setValue("Admin");
        app.loginPage.usernameField.shouldHave(Condition.exactValue("Admin"));
        app.loginPage.passwordField.setValue("wrong");
        app.loginPage.passwordField.shouldHave(Condition.exactValue("wrong"));
        app.loginPage.loginButton.click();
        //errorMessage
        app.loginPage.errorMessage.shouldBe(Condition.visible);
        app.loginPage.errorMessage.shouldHave(Condition.exactText("Invalid credentials"));
        //проверка что поля очистились
        app.loginPage.usernameField.shouldBe(Condition.empty);
        app.loginPage.passwordField.shouldBe(Condition.empty);
    }

    @Test
    public void loginWithInvalidUsername() {
        app.loginPage.usernameField.setValue("wrong");
        app.loginPage.passwordField.setValue("admin123");
        app.loginPage.loginButton.click();
    }

    @Test
    public void loginWithEmptyCreds() {
        app.loginPage.usernameField.setValue("");
        app.loginPage.passwordField.setValue("");
        app.loginPage.loginButton.click();
    }

    @Test
    public void loginWithLongUserName() {
        app.loginPage.usernameField.setValue("admin123qwertyuio!@#$%^&*()");
        app.loginPage.passwordField.setValue("");
        app.loginPage.loginButton.click();
    }
}
