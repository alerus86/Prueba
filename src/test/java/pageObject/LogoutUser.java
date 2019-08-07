package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutUser extends BasePage {

    @FindBy(className = "ico-logout")
    private WebElement logoutButton;


    public void logoutUser () {

        logoutButton.click();

    }


    public LogoutUser(WebDriver chrome) {
        super(chrome);
    }
}
