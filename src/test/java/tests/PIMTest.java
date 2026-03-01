package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import java.time.Duration;

public class PIMTest extends BaseTest{

    @Test
    public void validImployeeNameSearch() {
        Configuration.pageLoadTimeout = 20000; // 20 секунд
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        // кликнуть на PIM вкладку
        app.pimPage.PIMTab.click();
        // ввести имя сотрудника
        app.pimPage.employeeNameField.setValue("Andy");
        // кликнуть на кнопку поиска
        app.pimPage.searchButton.click();
        // проверить результат поиска по имени
        app.pimPage.result.shouldBe(Condition.visible); // ждет пока элемент станет видимым
        app.pimPage.result.shouldHave(Condition.exactText("(1) Record Found"));
        // кликнуть на кнопку сброса
        app.pimPage.resetButton.click();
        // проверить что поля очистились
        app.pimPage.employeeNameField.shouldBe(Condition.visible, Duration.ofSeconds(10));
        app.pimPage.employeeNameField.shouldBe(Condition.empty);
    }

    @Test
    public void validEmployeeNameSearch2() {
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("Pim");
        app.pimPage.searchByUser("Andy");
        app.pimPage.checkExpectedResultRows(1);
        app.pimPage.resetButtonClick();
        app.pimPage.checkThatEmployeeNameIsEmpty();
    }

    @Test
    public void validImployeeIdSearch() {
       // Configuration.pageLoadTimeout = 20000; // 20 секунд
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        // кликнуть на PIM вкладку
        app.pimPage.PIMTab.click();
        // ввести id сотрудника
        app.pimPage.employeeIdField.setValue("0371");
        // кликнуть на кнопку поиска
        app.pimPage.searchButton.click();
        // проверить результат поиска по имени
        app.pimPage.result.shouldBe(Condition.visible); // ждет пока элемент станет видимым
        app.pimPage.result.shouldHave(Condition.exactText("(1) Record Found"));
        // кликнуть на кнопку сброса
        app.pimPage.resetButton.click();
        // проверить что поля очистились
        app.pimPage.employeeNameField.shouldBe(Condition.visible, Duration.ofSeconds(10));
        app.pimPage.employeeNameField.shouldBe(Condition.empty);
    }
    @Test
    public void createdNewEmployee() {
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        // кликнуть на PIM вкладку
        app.pimPage.PIMTab.click();
        // кликнуть на Add Employee
        app.pimPage.buttonAddEmployee.click();
        // ввести в поле имя
        app.pimPage.firstNameField.setValue("Екатерина");
        // ввести в поле фамилию
        app.pimPage.lastNameField.setValue("Тест");
        // нажать на кнопку save
        app.pimPage.searchButton.click();
        // проверка на отображение персональной информации
        Configuration.timeout = 10000;
        app.pimPage.resultAddNewEmployee.shouldBe(Condition.visible); // ждет пока элемент станет видимым
        app.pimPage.resultAddNewEmployee.shouldHave(Condition.exactText("Personal Details"));
        // проверка на отображение имени и фамилии
        app.pimPage.lastNameAndFirstName.shouldBe(Condition.visible);
        app.pimPage.lastNameAndFirstName.shouldHave(Condition.exactText("Екатерина Тест"));
    }
    @Test
    public void checkingThatTheUserHasBeenAdded() {
        Configuration.pageLoadTimeout = 20000; // 20 секунд
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        // кликнуть на PIM вкладку
        app.pimPage.PIMTab.click();
        // ввести имя сотрудника
        app.pimPage.employeeNameField.setValue("Екатерина");
        // кликнуть на кнопку поиска
        app.pimPage.searchButton.click();
        // проверить что FirstName есть в списке
        app.pimPage.FirstNameSearchResult.shouldBe(Condition.visible);
        app.pimPage.FirstNameSearchResult.shouldHave(Condition.exactText("Екатерина "));
        // проверить что Last Name есть в списке
        app.pimPage.LastNameSearchResult.shouldBe(Condition.visible);
        app.pimPage.LastNameSearchResult.shouldHave(Condition.exactText("Тест"));
    }
    @Test
    public void validNameAndInvalidIdSearch() {
        Configuration.pageLoadTimeout = 20000; // 20 секунд
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        // кликнуть на PIM вкладку
        Configuration.timeout = 10000;
        app.pimPage.PIMTab.click();
        // ввести имя сотрудника
        app.pimPage.employeeNameField.setValue("Екатерина");
        // ввести id не присвоенный к созданному пользователю
        app.pimPage.employeeIdField.setValue("0405");
        // кликнуть на кнопку поиска
        app.pimPage.searchButton.click();
        // проверить текст результата
        Configuration.timeout = 10000;
        app.pimPage.result.shouldBe(Condition.visible); // ждет пока элемент станет видимым
        app.pimPage.result.shouldHave(Condition.exactText("No Records Found"));
    }
}
