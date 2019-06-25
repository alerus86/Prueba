import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.*;

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
        /*WebElement gender;
        WebElement firstName;
        WebElement lastName;
        Select dayOfBirth;
        Select monthOfBirth;
        Select yearOfBirth;
        WebElement email;
        WebElement password;
        WebElement confirmPassword;
        WebElement registerUserButton;*/


        private WebDriverWait wait;
        private WebDriver chrome;
        private ChromeOptions chromeOptions;
        private SoftAssert softAssert;
        private RegisterUserPage addUser;
        private HomePage homePage;
        private LoginUser loginNewUser;
        private ResultProductPage resultProductPage;
        private ProductSelectionPage productSelection;
        private ItemSelectedResult itemSelected;
        private ShoppingCartPage shoppingCart;
        private CheckoutPage checkoutPage;
        private SearchAndResultPage searchAndResultPage;
        private CompareProductPage compareProductPage;

        @BeforeMethod
        public void setupTest(){


            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            chrome = new ChromeDriver(chromeOptions);
            wait = new WebDriverWait(chrome, 10);
            addUser = new RegisterUserPage(chrome);
            homePage = new HomePage(chrome);
            chrome.get("http://demo.nopcommerce.com/");
            chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            softAssert = new SoftAssert();
        }


        //CP1
        @Test
        public void nuevoUsuarioRegistrado () {

            addUser = homePage.register();
            assertTrue(homePage.pageTitleIsDiplayed());
            addUser.registerUser("Test" , "Testing" , "14" , "7" , "1986" , "testing2004@test.com" ,
                    "Test1234" , "Test1234");
            assertTrue(addUser.messageSuccessIsDisplayed());

        }

        //CP2
        @Test
        public void checkOutConEfectivo() {

            loginNewUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginNewUser.loginUser("testing2002@testing.com" , "Testing!");
            resultProductPage = homePage.results();
            resultProductPage.SelectCellPhone();
            productSelection = homePage.productSelected();
            productSelection.CellPhoneSelection();
            itemSelected = homePage.itemSelected();
            itemSelected.NokiCellPhone();
            shoppingCart = homePage.shoppingCartPage();
            shoppingCart.CheckoutProduct();
            checkoutPage = homePage.checkoutPage();
            checkoutPage.checkoutProduct("235" , "Test" , "Testing apto 001" , "12345" , "12345678");
            assertTrue(checkoutPage.orderConfirmationSuccess());

        }

        //CP3
        @Test
        public void checkOutConTarjetaDeCredito () {

            loginNewUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginNewUser.loginUser("testing2002@testing.com" , "Testing!");
            resultProductPage = homePage.results();
            resultProductPage.SelectCellPhone();
            productSelection = homePage.productSelected();
            productSelection.CellPhoneSelection();
            itemSelected = homePage.itemSelected();
            itemSelected.NokiCellPhone();
            shoppingCart = homePage.shoppingCartPage();
            shoppingCart.CheckoutProduct();
            checkoutPage = homePage.checkoutPage();
            checkoutPage.checkoutProductCreditCard("235" , "Test" , "Testing apto 001" , "12345" , "12345678" ,
                    "Testing Tester" , "0000000000000000" , "12" , "2022" , "1234");
            assertTrue(checkoutPage.orderConfirmationSuccess());


        }

        //CP4
        @Test
        public void agregarWishlist (){


            loginNewUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginNewUser.loginUser("testing2002@testing.com" , "Testing!");
            searchAndResultPage = homePage.searchAndResultPage();
            searchAndResultPage.searchProduct("ring");
            assertTrue(searchAndResultPage.resultsProductsDisplayed());
            productSelection = homePage.productSelected();
            productSelection.ProductAddToWishlist();

        }

        //CP5
        @Test
        public void compareProducts () {


            loginNewUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginNewUser.loginUser("testing2002@testing.com" , "Testing!");
            searchAndResultPage = homePage.searchAndResultPage();
            searchAndResultPage.searchProduct("ring");
            assertTrue(searchAndResultPage.resultsProductsDisplayed());
            productSelection = homePage.productSelected();
            productSelection.ProductCompareList();
            compareProductPage = homePage.compareProductPage();
            assertTrue(compareProductPage.clearListButton());
        }

        //CP6
        @Test
        public void changePassword() {


            loginNewUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginNewUser.loginUser("testing2002@testing.com" , "Testing!");
            /*WebElement login = chrome.findElement(By.className("ico-login"));
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
            assertEquals(passwordWasChange.getText() , "Password was changed");*/

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
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("page-title")));
            WebElement newAddressAdded = chrome.findElement(By.className("name"));
            assertEquals(newAddressAdded.getText() , "TestName1 TestLastName");

        }

        //CP8
        @Test
        public void removeItemFromCart (){

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
            WebElement clickProduct2 = chrome.findElement(By.xpath("//a[@href='/books']"));
            clickProduct2.click();
            WebElement selectBook = chrome.findElement(By.xpath("//a[@href='/fahrenheit-451-by-ray-bradbury']"));
            selectBook.click();
            WebElement addToCart2 = chrome.findElement(By.cssSelector("input[onclick = 'return AjaxCart.addproducttocart_details(\"/addproducttocart/details/37/1\",\"#product-details-form\"),!1']"));
            addToCart2.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
            WebElement alertSuccess2 = chrome.findElement(By.id("bar-notification"));
            assertEquals(alertSuccess2.getText(), "The product has been added to your shopping cart");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification-container")));
            WebElement shoppingCart = chrome.findElement(By.className("ico-cart"));
            shoppingCart.click();
            WebElement productRow = chrome.findElement(By.xpath("//a[contains(text(),'Nokia')]/parent::td/parent::tr"));
            WebElement checkSelected = productRow.findElement(By.cssSelector("[type='checkbox']"));
            checkSelected.click();
            WebElement productRow2 = chrome.findElement(By.xpath("//a[contains(text(),'Fahrenheit')]/parent::td/parent::tr"));
            WebElement checkSelected2 = productRow2.findElement(By.cssSelector("[type='checkbox']"));
            checkSelected2.click();
            WebElement updateCart = chrome.findElement(By.className("update-cart-button"));
            updateCart.click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("page-title")));
            WebElement shoppingCartTitle = chrome.findElement(By.className("no-data"));
            assertEquals(shoppingCartTitle.getText() , "Your Shopping Cart is empty!");
        }

        //CP9
        @Test
        public void reviewProduct (){

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
            WebElement clickProduct = chrome.findElement(By.xpath("//a[@href='/electronics']"));
            clickProduct.click();
            WebElement clickCamera = chrome.findElement(By.linkText("Camera & photo"));
            clickCamera.click();
            WebElement selectedProduct = chrome.findElement(By.linkText("Nikon D5500 DSLR"));
            selectedProduct.click();
            WebElement addReview = chrome.findElement(By.linkText("Add your review"));
            addReview.click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("page-title")));
            WebElement reviewTitle = chrome.findElement(By.id("AddProductReview_Title"));
            reviewTitle.sendKeys("Testing title review");
            WebElement reviewTextBox = chrome.findElement(By.id("AddProductReview_ReviewText"));
            reviewTextBox.sendKeys("Testing a review for the selected product");
            WebElement ratingRadioButton = chrome.findElement(By.id("addproductrating_4"));
            ratingRadioButton.click();
            WebElement submitReview = chrome.findElement(By.className("write-product-review-button"));
            submitReview.click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("page-title")));
            WebElement reviewSuccessfully = chrome.findElement(By.className("result"));
            assertEquals(reviewSuccessfully.getText() , "Product review is successfully added.");

        }

        //CP10
        @Test
        public void sendProductEmailToFriend() {

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
            WebElement selectedCellPhone = chrome.findElement(By.linkText("HTC One M8 Android L 5.0 Lollipop"));
            selectedCellPhone.click();
            WebElement emailAFriend = chrome.findElement(By.className("email-a-friend-button"));
            emailAFriend.click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='/htc-one-m8-android-l-50-lollipop']")));
            WebElement friendEmail = chrome.findElement(By.id("FriendEmail"));
            friendEmail.sendKeys("emailfriend@test.com");
            WebElement yourEmailDisplayed = chrome.findElement(By.className("your-email"));
            assertTrue(yourEmailDisplayed.isDisplayed());
            WebElement personalMessage = chrome.findElement(By.id("PersonalMessage"));
            personalMessage.sendKeys("Just a testing message for email product to a friend");
            WebElement sendEmailButton = chrome.findElement(By.className("send-email-a-friend-button"));
            sendEmailButton.click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("page-title")));
            WebElement emailSuccessfullySent = chrome.findElement(By.className("result"));
            assertEquals(emailSuccessfullySent.getText() , "Your message has been sent.");
        }

        @AfterMethod
        public void tearDown()
        {
            //chrome.quit();
        }

    }



