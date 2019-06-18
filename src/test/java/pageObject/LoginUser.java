package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginUser extends BasePage {

    @FindBy (className = "page-title")
    private WebElement titleLogin;
    @FindBy (id = "Email")
    private WebElement loginEmail;
    @FindBy (id = "Password")
    private WebElement loginPassword;
    @FindBy (className = "login-button")
    private WebElement loginUserButton;


    public void loginUser (String email , String password) {

        loginEmail.sendKeys(email);
        loginPassword.sendKeys(password);
        loginUserButton.click();

    }

    public LoginUser(WebDriver chrome) {
        super(chrome);
    }

    public boolean loginTitleIsDisplayed(){
        return titleLogin.isDisplayed();
    }
}
