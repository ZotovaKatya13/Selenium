package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class MyInfoTest extends BaseTest {

    @Test
    @Description("проверка на то, что поле заполнилось датой после нажатия Today в календаре")
    public void installDateInCalendarDropDown() {
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("MyDetails");
        app.myinfoPage.licenseExpiryDateField.click();
        app.myinfoPage.calendarDownDrop.getWrappedElement().findElement(byText("Today")).click();
        // проверить что поле заполнилось сегодняшней датой
        SelenideElement calendar = $(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]"));
        String dateString = executeJavaScript("return arguments[0].value;", calendar);
        // преобразуем в LocalDate для сравнения
        LocalDate selectedDate = LocalDate.parse(dateString); // если dateString в формате YYYY-MM-DD
        // проверяем
        LocalDate expectedDate = LocalDate.of(2026, 3, 3);
        if (selectedDate.equals(expectedDate)) {
            System.out.println("Дата выбрана верно");
        } else {
            System.out.println("Дата НЕ верна");
        }
    }

    @Test
    @Description("проверка на то, что календарь закрылся после нажатия Close в календаре")
    public void checkCloseCalendarDropDown(){
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("MyDetails");
        app.myinfoPage.licenseExpiryDateField.click();
        app.myinfoPage.calendarDownDrop.getWrappedElement().findElement(byText("Today")).click();
        app.myinfoPage.licenseExpiryDateField.click();
        app.myinfoPage.calendarDownDrop.getWrappedElement().findElement(byText("Close")).click();
        app.myinfoPage.calendarDownDrop.should(disappear);
    }

    @Test
    @Description("проверка на то, что поле с датой очистилось после нажатия Clear в календаре")
    public void checkFieldClear(){
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("MyDetails");
        app.myinfoPage.licenseExpiryDateField.click();
        app.myinfoPage.calendarDownDrop.getWrappedElement().findElement(byText("Today")).click();
        app.myinfoPage.licenseExpiryDateField.click();
        app.myinfoPage.calendarDownDrop.getWrappedElement().findElement(byText("Clear")).click();
        SelenideElement calendar = $(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]"));
        // получаем значение свойства value через JS
        String dateString = executeJavaScript("return arguments[0].value;", calendar);
        // проверяем, что поле пустое
        if(dateString == null || dateString.isEmpty()) {
            System.out.println("Поле календаря очищено");
        } else {
            System.out.println("Поле календаря НЕ пустое, значение: " + dateString);
        }
    }

    @Test
    @Description("проверка селектора Nationality")
    public void checkDropDownNationality(){
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("MyDetails");
        app.myinfoPage.nationalityField.click();
        app.myinfoPage.downDrop.getWrappedElement().findElement(byText("Russian")).click();
        app.myinfoPage.nationalityFieldActive.shouldHave(Condition.exactText("Russian"));
    }

    @Test
    @Description("проверка селектора maritalStatus")
    public void checkDropDownCountry(){
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("MyDetails");
        app.myinfoPage.maritalStatusField.click();
        app.myinfoPage.downDrop.getWrappedElement().findElement(byText("Married")).click();
        app.myinfoPage.nationalityFieldActive.shouldHave(Condition.exactText("Married"));
    }

    @Test
    @Description("проверка фильтрации")
    public void searchByFilter() {
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.adminPage.adminTab.shouldBe(Condition.visible, Duration.ofSeconds(10));
        app.sideMenu.openTab("admin");
        app.adminPage.usernameField.setValue("admin");
        app.myinfoPage.selectStatus.click();
        app.myinfoPage.downDrop.getWrappedElement().findElement(byText("Enabled")).click();
        app.adminPage.userRoleButton.click();
        app.myinfoPage.downDrop.getWrappedElement().findElement(byText("Admin")).click();
        app.adminPage.searchButton.click();
        // проверить результат поиска по имени
        app.pimPage.result.shouldBe(Condition.visible);
        app.pimPage.result.shouldHave(Condition.exactText("(1) Record Found"));
        app.myinfoPage.checkStatus.shouldHave(Condition.exactText("Enabled"));
    }

    @Test
    @Description("проверка, что файл скачался")
    public void downloadFile(){
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("MyDetails");
        File file = $("button:has(i.bi-download)").download();
        Assert.assertTrue(file.exists());
        Assert.assertTrue(file.length() > 0);
    }
}
