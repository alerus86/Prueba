import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


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


        @BeforeClass
        public void setup ()
        {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");

        }

        @BeforeMethod
        public void setupTest(){

            chrome = new ChromeDriver(chromeOptions);
            wait = new WebDriverWait(chrome, 10);
            chrome.get("http://demo.nopcommerce.com/");
            chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

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
            loginPassword.sendKeys("Testing1234");
            WebElement loginUser = chrome.findElement(By.className("login-button"));
            loginUser.click();
            WebElement clickProduct = chrome.findElement(By.xpath("//a[@href='/electronics']"));
            clickProduct.click();
            WebElement clickCellPhone = chrome.findElement(By.xpath("/html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/a"));
            clickCellPhone.click();
            WebElement selectedCellPhone = chrome.findElement(By.xpath("/html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[3]/div/div[2]/h2/a"));
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

//        @AfterMethod
//        public void tearDown()
//        {
//        chrome.quit();
//        }

    }



