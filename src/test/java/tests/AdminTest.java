package tests;

import com.codeborne.selenide.Condition;
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
        app.adminPage.searchByUsername("Admin");
    }

    @Test
    public void searchAndDropDownCheck() {
//       app.adminPage.usernameField.getWrappedElement().findElement(byText("Москва")).click();
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("admin");
        app.adminPage.usernameField.setValue("admin");
        app.adminPage.userRoleButton.click();
        // в раскрывающемся списке ищем элемент по тексту
        app.adminPage.userRoleDropDown.getWrappedElement().findElement(byText("Admin")).click();
        app.adminPage.userRoleButton.shouldHave(Condition.exactText("Admin"));
        app.adminPage.searchButton.click();

    }
}
