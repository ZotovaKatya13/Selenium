package tests;

import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage();

    @Test
    public void loginWithValidCreds(){
       loginPage.usernameField.setValue("admin");
       loginPage.passwordField.setValue("admin123");
       loginPage.loginButton.click();
    }
}
