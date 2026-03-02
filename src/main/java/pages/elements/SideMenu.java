package pages.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SideMenu {

    public void openTab(String tabName) {
        $(By.xpath("//a[contains(@href, '" + tabName + "')]")).click();
    }
}
