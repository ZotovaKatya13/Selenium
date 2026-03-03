package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class MyInfoTest extends BaseTest {

    @Test
    public void installDateInCalendarDropDown() {
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("MyDetails");
        // кликнуть по элементу календаря
        app.myinfoPage.licenseExpiryDateField.click();
        // нажать сегодня
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
    public void checkCloseCalendarDropDown(){
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("MyDetails");
        // кликнуть по элементу календаря
        app.myinfoPage.licenseExpiryDateField.click();
        // нажать сегодня
        app.myinfoPage.calendarDownDrop.getWrappedElement().findElement(byText("Today")).click();
        app.myinfoPage.licenseExpiryDateField.click();
        // кликнуть на Close в календаре
        app.myinfoPage.calendarDownDrop.getWrappedElement().findElement(byText("Close")).click();
        // проверка что календарь закрылся
        app.myinfoPage.calendarDownDrop.should(disappear);
    }

    @Test
    public void checkFieldClear(){
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("MyDetails");
        // кликнуть по элементу календаря
        app.myinfoPage.licenseExpiryDateField.click();
        // нажать сегодня
        app.myinfoPage.calendarDownDrop.getWrappedElement().findElement(byText("Today")).click();
        app.myinfoPage.licenseExpiryDateField.click();
        // кликнуть на Close в календаре
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
    public void checkDropDownNationality(){
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("MyDetails");
        app.myinfoPage.nationalityField.click();
        app.myinfoPage.downDrop.getWrappedElement().findElement(byText("Russian")).click();
        app.myinfoPage.nationalityFieldActive.shouldHave(Condition.exactText("Russian"));
    }

    @Test
    public void checkDropDownCountry(){
        app.loginPage.login(app.userCreds.adminLogin, app.userCreds.adminPassword);
        app.sideMenu.openTab("MyDetails");
        app.myinfoPage.maritalStatusField.click();
        app.myinfoPage.downDrop.getWrappedElement().findElement(byText("Married")).click();
        app.myinfoPage.nationalityFieldActive.shouldHave(Condition.exactText("Married"));
    }
}
