package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultProductPage extends BasePage {

    @FindBy (linkText = "Cell phones")
    private WebElement clickCellPhone;

    public void SelectCellPhone() {

        clickCellPhone.click();
    }

    public ResultProductPage(WebDriver chrome) {
        super(chrome);
    }
}
