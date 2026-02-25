package tests;

import com.codeborne.selenide.Condition;
import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    public void loginWithValidCreds() {
        loginPage.usernameField.setValue("Admin");
        //проверка на невалидный логин
        loginPage.usernameField.shouldHave(Condition.exactValue("Admin"));
        loginPage.passwordField.setValue("admin123");
        loginPage.passwordField.shouldHave(Condition.exactValue("admin123"));
        loginPage.loginButton.click();
    }

    @Test
    public void loginWithInvalidCreds() {
        loginPage.usernameField.setValue("Admin");
        loginPage.usernameField.shouldHave(Condition.exactValue("Admin"));
        loginPage.passwordField.setValue("wrong");
        loginPage.passwordField.shouldHave(Condition.exactValue("wrong"));
        loginPage.loginButton.click();
        //errorMessage
        loginPage.errorMessage.shouldBe(Condition.visible);
        loginPage.errorMessage.shouldHave(Condition.exactText("Invalid credentials"));
        //проверка что поля очистились
        loginPage.usernameField.shouldBe(Condition.empty);
        loginPage.passwordField.shouldBe(Condition.empty);
    }

    @Test
    public void loginWithInvalidUsername() {
        loginPage.usernameField.setValue("wrong");
        loginPage.passwordField.setValue("admin123");
        loginPage.loginButton.click();
    }

    @Test
    public void loginWithEmptyCreds() {
        loginPage.usernameField.setValue("");
        loginPage.passwordField.setValue("");
        loginPage.loginButton.click();
    }

    @Test
    public void loginWithLongUserName() {
        loginPage.usernameField.setValue("admin123qwertyuio!@#$%^&*()");
        loginPage.passwordField.setValue("");
        loginPage.loginButton.click();
    }
}
