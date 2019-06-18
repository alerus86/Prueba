package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy (className = "ico-register")
    private WebElement registerButton;
    @FindBy (className = "html-registration-page")
    private WebElement registerTitlePage;
    @FindBy (className = "ico-login")
    private WebElement loginButton;
    @FindBy (className = "page-title")
    private WebElement loginTitlePage;
    @FindBy (xpath = "//a[@href='/electronics']")
    private WebElement clickButtonProduct;



    public RegisterUserPage register () {

        registerButton.click();
        return new RegisterUserPage(chrome);
    }

    public LoginUser login () {

        loginButton.click();
        return new LoginUser(chrome);

    }

    public ResultProductPage results () {

        clickButtonProduct.click();
        return new ResultProductPage(chrome);
    }

    public ProductSelectionPage productSelected () {

        return new ProductSelectionPage(chrome);

    }

    public ItemSelectedResult itemSelected () {

        return new ItemSelectedResult(chrome);
    }



    public boolean pageTitleIsDiplayed (){

        return registerTitlePage.isDisplayed();
    }

    public boolean loginTitleIsDisplayed () {

        return loginTitlePage.isDisplayed();
    }

    public HomePage(WebDriver chrome) {
        super(chrome);
    }
}
