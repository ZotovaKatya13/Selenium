package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class PIMPage extends BasePage{

    // локатор раздела MIM
    public SelenideElement PIMTab = $(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]"));
    // локатор поля EmployeeName
    public SelenideElement employeeNameField = $(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));
    // локатор поля EmployeeId
    public SelenideElement employeeIdField = $(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
    // локатор кнопки Search
    public SelenideElement searchButton = $(By.xpath("//button[@type='submit']"));
    // локатор результата поиска
    public SelenideElement result = $(By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]"));
    // кнопка Reset
    public SelenideElement resetButton = $(By.xpath("//button[@type='reset']"));

    // кнопка add Employee
    public SelenideElement buttonAddEmployee = $(By.xpath("(//li[@class='oxd-topbar-body-nav-tab'])[1]"));
    // локатор поля First Name
    //public SelenideElement firstNameField = $(By.xpath("//input[@name='firstName']"));
    public SelenideElement firstNameField = $(By.name("firstName"));
    // локатор поля Last Name
    public SelenideElement lastNameField = $(By.name("lastName"));
    // локатор результата создания нового пользователя
    public SelenideElement resultAddNewEmployee = $(By.xpath("(//*[@class='oxd-text oxd-text--h6 orangehrm-main-title'])[1]"));
    // локатор имени пользователя в его анкете
    public SelenideElement lastNameAndFirstName = $(By.xpath("(//*[@class='oxd-text oxd-text--h6 --strong'])"));

    // локатор FirstName в результате поиска
    public SelenideElement FirstNameSearchResult = $(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[3]"));
    // локатор Last Name в результате поиска
    public SelenideElement LastNameSearchResult = $(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[4]"));

    public void searchByUser(String username){
        employeeNameField.setValue(username);
        searchButton.click();
    }
    public void checkExpectedResultRows(int expectedRows){
        result.shouldBe(Condition.visible); // ждет пока элемент станет видимым
        result.shouldHave(Condition.exactText("(" + expectedRows + ") Record Found"));
    }
    public void resetButtonClick(){
        resetButton.click();
    }
    public void checkThatEmployeeNameIsEmpty(){
        employeeNameField.shouldBe(Condition.visible, Duration.ofSeconds(10));
        employeeNameField.shouldBe(Condition.empty);
    }
}
