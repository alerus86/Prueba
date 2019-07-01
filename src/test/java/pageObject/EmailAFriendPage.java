package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailAFriendPage extends BasePage {

    @FindBy (id = "FriendEmail")
    private WebElement friendEmail;
    @FindBy (id = "PersonalMessage")
    private WebElement personalMessage;
    @FindBy (css = "input[value='Send email']")
    private WebElement sendEmailButton;

    public void EmailAFriend (String friendEmail , String personalMessage) {

        this.friendEmail.sendKeys(friendEmail);
        this.personalMessage.sendKeys(personalMessage);
        sendEmailButton.click();

    }


    public EmailAFriendPage(WebDriver chrome) {
        super(chrome);
    }
}
