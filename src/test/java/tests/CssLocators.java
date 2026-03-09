package tests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class CssLocators {
    SelenideElement element = $("input.oxd-input.oxd-input--active.orangehrm-firstname");

    @Test
    public void testCssLocators() {

    element.click();

}
}
