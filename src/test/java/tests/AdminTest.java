package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.page;

public class AdminTest extends BaseTest {


    @Test
    @Flaky
    @Description("Поиск админа")
    @Issue("Jira 12345")
    @Tag("regression")
    //@Severity()
    public void searchAdmin() {
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("admin");
        app.adminPage.searchByUsername("Admin");
    }

    @Test
    @Tag("smoke")
    public void searchAndDropDownCheck() {
//       app.adminPage.usernameField.getWrappedElement().findElement(byText("Москва")).click();
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.adminPage.adminTab.shouldBe(Condition.visible, Duration.ofSeconds(10));
        app.sideMenu.openTab("admin");
        app.adminPage.usernameField.setValue("admin");
        app.adminPage.userRoleButton.click();
        // в раскрывающемся списке ищем элемент по тексту
        app.adminPage.userRoleDropDown.getWrappedElement().findElement(byText("Admin")).click();
        app.adminPage.userRoleButton.shouldHave(Condition.exactText("Admin"));
        app.adminPage.searchButton.click();

    }
}
