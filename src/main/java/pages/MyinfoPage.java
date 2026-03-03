package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyinfoPage {

   // элемент поля календаря
    public SelenideElement licenseExpiryDateField = $(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]"));
    // элемент календаря списка
    public SelenideElement calendarDownDrop = $(By.xpath("//div[@class='oxd-calendar-wrapper']"));

    public SelenideElement nationalityField = $(By.xpath("//div[contains(text(),'American')]"));
    public SelenideElement downDrop = $(By.xpath("//div[@role='listbox']"));
    public SelenideElement nationalityFieldActive = $(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
    public SelenideElement maritalStatusField = $(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]"));
    public SelenideElement selectStatus = $(By.xpath("(//div[contains(text(),'Select')])[2]"));
    public SelenideElement checkStatus = $(By.xpath("(//div[contains(text(),'Enabled')])[2]"));
}
