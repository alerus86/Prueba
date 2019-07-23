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
    @FindBy (id = "small-searchterms")
    private WebElement searchProductBar;
    @FindBy (className = "page-title")
    private WebElement searchTitleDisplayed;

    public void searchProduct ( String searchElement) {

        this.searchElement.sendKeys(searchElement);
        this.searchElement.submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));

    }

    public void DataProviderProductSearch(String productSearch) {

        searchProductBar.sendKeys(productSearch);
        searchProductBar.submit();

    }


    public boolean ResultsProductsDisplayed (){

        return resultsSearchProduct.isDisplayed();
    }

    public boolean SearchTitleDisplayed () {

        return searchTitleDisplayed.isDisplayed();
    }

    public SearchAndResultPage(WebDriver chrome) {
        super(chrome);
    }
}
