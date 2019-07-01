package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductSelectionPage extends BasePage {

    @FindBy (linkText = "Nokia Lumia 1020")
    private WebElement selectedCellPhoneNokia;
    @FindBy (linkText = "HTC One M8 Android L 5.0 Lollipop")
    private WebElement selectedCellPhoneHTC;
    @FindBy (xpath = "//a[contains(text(),'Sound Forge')]/ancestor::div[contains(@class,'product-item')]")
    private WebElement addToWishlist1;
    @FindBy (id = "bar-notification")
    private WebElement alertSuccess;
    @FindBy (xpath = "//a[contains(text(),'Vintage Style')]/ancestor::div[contains(@class,'product-item')]")
    private WebElement addToWishlist2;
    @FindBy (className = "ico-wishlist")
    private WebElement wishListbutton;
    @FindBy (xpath = "//a[contains(text(),'Sound Forge')]/ancestor::div[contains(@class,'product-item')]")
    private WebElement compareProduct;
    @FindBy (xpath = "//a[contains(text(),'Vintage Style')]/ancestor::div[contains(@class,'product-item')]")
    private WebElement compareProduct2;
    @FindBy (linkText = "Compare products list")
    private WebElement compareProductButton;
    @FindBy (xpath = "//a[@href='/fahrenheit-451-by-ray-bradbury']")
    private WebElement selectedBook;
    @FindBy (xpath = "//a[@href=\"/nikon-d5500-dslr\"]")
    private WebElement selectedCamera;



    public void CellPhoneSelectionNokia () {

        selectedCellPhoneNokia.click();
    }

    public void CellPhoneSelectionHTC() {

        selectedCellPhoneHTC.click();

    }

    public void BookSelection () {

        selectedBook.click();

    }

    public void SelectedCamera(){

        selectedCamera.click();
    }

    public void ProductAddToWishlist () {


        addToWishlist1.findElement(By.cssSelector("input[value='Add to wishlist']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("bar-notification"))));
        Assert.assertEquals(alertSuccess.getText() , "The product has been added to your wishlist");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
        addToWishlist2.findElement(By.cssSelector("input[value='Add to wishlist']")).click();
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
