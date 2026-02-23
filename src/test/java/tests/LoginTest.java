package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage();

    @Test
    public void loginWithValidCreds(){
        // test
       loginPage.usernameField.setValue("admin");
       loginPage.passwordField.setValue("admin123");
       loginPage.loginButton.click();
    }
}
