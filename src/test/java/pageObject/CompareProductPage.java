package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductPage extends BasePage {

    @FindBy (className = "clear-list")
    private WebElement clearButton;

    public boolean clearListButton () {

        return clearButton.isDisplayed();
    }


    public CompareProductPage(WebDriver chrome) {
        super(chrome);
    }
}
