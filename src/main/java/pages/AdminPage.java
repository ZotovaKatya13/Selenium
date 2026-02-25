package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AdminPage  {
    public SelenideElement adminTab = $(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]"));
    public SelenideElement usernameField = $(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
    public SelenideElement searchButton = $(By.xpath("//button[@type='submit']"));

}
