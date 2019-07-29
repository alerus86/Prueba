package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyAccountPage extends BasePage {

    @FindBy (className = "ico-account")
    private WebElement myAccountButton;
    @FindBy (xpath = "//a[@href='/customer/changepassword']")
    private WebElement changePasswordButton;
    @FindBy (className = "fieldset")
    private WebElement passwordFieldVisible;
    @FindBy (id = "OldPassword")
    private WebElement oldPassword;
    @FindBy (id = "NewPassword")
    private WebElement newPasswrod;
    @FindBy (id = "ConfirmNewPassword")
    private WebElement confirmNewPassword;
    @FindBy (className = "change-password-button")
    private WebElement confirmChangePasswordButton;
    @FindBy (className = "result")
    private WebElement passwordWasChange;
    @FindBy (xpath = "//a[@href = '/customer/addresses']")
    private WebElement myAddressButton;
    @FindBy (css = "input[onclick ='location.href=\\\"/customer/addressadd\\\"']")
    private WebElement addNewAddressButton;
    @FindBy (className = "page-title")
    private WebElement addNewAddressTitle;
    @FindBy (id = "Address_FirstName")
    private WebElement addressFirstName;
    @FindBy (id = "Address_LastName")
    private WebElement addressLastName;
    @FindBy (id = "Address_Email")
    private WebElement addressEmail;
    @FindBy (id = "Address_CountryId")
    private WebElement countrySelectAddress;
    @FindBy (id = "Address_StateProvinceId")
    private WebElement stateComboAddress;
    @FindBy (id = "Address_City")
    private WebElement cityAddress;
    @FindBy (id = "Address_Address1")
    private WebElement newAddress;
    @FindBy (id = "Address_ZipPostalCode")
    private WebElement zipCodeAddress;
    @FindBy (id = "Address_PhoneNumber")
    private WebElement phoneNumberAddress;
    @FindBy (className = "save-address-button")
    private WebElement saveNewAddress;
    @FindBy (className = "page-title")
    private WebElement myAccountTitle;
    @FindBy (className = "page-title")
    private WebElement myAddressTitle;


    public void changePassword (String oldPassword , String newPassword , String confirmNewPassword) {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("form-fields")));
        assertEquals(myAccountButton.getText() , "My account");
        changePasswordButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("master-wrapper-page")));
        assertTrue(passwordFieldVisible.isDisplayed());
        this.oldPassword.sendKeys(oldPassword);
        assertEquals(oldPassword , "Testing#");
        this.newPasswrod.sendKeys(newPassword);
        assertEquals(newPassword , "Testing$");
        this.confirmNewPassword.sendKeys(confirmNewPassword);
        assertEquals(confirmNewPassword , "Testing$");
        confirmChangePasswordButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("result")));
        assertEquals(passwordWasChange.getText() , "Password was changed");
    }

    public void addNewAddress (String addressFirstName , String addressLastName , String addressEmail , String countrySelectAddress ,
                               String stateComboAddress , String cityAddress , String newAddress , String zipCodeAddress , String phoneNumberAddress) {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("form-fields")));
        assertEquals(myAccountButton.getText() , "My account");
        myAddressButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("page-title")));
        assertEquals(addNewAddressTitle.getText() , "My account - Addresses");
        addNewAddressButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("page-title")));
        assertEquals(addNewAddressTitle.getText() , "My account - Add new address");
        this.addressFirstName.sendKeys(addressFirstName);
        assertEquals(addressFirstName , "Test1");
        this.addressLastName.sendKeys(addressLastName);
        assertEquals(addressLastName , "Testing1");
        this.addressEmail.sendKeys(addressEmail);
        assertEquals(addressEmail , "testing2019@testing.com");
        Select countryCombo = new Select(this.countrySelectAddress);
        countryCombo.selectByValue(countrySelectAddress);
        Select stateCombo = new Select(this.stateComboAddress);
        stateCombo.selectByValue(stateComboAddress);
        this.cityAddress.sendKeys(cityAddress);
        assertEquals(cityAddress , "City");
        this.newAddress.sendKeys(newAddress);
        assertEquals(newAddress , "Testing 1212 block 2");
        this.zipCodeAddress.sendKeys(zipCodeAddress);
        assertEquals(zipCodeAddress , "12345");
        this.phoneNumberAddress.sendKeys(phoneNumberAddress);
        assertEquals(phoneNumberAddress , "1234567");
        saveNewAddress.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("page-title")));
        assertEquals(addNewAddressTitle.getText() , "My account - Addresses");


    }

    public boolean MyAccountPageTitleDisplayed () {

        return myAccountTitle.isDisplayed();
    }

    public boolean MyAddressPageTitleDisplayed () {

        return myAddressTitle.isDisplayed();
    }


    public MyAccountPage(WebDriver chrome) {
        super(chrome);
    }
}
