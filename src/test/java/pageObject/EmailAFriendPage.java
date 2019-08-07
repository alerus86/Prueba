package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class EmailAFriendPage extends BasePage {

    @FindBy (id = "FriendEmail")
    private WebElement friendEmail;
    @FindBy (id = "PersonalMessage")
    private WebElement personalMessage;
    @FindBy (css = "input[value='Send email']")
    private WebElement sendEmailButton;
    @FindBy (className = "result")
    private WebElement emailSuccessfullySent;

    public void EmailAFriend (String friendEmail , String personalMessage) {

        this.friendEmail.sendKeys(friendEmail);
        this.personalMessage.sendKeys(personalMessage);
        sendEmailButton.click();
        assertEquals(emailSuccessfullySent.getText() , "Your message has been sent.");

    }


    public EmailAFriendPage(WebDriver chrome) {
        super(chrome);
    }
}
