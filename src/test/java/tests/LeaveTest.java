package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

public class LeaveTest extends BaseTest{
    @Test
    public void invalidImployNameSearch(){
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        // кликнуть на leave вкладку
        app.leavePage.leaveTab.click();
        // ввести имя сотрудника
        app.leavePage.employeeNameField.setValue("123456789qwertyuiop");
        //кликнуть на кнопку поиска
        app.leavePage.searchButton.click();
        // проверить ошибку
        app.leavePage.errorMessage.shouldBe(Condition.visible);
    }

}
