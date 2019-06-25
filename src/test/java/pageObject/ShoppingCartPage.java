package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy (id = "termsofservice")
    private WebElement termsOfService;
    @FindBy (id = "checkout")
    private  WebElement checkoutButton;

    public void CheckoutProduct () {

        termsOfService.click();
        checkoutButton.click();
    }



    public ShoppingCartPage(WebDriver chrome) {
        super(chrome);
    }
}
