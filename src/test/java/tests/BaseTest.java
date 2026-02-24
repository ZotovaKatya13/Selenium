package tests;
import org.testng.annotations.BeforeTest;
import static com.codeborne.selenide.Selenide.open;
import org.testng.annotations.AfterTest;

public class BaseTest {

    @BeforeTest
public void setup(){
open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @AfterTest
public void tearDown(){

    }
}
