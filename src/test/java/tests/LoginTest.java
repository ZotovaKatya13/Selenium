package tests;

import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage();

    @Test
    public void loginWithValidCreds(){
       loginPage.usernameField.setValue("Admin");
       loginPage.passwordField.setValue("admin123");
       loginPage.loginButton.click();
    }
    @Test
    public void loginWithInvalidCreds(){
        loginPage.usernameField.setValue("Admin");
        loginPage.passwordField.setValue("wrong");
        loginPage.loginButton.click();
    }
    @Test
    public void loginWithInvalidUsername(){
        loginPage.usernameField.setValue("wrong");
        loginPage.passwordField.setValue("admin123");
        loginPage.loginButton.click();
    }
    @Test
    public void loginWithEmptyCreds(){
        loginPage.usernameField.setValue("");
        loginPage.passwordField.setValue("");
        loginPage.loginButton.click();
    }
    @Test
    public void loginWithLongUserName(){
        loginPage.usernameField.setValue("admin123qwertyuio!@#$%^&*()");
        loginPage.passwordField.setValue("");
        loginPage.loginButton.click();
    }
}
