package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static java.awt.SystemColor.window;

import org.testng.annotations.AfterTest;
import utils.App;

public class BaseTest {

    App app = new App();

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        Configuration.fileDownload = FileDownloadMode.FOLDER;
        Configuration.downloadsFolder = "build/downloads";
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
