package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSelectionPage extends BasePage {

    @FindBy (linkText = "Nokia Lumia 1020")
    private WebElement selectedCellPhone;

    public void CellPhoneSelection () {

        selectedCellPhone.click();
    }



    public ProductSelectionPage(WebDriver chrome) {
        super(chrome);
    }
}
