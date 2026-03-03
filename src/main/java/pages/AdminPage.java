package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AdminPage  {
 //   private SelenideElement usernameField = $(By.xpath("//form//input[@class='oxd-input oxd-input--active']"));
    public SelenideElement usernameField = $(By.xpath("//form//input[@class='oxd-input oxd-input--active']"));
    // private SelenideElement searchButton = $(By.xpath("//button[@type='submit']"));
    public SelenideElement searchButton = $(By.xpath("//button[@type='submit']"));

    public void searchByUsername(String username) {
        usernameField.setValue(username);
        searchButton.click();
    }

    // селектор
    public SelenideElement userRoleButton = $(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]"));
    public SelenideElement userRoleDropDown = $(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']"));

}
