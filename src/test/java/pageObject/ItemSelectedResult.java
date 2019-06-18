package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ItemSelectedResult extends BasePage {

    @FindBy (id = "add-to-cart-button-20")
    private WebElement addToCart;
    @FindBy (id = "bar-notification")
    private WebElement alertSuccess;




    public void NokiCellPhone () {

        addToCart.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("bar-notification"))));
        Assert.assertEquals(alertSuccess.getText() , "The product has been added to your shopping cart");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
    }




    public ItemSelectedResult(WebDriver chrome) {
        super(chrome);
    }


}
