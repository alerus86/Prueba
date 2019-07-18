package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.*;

public class RegisterUserPage extends BasePage {


    @FindBy (id = "gender-male")
    private WebElement gender;
    @FindBy (id = "FirstName")
    private WebElement firstName;
    @FindBy (id = "LastName")
    private WebElement lastName;
    @FindBy (name = "DateOfBirthDay")
    private WebElement dayOfBirth;
    @FindBy (name = "DateOfBirthMonth")
    private WebElement monthOfBirth;
    @FindBy (name = "DateOfBirthYear")
    private WebElement yearOfBirth;
    @FindBy (id = "Email")
    private WebElement email;
    @FindBy (id = "Password")
    private WebElement password;
    @FindBy (id = "ConfirmPassword")
    private WebElement confirmPassword;
    @FindBy (id = "register-button")
    private WebElement registerUserButton;
    @FindBy (className = "result")
    private WebElement success;
    @FindBy (className = "page-title")
    private WebElement registerTitle;

    public RegisterUserPage(WebDriver chrome) {super(chrome);}

    public void registerUser (String firstName , String lastName , String dayOfBirth , String monthOfBirth , String yearOfBirth , String email , String password ,
                              String confirmPassword){

        assertEquals(registerTitle.getText() , "Register");
        gender.click();
        assertTrue(gender.isSelected());
        this.firstName.sendKeys(firstName);
        assertEquals(firstName , "Test");
        this.lastName.sendKeys(lastName);
        assertEquals(lastName , "Testing");
        Select comboDayOfBirth = new Select(this.dayOfBirth);
        comboDayOfBirth.selectByValue(dayOfBirth);
        assertEquals(dayOfBirth , "14");
        Select comboMonthOfBirth = new Select((this.monthOfBirth));
        comboMonthOfBirth.selectByValue(monthOfBirth);
        assertEquals(monthOfBirth , "7");
        Select comboYearOfBirth = new Select(this.yearOfBirth);
        comboYearOfBirth.selectByValue(yearOfBirth);
        assertEquals(yearOfBirth , "1986");
        this.email.sendKeys(email);
        assertEquals(email , "testing2004@test.com");
        this.password.sendKeys(password);
        assertEquals(password , "Test1234");
        this.confirmPassword.sendKeys(confirmPassword);
        assertEquals(confirmPassword , "Test1234");
        registerUserButton.click();

    }


    public boolean messageSuccessIsDisplayed(){
        return success.isDisplayed();
    }


}
