package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LeavePage extends BasePage {
    public SelenideElement leaveTab = $(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[3]"));
    public SelenideElement employeeNameField = $(By.xpath("//label[contains(text(), 'Employee')]/ancestor::div[contains(@class, 'oxd-input-group')]//input"));
    public SelenideElement searchButton = $(By.xpath(""));
    public SelenideElement errorMessage = $(By.xpath(""));
}
