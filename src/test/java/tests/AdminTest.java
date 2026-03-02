package tests;

import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.page;

public class AdminTest extends BaseTest {

    @Test
    public void searchAdmin() {
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("admin");
//        page(AdminPage.class).openAdminTab();
//        app.adminPage.adminTab.click();
        app.adminPage.searchByUsername("Admin");
    }
    @Test
    public void testDropDown() {
       app.adminPage.usernameField.click();
       app.adminPage.usernameField.getWrappedElement().findElement(byText("Москва")).click();
    }
}
