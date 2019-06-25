package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductSelectionPage extends BasePage {

    @FindBy (linkText = "Nokia Lumia 1020")
    private WebElement selectedCellPhone;
    @FindBy (css = "input[onclick = 'return AjaxCart.addproducttocart_catalog(\\\"/addproducttocart/catalog/12/2/1\\\"),!1']")
    private WebElement addToWishlist1;
    @FindBy (id = "bar-notification")
    private WebElement alertSuccess;
    @FindBy (css = "input[onclick = 'return AjaxCart.addproducttocart_catalog(\\\"/addproducttocart/catalog/42/2/1\\\"),!1']")
    private WebElement addToWishlist2;
    @FindBy (className = "ico-wishlist")
    private WebElement wishListbutton;
    @FindBy (css = "input[onclick = 'return AjaxCart.addproducttocomparelist(\\\"/compareproducts/add/12\\\"),!1']")
    private WebElement compareProduct;
    @FindBy (css = "input[onclick = 'return AjaxCart.addproducttocomparelist(\\\"/compareproducts/add/42\\\"),!1']")
    private WebElement compareProduct2;
    @FindBy (linkText = "Compare products list")
    private WebElement compareProductButton;



    public void CellPhoneSelection () {

        selectedCellPhone.click();
    }

    public void ProductAddToWishlist () {

        addToWishlist1.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("bar-notification"))));
        Assert.assertEquals(alertSuccess.getText() , "The product has been added to your wishlist");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
        addToWishlist2.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("bar-notification"))));
        Assert.assertEquals(alertSuccess.getText() , "The product has been added to your wishlist");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
        wishListbutton.click();

    }

    public void ProductCompareList () {

        compareProduct.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("bar-notification"))));
        Assert.assertEquals(alertSuccess.getText() , "The product has been added to your product comparison");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
        compareProduct2.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("bar-notification"))));
        Assert.assertEquals(alertSuccess.getText() , "The product has been added to your product comparison");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
        compareProductButton.click();

    }


    public ProductSelectionPage(WebDriver chrome) {
        super(chrome);
    }
}
