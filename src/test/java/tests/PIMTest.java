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
        app.pimTest.PIMTab.click();
        // ввести имя сотрудника
        app.pimTest.employeeNameField.setValue("Andy");
        // кликнуть на кнопку поиска
        app.pimTest.searchButton.click();
        // проверить результат поиска по имени
        app.pimTest.result.shouldBe(Condition.visible); // ждет пока элемент станет видимым
        app.pimTest.result.shouldHave(Condition.exactText("(1) Record Found"));
        // кликнуть на кнопку сброса
        app.pimTest.resetButton.click();
        // проверить что поля очистились
        app.pimTest.employeeNameField.shouldBe(Condition.visible, Duration.ofSeconds(10));
        app.pimTest.employeeNameField.shouldBe(Condition.empty);
    }
    @Test
    public void validImployeeIdSearch() {
       // Configuration.pageLoadTimeout = 20000; // 20 секунд
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        // кликнуть на PIM вкладку
        app.pimTest.PIMTab.click();
        // ввести id сотрудника
        app.pimTest.employeeIdField.setValue("0371");
        // кликнуть на кнопку поиска
        app.pimTest.searchButton.click();
        // проверить результат поиска по имени
        app.pimTest.result.shouldBe(Condition.visible); // ждет пока элемент станет видимым
        app.pimTest.result.shouldHave(Condition.exactText("(1) Record Found"));
        // кликнуть на кнопку сброса
        app.pimTest.resetButton.click();
        // проверить что поля очистились
        app.pimTest.employeeNameField.shouldBe(Condition.visible, Duration.ofSeconds(10));
        app.pimTest.employeeNameField.shouldBe(Condition.empty);
    }
    @Test
    public void createdNewEmployee() {
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        // кликнуть на PIM вкладку
        app.pimTest.PIMTab.click();
        // кликнуть на Add Employee
        app.pimTest.buttonAddEmployee.click();
        // ввести в поле имя
        app.pimTest.firstNameField.setValue("Екатерина");
        // ввести в поле фамилию
        app.pimTest.lastNameField.setValue("Тест");
        // нажать на кнопку save
        app.pimTest.searchButton.click();
        // проверка на отображение персональной информации
        Configuration.timeout = 10000;
        app.pimTest.resultAddNewEmployee.shouldBe(Condition.visible); // ждет пока элемент станет видимым
        app.pimTest.resultAddNewEmployee.shouldHave(Condition.exactText("Personal Details"));
        // проверка на отображение имени и фамилии
        app.pimTest.lastNameAndFirstName.shouldBe(Condition.visible);
        app.pimTest.lastNameAndFirstName.shouldHave(Condition.exactText("Екатерина Тест"));
    }
    @Test
    public void checkingThatTheUserHasBeenAdded() {
        Configuration.pageLoadTimeout = 20000; // 20 секунд
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        // кликнуть на PIM вкладку
        app.pimTest.PIMTab.click();
        // ввести имя сотрудника
        app.pimTest.employeeNameField.setValue("Екатерина");
        // кликнуть на кнопку поиска
        app.pimTest.searchButton.click();
        // проверить что FirstName есть в списке
        app.pimTest.FirstNameSearchResult.shouldBe(Condition.visible);
        app.pimTest.FirstNameSearchResult.shouldHave(Condition.exactText("Екатерина "));
        // проверить что Last Name есть в списке
        app.pimTest.LastNameSearchResult.shouldBe(Condition.visible);
        app.pimTest.LastNameSearchResult.shouldHave(Condition.exactText("Тест"));
    }
    @Test
    public void validNameAndInvalidIdSearch() {
        Configuration.pageLoadTimeout = 20000; // 20 секунд
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        // кликнуть на PIM вкладку
        Configuration.timeout = 10000;
        app.pimTest.PIMTab.click();
        // ввести имя сотрудника
        app.pimTest.employeeNameField.setValue("Екатерина");
        // ввести id не присвоенный к созданному пользователю
        app.pimTest.employeeIdField.setValue("0405");
        // кликнуть на кнопку поиска
        app.pimTest.searchButton.click();
        // проверить текст результата
        Configuration.timeout = 10000;
        app.pimTest.result.shouldBe(Condition.visible); // ждет пока элемент станет видимым
        app.pimTest.result.shouldHave(Condition.exactText("No Records Found"));
    }
}
