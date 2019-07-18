package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy (id = "termsofservice")
    private WebElement termsOfService;
    @FindBy (id = "checkout")
    private  WebElement checkoutButton;
    @FindBy (className = "page-title")
    private WebElement shoppingCartTitle;

    public void CheckoutProduct () {

        termsOfService.click();
        checkoutButton.click();
    }

    public boolean ShoppingCartTitleDisplayed(){

        return shoppingCartTitle.isDisplayed();
    }



    public ShoppingCartPage(WebDriver chrome) {
        super(chrome);
    }
}
