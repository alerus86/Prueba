package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

public class CheckoutPage extends BasePage {

    @FindBy (id = "ShipToSameAddress")
    private WebElement unCheckShippingAddress;
    @FindBy (id = "BillingNewAddress_CountryId")
    private WebElement selectCountryCombo;
    @FindBy (id = "BillingNewAddress_City")
    private WebElement city;
    @FindBy (id = "BillingNewAddress_Address1")
    private WebElement address1;
    @FindBy (id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipCode;
    @FindBy (id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneNumber;
    @FindBy (className = "new-address-next-step-button")
    private WebElement continueButton;
    @FindBy (css = "input[onclick ='Shipping.save()']")
    private WebElement continueButtonStep2;
    @FindBy (id = "shippingoption_1")
    private WebElement shippingButton;
    @FindBy (css = "input[onclick = 'ShippingMethod.save()']")
    private WebElement continueButtonStep3;
    @FindBy (css = "input[onclick = 'PaymentMethod.save()']")
    private WebElement continueButtonStep4;
    @FindBy (css = "input[onclick ='PaymentInfo.save()']")
    private WebElement continueButtonStep5;
    @FindBy (css = "input[onclick ='ConfirmOrder.save()']")
    private WebElement continueButtonStep6;
    @FindBy (className = "page-title")
    private WebElement orderConfirmation;
    @FindBy (id = "paymentmethod_1")
    private WebElement creditCardPayment;
    @FindBy (id = "CardholderName")
    private WebElement cardHolderName;
    @FindBy (id = "CardNumber")
    private WebElement cardNumber;
    @FindBy (id = "ExpireMonth")
    private WebElement monthExpirationCard;
    @FindBy (id = "ExpireYear")
    private WebElement yearExpirationCard;
    @FindBy (id = "CardCode")
    private WebElement cardCode;
    @FindBy (xpath = "//a[contains(text(),'Nokia')]/parent::td/parent::tr")
    private WebElement deleteCheckSelected1;
    @FindBy (xpath = "//a[contains(text(),'Fahrenheit')]/parent::td/parent::tr")
    private WebElement deleteCheckSelected2;
    @FindBy (className = "update-cart-button")
    private WebElement updateCart;
    @FindBy (className = "page-title")
    private WebElement resultDeleteItems;
    @FindBy (id = "billing-address-select")
    private WebElement addressDropdown;
    @FindBy (css = "input[onclick='Billing.save()']")
    private WebElement continueButtonSelectedAddress;
    @FindBy (css = "input[onclick='Shipping.save()']")
    private WebElement continueButtonSelectedAddress2;
    @FindBy (className = "page-title")
    private WebElement shoppingCartTitle;


    public void checkoutProduct (String countryCombo , String city , String address1 , String zipCode , String phoneNumber) {

        boolean firstTime;
        unCheckShippingAddress.click();
        try {

            firstTime = true;
            Select comboCountry = new Select(selectCountryCombo);
            comboCountry.selectByValue(countryCombo);

        }
        catch (Exception e) {

            firstTime=false;

        }
        if (firstTime) {

            this.city.sendKeys(city);
            this.address1.sendKeys(address1);
            this.zipCode.sendKeys(zipCode);
            this.phoneNumber.sendKeys(phoneNumber);
            continueButton.click();
            continueButtonStep2.click();
            shippingButton.click();
            continueButtonStep3.click();
            wait.until(ExpectedConditions.elementToBeClickable((By.id("paymentmethod_0"))));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick = 'PaymentMethod.save()']")));
            continueButtonStep4.click();
            continueButtonStep5.click();
            continueButtonStep6.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick='setLocation(\"/\")']")));
        }
        else {

            Select comboAddress = new Select(addressDropdown);
            comboAddress.selectByIndex(0);
            continueButtonSelectedAddress.click();
            continueButtonSelectedAddress2.click();
            continueButtonStep3.click();
            wait.until(ExpectedConditions.elementToBeClickable((By.id("paymentmethod_0"))));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick = 'PaymentMethod.save()']")));
            continueButtonStep4.click();
            continueButtonStep5.click();
            continueButtonStep6.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[onclick='setLocation(\"/\")']")));

        }


    }

    public void checkoutProductCreditCard (String countryCombo , String city , String address1 , String zipCode , String phoneNumber , String cardHolderName
            , String cardNumber , String monthExpirationCard , String yearExpirationCard , String cardCode){

        boolean firstTime;
        boolean alertDisplay;
        unCheckShippingAddress.click();
        try {
            firstTime = true;
            Select comboCountry = new Select(selectCountryCombo);
            comboCountry.selectByValue(countryCombo);

        }
        catch (Exception e){
            firstTime = false;
        }
        if (firstTime) {
            this.city.sendKeys(city);
            this.address1.sendKeys(address1);
            this.zipCode.sendKeys(zipCode);
            this.phoneNumber.sendKeys(phoneNumber);
            continueButton.click();
            continueButtonStep2.click();
            shippingButton.click();
            continueButtonStep3.click();
            wait.until(ExpectedConditions.elementToBeClickable((By.id("paymentmethod_1"))));
            creditCardPayment.click();
            continueButtonStep4.click();
            this.cardHolderName.sendKeys(cardHolderName);
            this.cardNumber.sendKeys(cardNumber);
            this.monthExpirationCard.sendKeys(monthExpirationCard);
            this.yearExpirationCard.sendKeys(yearExpirationCard);
            this.cardCode.sendKeys(cardCode);
            continueButtonStep5.click();
            try {
                //te agrego comentarios acerca de esto en el resumen
                while (alertDisplay = true) {
                    continueButtonStep6.click();
                    wait.until(ExpectedConditions.alertIsPresent());
                    Alert alert1 = chrome.switchTo().alert();
                    alert1.accept();
                    continueButtonStep6.click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));
                }
            }
            catch (Exception e) {
                alertDisplay = false;
            }

        }
        else {
            Select comboAddress = new Select(addressDropdown);
            comboAddress.selectByIndex(0);
            continueButtonSelectedAddress.click();
            continueButtonSelectedAddress2.click();
            continueButtonStep3.click();
            wait.until(ExpectedConditions.elementToBeClickable((By.id("paymentmethod_1"))));
            creditCardPayment.click();
            continueButtonStep4.click();
            this.cardHolderName.sendKeys(cardHolderName);
            this.cardNumber.sendKeys(cardNumber);
            this.monthExpirationCard.sendKeys(monthExpirationCard);
            this.yearExpirationCard.sendKeys(yearExpirationCard);
            this.cardCode.sendKeys(cardCode);
            continueButtonStep5.click();
            try {
                //te agrego comentarios acerca de esto en el resumen
                while (alertDisplay = true) {
                    continueButtonStep6.click();
                    wait.until(ExpectedConditions.alertIsPresent());
                    Alert alert1 = chrome.switchTo().alert();
                    alert1.accept();
                    continueButtonStep6.click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));
                }

            }
            catch (Exception e) {
                alertDisplay = false;
            }

        }
    }

    public void deleteCheckoutProduct() {
        //productos harcodeados
        deleteCheckSelected1.findElement(By.cssSelector("[type='checkbox']")).click();
        deleteCheckSelected2.findElement(By.cssSelector("[type='checkbox']")).click();
        updateCart.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));
        assertEquals(resultDeleteItems.getText() , "Shopping cart");

    }

    public boolean ShoppingCartTitleDisplayed () {
        return shoppingCartTitle.isDisplayed();
    }
    public boolean OrderConfirmationSuccess(){
        return orderConfirmation.isDisplayed();
    }


    public CheckoutPage(WebDriver chrome) {
        super(chrome);
    }
}
