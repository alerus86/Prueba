package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class ItemSelectedResult extends BasePage {

    @FindBy (id = "bar-notification")
    private WebElement alertSuccess;
    @FindBy (className = "ico-cart")
    private WebElement shoppingCart;
    @FindBy (linkText = "Add your review")
    private WebElement addReview;
    @FindBy (css = "input[value='Email a friend']")
    private WebElement emailToFriend;
    @FindBy (id = "add-to-cart-button-20")
    private WebElement addToCartCellPhone;
    @FindBy (className = "product-name")
    private WebElement selectedProductTitle;
    @FindBy (className = "product-title")
    private WebElement selectedItem;
    @FindBy (className = "product-name")
    private WebElement selectedProductName;


    public void NokiCellPhone () {
        //elemento harcodeado, estás haciendo el test para un elemento especifico
        addToCartCellPhone.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("bar-notification"))));
        Assert.assertEquals(alertSuccess.getText() , "The product has been added to your shopping cart");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
        shoppingCart.click();
    }

    public void FahrenheitBook() {
        //elemento harcodeado, estás haciendo el test para un elemento especifico
        WebElement addToCartBook = chrome.findElement(By.xpath("//a[contains(text(),'Fahrenheit 451 by Ray Bradbury')]/ancestor::div[contains(@class,'product-item')]"));
        addToCartBook.findElement(By.cssSelector("input[value='Add to cart']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("bar-notification"))));
        Assert.assertEquals(alertSuccess.getText() , "The product has been added to your shopping cart");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
        shoppingCart.click();

    }

    public void NikonCamera () {

        addReview.click();


    }

    public void HTCOneMini () {

        emailToFriend.click();

    }

    public void SelectedProductDataProvider (String productSearch){


        WebElement div = chrome.findElement(By.xpath("//a[contains(text(),'"+ productSearch +"')]/ancestor::div[contains(@class,'product-item')]"));
        div.findElement(By.cssSelector("input[value='Add to wishlist']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("bar-notification"))));
        Assert.assertEquals(alertSuccess.getText(), "The product has been added to your wishlist");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
        shoppingCart.click();
    }

    public boolean ProductSelectedTitle () {

        return selectedProductTitle.isDisplayed();
    }

    public boolean ProductItemTitle () {

        return selectedItem.isDisplayed();
    }

    public boolean ProductTitleName () {

        return selectedProductName.isDisplayed();
    }





    public ItemSelectedResult(WebDriver chrome) {
        super(chrome);
    }


}
