package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultProductPage extends BasePage {

    @FindBy (linkText = "Cell phones")
    private WebElement clickCellPhone;
    @FindBy (xpath = "//a[@href='/electronics']")
    private WebElement clickButtonProductElectronics;
    @FindBy (xpath = "//a [@href = '/books']")
    private WebElement clickBook;
    @FindBy (linkText = "Camera & photo")
    private WebElement clickCameraAndPhoto;
    @FindBy (id = "small-searchterms")
    private WebElement searchProductBar;


    public void SelectCellPhone() {

        clickButtonProductElectronics.click();
        clickCellPhone.click();
    }

    public void SelectBook () {

        clickBook.click();

    }

    public void SelectCameraAndPhoto () {

        clickButtonProductElectronics.click();
        clickCameraAndPhoto.click();

    }

    public void DataProviderProductSearch(String productSearch) {

        searchProductBar.sendKeys(productSearch);
        searchProductBar.submit();

    }

    public ResultProductPage(WebDriver chrome) {
        super(chrome);
    }
}
