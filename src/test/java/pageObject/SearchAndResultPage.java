package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchAndResultPage extends BasePage {

    @FindBy (id = "small-searchterms")
    private WebElement searchElement;
    @FindBy (className = "item-grid")
    private WebElement resultsSearchProduct;

    public void searchProduct ( String searchElement) {

        this.searchElement.sendKeys(searchElement);
        this.searchElement.submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));

    }

    public boolean resultsProductsDisplayed (){

        return resultsSearchProduct.isDisplayed();
    }

    public SearchAndResultPage(WebDriver chrome) {
        super(chrome);
    }
}
