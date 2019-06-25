package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

    public void checkoutProduct (String countryCombo , String city , String address1 , String zipCode , String phoneNumber) {

        unCheckShippingAddress.click();
        Select comboCountry = new Select(selectCountryCombo);
        comboCountry.selectByValue(countryCombo);
        this.city.sendKeys(city);
        this.address1.sendKeys(address1);
        this.zipCode.sendKeys(zipCode);
        this.phoneNumber.sendKeys(phoneNumber);
        continueButton.click();
        continueButtonStep2.click();
        shippingButton.click();
        continueButtonStep3.click();
        continueButtonStep4.click();
        continueButtonStep5.click();
        continueButtonStep6.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));


    }

    public void checkoutProductCreditCard (String countryCombo , String city , String address1 , String zipCode , String phoneNumber , String cardHolderName
            , String cardNumber , String monthExpirationCard , String yearExpirationCard , String cardCode){

        unCheckShippingAddress.click();
        Select comboCountry = new Select(selectCountryCombo);
        comboCountry.selectByValue(countryCombo);
        this.city.sendKeys(city);
        this.address1.sendKeys(address1);
        this.zipCode.sendKeys(zipCode);
        this.phoneNumber.sendKeys(phoneNumber);
        continueButton.click();
        continueButtonStep2.click();
        shippingButton.click();
        continueButtonStep3.click();
        creditCardPayment.click();
        continueButtonStep4.click();
        this.cardHolderName.sendKeys(cardHolderName);
        this.cardNumber.sendKeys(cardNumber);
        this.monthExpirationCard.sendKeys(monthExpirationCard);
        this.yearExpirationCard.sendKeys(yearExpirationCard);
        this.cardCode.sendKeys(cardCode);
        continueButtonStep5.click();
        continueButtonStep6.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));

    }

    public boolean orderConfirmationSuccess(){
        return orderConfirmation.isDisplayed();
    }


    public CheckoutPage(WebDriver chrome) {
        super(chrome);
    }
}
