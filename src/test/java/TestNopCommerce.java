import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TestNopCommerce
    {
        /* ID(si el ID es único en la página)
         • Name(si el name es único en la página)
         • Class Name
         • Tag name
         • CSS Selector
         • Link text o partial link text
         • XPath
 */
        WebElement gender;
        WebElement firstName;
        WebElement lastName;
        Select dayOfBirth;
        Select monthOfBirth;
        Select yearOfBirth;
        WebElement email;
        WebElement password;
        WebElement confirmPassword;
        WebElement registerUserButton;
        WebDriverWait wait = null;
        WebDriver chrome = null;
        ChromeOptions chromeOptions = null;
        SoftAssert softAssert;


        @BeforeClass
        public void setup ()
        {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            softAssert = new SoftAssert();
        }

        @BeforeMethod
        public void setupTest(){

            chrome = new ChromeDriver(chromeOptions);
            wait = new WebDriverWait(chrome, 10);
            chrome.get("http://demo.nopcommerce.com/");
            chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        //CP1
        @Test
        public void nuevoUsuarioRegistrado () {

            WebElement registerButton = chrome.findElement(By.className("ico-register"));
            registerButton.click();
            assertEquals(chrome.getTitle(), "nopCommerce demo store. Register");
            gender = chrome.findElement(By.id("gender-male"));
            gender.click();
            firstName = chrome.findElement(By.id("FirstName"));
            firstName.sendKeys("TestingFirstName");
            lastName = chrome.findElement(By.id("LastName"));
            lastName.sendKeys("TestingLastName");
            dayOfBirth = new Select(chrome.findElement(By.name("DateOfBirthDay")));
            dayOfBirth.selectByIndex(14);
            monthOfBirth = new Select(chrome.findElement(By.name("DateOfBirthMonth")));
            monthOfBirth.selectByIndex(7);
            yearOfBirth = new Select(chrome.findElement(By.name("DateOfBirthYear")));
            yearOfBirth.selectByValue("1986");
            email = chrome.findElement(By.id("Email"));
            email.sendKeys("testing2002@testing.com");
            password = chrome.findElement(By.id("Password"));
            password.sendKeys("Testing1234");
            confirmPassword = chrome.findElement(By.id("ConfirmPassword"));
            confirmPassword.sendKeys("Testing1234");
            registerUserButton = chrome.findElement(By.id("register-button"));
            registerUserButton.click();
            assertEquals(chrome.getTitle(), "nopCommerce demo store. Register");

        }

        //CP2
        @Test
        public void checkOutConEfectivo() {

            WebElement login = chrome.findElement(By.className("ico-login"));
            login.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-button")));
            WebElement titleVisible = chrome.findElement(By.className("page-title"));
            assertEquals(titleVisible.getText() , "Welcome, Please Sign In!");
            WebElement loginEmail = chrome.findElement(By.id("Email"));
            loginEmail.sendKeys("testing2002@testing.com");
            WebElement loginPassword = chrome.findElement(By.id("Password"));
            loginPassword.sendKeys("Testing!");
            WebElement loginUser = chrome.findElement(By.className("login-button"));
            loginUser.click();
            WebElement clickProduct = chrome.findElement(By.xpath("//a[@href='/electronics']"));
            clickProduct.click();
            WebElement clickCellPhone = chrome.findElement(By.linkText("Cell phones"));
            clickCellPhone.click();
            WebElement selectedCellPhone = chrome.findElement(By.linkText("Nokia Lumia 1020"));
            selectedCellPhone.click();
            WebElement addToCart = chrome.findElement(By.id("add-to-cart-button-20"));
            addToCart.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
            WebElement alertSuccess = chrome.findElement(By.id("bar-notification"));
            assertEquals(alertSuccess.getText(), "The product has been added to your shopping cart");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
            WebElement shoppingCart = chrome.findElement(By.className("ico-cart"));
            shoppingCart.click();
            WebElement checkTermsOfService = chrome.findElement(By.id("termsofservice"));
            checkTermsOfService.click();
            WebElement checkout = chrome.findElement(By.id("checkout"));
            checkout.click();
            WebElement unCheckShippingAddress = chrome.findElement(By.id("ShipToSameAddress"));
            unCheckShippingAddress.click();
            WebElement selectCountryCombo = chrome.findElement(By.id("BillingNewAddress_CountryId"));
            Select countrySelect = new Select(selectCountryCombo);
            countrySelect.selectByValue("235");
            WebElement city = chrome.findElement(By.id("BillingNewAddress_City"));
            city.sendKeys("Montevideo");
            WebElement address1 = chrome.findElement(By.id("BillingNewAddress_Address1"));
            address1.sendKeys("Testing 1234");
            WebElement zipCode = chrome.findElement(By.id("BillingNewAddress_ZipPostalCode"));
            zipCode.sendKeys("123456");
            WebElement phoneNumber = chrome.findElement(By.id("BillingNewAddress_PhoneNumber"));
            phoneNumber.sendKeys("123456789");
            WebElement continueButton = chrome.findElement(By.className("new-address-next-step-button"));
            continueButton.click();
            WebElement continueButtonStep2 = chrome.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input"));
            continueButtonStep2.click();
            WebElement shippingButton = chrome.findElement(By.id("shippingoption_1"));
            shippingButton.click();
            WebElement continueButtonStep3 = chrome.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input"));
            continueButtonStep3.click();
            WebElement continueButtonStep4 = chrome.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input"));
            continueButtonStep4.click();
            WebElement continueButtonStep5 = chrome.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input"));
            continueButtonStep5.click();
            WebElement continueButtonStep6 = chrome.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input"));
            continueButtonStep6.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));
            WebElement orderConfirmation = chrome.findElement(By.className("page-title"));
            assertEquals(orderConfirmation.getText() , "Checkout");
        }

        //CP3
        @Test
        public void checkOutConTarjetaDeCredito () {

            WebElement login = chrome.findElement(By.className("ico-login"));
            login.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-button")));
            WebElement titleVisible = chrome.findElement(By.className("page-title"));
            assertEquals(titleVisible.getText() , "Welcome, Please Sign In!");
            WebElement loginEmail = chrome.findElement(By.id("Email"));
            loginEmail.sendKeys("testing2002@testing.com");
            WebElement loginPassword = chrome.findElement(By.id("Password"));
            loginPassword.sendKeys("Testing!");
            WebElement loginUser = chrome.findElement(By.className("login-button"));
            loginUser.click();
            WebElement clickProduct = chrome.findElement(By.xpath("//a[@href='/electronics']"));
            clickProduct.click();
            WebElement clickCellPhone = chrome.findElement(By.linkText("Cell phones"));
            clickCellPhone.click();
            WebElement selectedCellPhone = chrome.findElement(By.linkText("Nokia Lumia 1020"));
            selectedCellPhone.click();
            WebElement addToCart = chrome.findElement(By.id("add-to-cart-button-20"));
            addToCart.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
            WebElement alertSuccess = chrome.findElement(By.id("bar-notification"));
            assertEquals(alertSuccess.getText(), "The product has been added to your shopping cart");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
            WebElement shoppingCart = chrome.findElement(By.className("ico-cart"));
            shoppingCart.click();
            WebElement checkTermsOfService = chrome.findElement(By.id("termsofservice"));
            checkTermsOfService.click();
            WebElement checkout = chrome.findElement(By.id("checkout"));
            checkout.click();
            WebElement unCheckShippingAddress = chrome.findElement(By.id("ShipToSameAddress"));
            unCheckShippingAddress.click();
            WebElement selectCountryCombo = chrome.findElement(By.id("BillingNewAddress_CountryId"));
            Select countrySelect = new Select(selectCountryCombo);
            countrySelect.selectByValue("235");
            WebElement city = chrome.findElement(By.id("BillingNewAddress_City"));
            city.sendKeys("Montevideo");
            WebElement address1 = chrome.findElement(By.id("BillingNewAddress_Address1"));
            address1.sendKeys("Testing 1234");
            WebElement zipCode = chrome.findElement(By.id("BillingNewAddress_ZipPostalCode"));
            zipCode.sendKeys("123456");
            WebElement phoneNumber = chrome.findElement(By.id("BillingNewAddress_PhoneNumber"));
            phoneNumber.sendKeys("123456789");
            WebElement continueButton = chrome.findElement(By.className("new-address-next-step-button"));
            continueButton.click();
            WebElement continueButtonStep2 = chrome.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input"));
            continueButtonStep2.click();
            WebElement shippingButton = chrome.findElement(By.id("shippingoption_1"));
            shippingButton.click();
            WebElement continueButtonStep3 = chrome.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input"));
            continueButtonStep3.click();
            WebElement creditCardPayment = chrome.findElement(By.id("paymentmethod_1"));
            creditCardPayment.click();
            WebElement continueButtonStep4 = chrome.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input"));
            continueButtonStep4.click();
            WebElement cardHolderName = chrome.findElement(By.id("CardholderName"));
            cardHolderName.sendKeys("Testing Tester");
            WebElement cardNumber = chrome.findElement(By.id("CardNumber"));
            cardNumber.sendKeys("0000000000000000");
            WebElement monthExpirationCard = chrome.findElement(By.id("ExpireMonth"));
            Select monthOfExpirationSelect = new Select(monthExpirationCard);
            monthOfExpirationSelect.selectByValue("12");
            WebElement yearExpirationCard = chrome.findElement(By.id("ExpireYear"));
            Select yearOfExpirationCard = new Select(yearExpirationCard);
            yearOfExpirationCard.selectByValue("2022");
            WebElement cardCode = chrome.findElement(By.id("CardCode"));
            cardCode.sendKeys("1234");
            WebElement continueButtonStep5 = chrome.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input"));
            continueButtonStep5.click();
            WebElement continueButtonStep6 = chrome.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input"));
            continueButtonStep6.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));
            WebElement orderConfirmation = chrome.findElement(By.className("page-title"));
            assertEquals(orderConfirmation.getText() , "Checkout");

        }

        //CP4
        @Test
        public void agregarWishlist (){

            WebElement login = chrome.findElement(By.className("ico-login"));
            login.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-button")));
            WebElement titleVisible = chrome.findElement(By.className("page-title"));
            assertEquals(titleVisible.getText() , "Welcome, Please Sign In!");
            WebElement loginEmail = chrome.findElement(By.id("Email"));
            loginEmail.sendKeys("testing2002@testing.com");
            WebElement loginPassword = chrome.findElement(By.id("Password"));
            loginPassword.sendKeys("Testing!");
            WebElement loginUser = chrome.findElement(By.className("login-button"));
            loginUser.click();
            WebElement searchElement = chrome.findElement(By.id("small-searchterms"));
            searchElement.sendKeys("ring");
            searchElement.submit();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));
            WebElement orderConfirmation = chrome.findElement(By.className("page-title"));
            assertEquals(orderConfirmation.getText() , "Search");
            WebElement agregarWishlist1 = chrome.findElement(By.cssSelector("input[onclick = 'return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/12/2/1\"),!1']"));
            agregarWishlist1.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
            WebElement alertSuccess = chrome.findElement(By.id("bar-notification"));
            assertEquals(alertSuccess.getText(), "The product has been added to your wishlist");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
            WebElement agregarWishlist2 = chrome.findElement(By.cssSelector("input[onclick = 'return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/42/2/1\"),!1']"));
            agregarWishlist2.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
            WebElement wishlistButton = chrome.findElement(By.className("ico-wishlist"));
            wishlistButton.click();
            softAssert.assertEquals(chrome.findElement(By.xpath("//a[@href='/sound-forge-pro-11-recurring']")).getText() , "");
            softAssert.assertEquals(chrome.findElement(By.xpath("//a[@href='/vintage-style-engagement-ring']")).getText() , "");
            softAssert.assertAll();
        }

        //CP5
        @Test
        public void compareProducts () {

            WebElement login = chrome.findElement(By.className("ico-login"));
            login.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-button")));
            WebElement titleVisible = chrome.findElement(By.className("page-title"));
            assertEquals(titleVisible.getText() , "Welcome, Please Sign In!");
            WebElement loginEmail = chrome.findElement(By.id("Email"));
            loginEmail.sendKeys("testing2002@testing.com");
            WebElement loginPassword = chrome.findElement(By.id("Password"));
            loginPassword.sendKeys("Testing!");
            WebElement loginUser = chrome.findElement(By.className("login-button"));
            loginUser.click();
            WebElement searchElement = chrome.findElement(By.id("small-searchterms"));
            searchElement.sendKeys("ring");
            searchElement.submit();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));
            WebElement orderConfirmation = chrome.findElement(By.className("page-title"));
            assertEquals(orderConfirmation.getText() , "Search");
            WebElement compareProduct = chrome.findElement(By.cssSelector("input[onclick = 'return AjaxCart.addproducttocomparelist(\"/compareproducts/add/12\"),!1']"));
            compareProduct.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
            WebElement alertSuccess = chrome.findElement(By.id("bar-notification"));
            assertEquals(alertSuccess.getText(), "The product has been added to your product comparison");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
            WebElement compareProduct2 = chrome.findElement(By.cssSelector("input[onclick = 'return AjaxCart.addproducttocomparelist(\"/compareproducts/add/42\"),!1']"));
            compareProduct2.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
            WebElement alertSuccess2 = chrome.findElement(By.id("bar-notification"));
            assertEquals(alertSuccess2.getText(), "The product has been added to your product comparison");
            WebElement compareProductButton = chrome.findElement(By.linkText("Compare products list"));
            compareProductButton.click();
            WebElement clearButton = chrome.findElement(By.className("clear-list"));
            assertTrue(clearButton.isDisplayed());

        }

        //CP6
        @Test
        public void changePassword() {

            WebElement login = chrome.findElement(By.className("ico-login"));
            login.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-button")));
            WebElement titleVisible = chrome.findElement(By.className("page-title"));
            assertEquals(titleVisible.getText() , "Welcome, Please Sign In!");
            WebElement loginEmail = chrome.findElement(By.id("Email"));
            loginEmail.sendKeys("testing2002@testing.com");
            WebElement loginPassword = chrome.findElement(By.id("Password"));
            loginPassword.sendKeys("Testing!");
            WebElement loginUser = chrome.findElement(By.className("login-button"));
            loginUser.click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("html-home-page")));
            WebElement myAccountButton = chrome.findElement(By.className("ico-account"));
            assertEquals(myAccountButton.getText() , "My account");
            myAccountButton.click();
            WebElement changePassword = chrome.findElement(By.xpath("//a[@href='/customer/changepassword']"));
            changePassword.click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("master-wrapper-page")));
            WebElement passwordFieldsVisible = chrome.findElement(By.className("fieldset"));
            assertTrue(passwordFieldsVisible.isDisplayed());
            WebElement oldPassword = chrome.findElement(By.id("OldPassword"));
            oldPassword.sendKeys("Testing0000");
            WebElement newPassword = chrome.findElement(By.id("NewPassword"));
            newPassword.sendKeys("Testing!");
            WebElement reEnterPassword = chrome.findElement(By.id("ConfirmNewPassword"));
            reEnterPassword.sendKeys("Testing!");
            WebElement changePasswordButton = chrome.findElement(By.className("change-password-button"));
            changePasswordButton.click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("result")));
            WebElement passwordWasChange = chrome.findElement(By.className("result"));
            assertEquals(passwordWasChange.getText() , "Password was changed");

        }

        //CP7
        @Test
        public void newAddress() {

            WebElement login = chrome.findElement(By.className("ico-login"));
            login.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-button")));
            WebElement titleVisible = chrome.findElement(By.className("page-title"));
            assertEquals(titleVisible.getText() , "Welcome, Please Sign In!");
            WebElement loginEmail = chrome.findElement(By.id("Email"));
            loginEmail.sendKeys("testing2002@testing.com");
            WebElement loginPassword = chrome.findElement(By.id("Password"));
            loginPassword.sendKeys("Testing!");
            WebElement loginUser = chrome.findElement(By.className("login-button"));
            loginUser.click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("html-home-page")));
            WebElement myAccountButton = chrome.findElement(By.className("ico-account"));
            assertEquals(myAccountButton.getText() , "My account");
            myAccountButton.click();
            WebElement myAddressButton = chrome.findElement(By.xpath("//a[@href = '/customer/addresses']"));
            myAddressButton.click();
            WebElement addNewAddressButton = chrome.findElement(By.cssSelector("input[onclick ='location.href=\"/customer/addressadd\"']"));
            addNewAddressButton.click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("page-title")));
            WebElement SaveButtonAddress = chrome.findElement(By.className("save-address-button"));
            assertTrue(SaveButtonAddress.isDisplayed());
            WebElement addressFirstName = chrome.findElement(By.id("Address_FirstName"));
            addressFirstName.sendKeys("TestName1");
            WebElement addressLastName = chrome.findElement(By.id("Address_LastName"));
            addressLastName.sendKeys("TestLastName");
            WebElement addressEmail = chrome.findElement(By.id("Address_Email"));
            addressEmail.sendKeys("testing1122@testing.com");
            WebElement selectCountryComboAddress = chrome.findElement(By.id("Address_CountryId"));
            Select countrySelectAddress = new Select(selectCountryComboAddress);
            countrySelectAddress.selectByValue("1");
            WebElement selectStateComboAddress = chrome.findElement(By.id("Address_StateProvinceId"));
            Select stateComboAddress = new Select(selectStateComboAddress);
            stateComboAddress.selectByValue("62");
            WebElement cityAddress = chrome.findElement(By.id("Address_City"));
            cityAddress.sendKeys("City");
            WebElement newAddress = chrome.findElement(By.id("Address_Address1"));
            newAddress.sendKeys("TestingAddress 1234 apto 100");
            WebElement zipCodeAddress = chrome.findElement(By.id("Address_ZipPostalCode"));
            zipCodeAddress.sendKeys("12345");
            WebElement phoneNumberAddress = chrome.findElement(By.id("Address_PhoneNumber"));
            phoneNumberAddress.sendKeys("123456");
            WebElement saveNewAddressButton = chrome.findElement(By.className("save-address-button"));
            saveNewAddressButton.click();

        }

        @AfterMethod
        public void tearDown()
        {
            //chrome.quit();


        }

    }



