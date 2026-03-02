package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AdminPage  {
 //   private SelenideElement usernameField = $(By.xpath("//form//input[@class='oxd-input oxd-input--active']"));
    public SelenideElement usernameField = $(By.xpath("//form//input[@class='oxd-input oxd-input--active']"));
    private SelenideElement searchButton = $(By.xpath("//button[@type='submit']"));

    public void searchByUsername(String username) {
        usernameField.setValue(username);
        searchButton.click();
    }
}
