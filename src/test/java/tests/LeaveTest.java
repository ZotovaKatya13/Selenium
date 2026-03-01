package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.time.Duration;

public class LeaveTest extends BaseTest{
    @Test
    public void invalidImployNameSearch(){
        String userName = "123456789qwertyuiop";
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        // кликнуть на leave вкладку
        app.sideMenu.openTab("leave");
        // ввести имя сотрудника
        app.leavePage.employeeNameField.setValue(userName);

//        app.leavePage.employeeNameField.clear(); // 1 способ очистить поле
//        app.leavePage.employeeNameField.sendKeys(Keys.CONTROL + "A"); // 2 способ очистить поле
//        app.leavePage.employeeNameField.sendKeys(Keys.BACK_SPACE);

//        app.leavePage.employeeNameField.shouldBe(Condition.exactValue("123456789qwertyuiop"));
        app.leavePage.employeeNameField.shouldHave(Condition.value(userName));
        //кликнуть на кнопку поиска
        app.leavePage.searchButton.click();
        // проверить ошибку
        app.leavePage.errorMessage.shouldBe(Condition.exist); // объект есть в дом модели но не видим
        app.leavePage.errorMessage.shouldBe(Condition.visible, Duration.ofSeconds(10)); // ожидание
    }

}
