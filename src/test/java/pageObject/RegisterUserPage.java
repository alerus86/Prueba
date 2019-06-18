package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    public RegisterUserPage(WebDriver chrome) {super(chrome);}

    public void registerUser (String firstName , String lastName , String dayOfBirth , String monthOfBirth , String yearOfBirth , String email , String password ,
                              String confirmPassword){

        gender.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        Select comboDayOfBirth = new Select(this.dayOfBirth);
        comboDayOfBirth.selectByValue(dayOfBirth);
        Select comboMonthOfBirth = new Select((this.monthOfBirth));
        comboMonthOfBirth.selectByValue(monthOfBirth);
        Select comboYearOfBirth = new Select(this.yearOfBirth);
        comboYearOfBirth.selectByValue(yearOfBirth);
        this.monthOfBirth.sendKeys(monthOfBirth);
        this.yearOfBirth.sendKeys(yearOfBirth);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        registerUserButton.click();

    }


    public boolean messageSuccessIsDisplayed(){
        return success.isDisplayed();
    }


}
