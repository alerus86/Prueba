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
        private LoginUser loginSomeUser;
        private ResultProductPage resultProductPage;
        private ProductSelectionPage productSelection;
        private ItemSelectedResult itemSelected;
        private ShoppingCartPage shoppingCart;
        private CheckoutPage checkoutPage;
        private SearchAndResultPage searchAndResultPage;
        private CompareProductPage compareProductPage;
        private MyAccountPage myAccountPage;
        private ReviewSelectedProductPage reviewSelectedProduct;
        private EmailAFriendPage emailAFriendPage;


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

            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            resultProductPage = homePage.results();
            resultProductPage.SelectCellPhone();
            productSelection = homePage.productSelected();
            productSelection.CellPhoneSelectionNokia();
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

            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            resultProductPage = homePage.results();
            resultProductPage.SelectCellPhone();
            productSelection = homePage.productSelected();
            productSelection.CellPhoneSelectionNokia();
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


            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            searchAndResultPage = homePage.searchAndResultPage();
            searchAndResultPage.searchProduct("ring");
            assertTrue(searchAndResultPage.resultsProductsDisplayed());
            productSelection = homePage.productSelected();
            productSelection.ProductAddToWishlist();

        }

        //CP5
        @Test
        public void compareProducts () {


            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
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
        public void changePasswordUser() {


            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            myAccountPage = homePage.myAccountPage();
            myAccountPage.changePassword("Testing#" , "Testing$" , "Testing$");


        }

        //CP7
        @Test
        public void newAddress() {


            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            myAccountPage = homePage.myAccountPage();
            myAccountPage.addNewAddress("Test1" , "Testing1" ,
                    "testing2019@testing.com" , "1" ,
                    "62" , "City" , "Testing 1212 block 2" ,
                    "12345" , "1234567");

        }

        //CP8
        @Test
        public void removeItemFromCart (){

            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            resultProductPage = homePage.results();
            resultProductPage.SelectCellPhone();
            productSelection = homePage.productSelected();
            productSelection.CellPhoneSelectionNokia();
            itemSelected = homePage.itemSelected();
            itemSelected.NokiCellPhone();
            resultProductPage.SelectBook();
            productSelection.BookSelection();
            itemSelected.FahrenheitBook();
            checkoutPage = homePage.checkoutPage();
            checkoutPage.deleteCheckoutProduct();
        }

        //CP9
        @Test
        public void reviewProduct (){

            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            resultProductPage = homePage.results();
            resultProductPage.SelectCameraAndPhoto();
            productSelection = homePage.productSelected();
            productSelection.SelectedCamera();
            itemSelected = homePage.itemSelected();
            itemSelected.NikonCamera();
            reviewSelectedProduct = homePage.reviewSelectedProduct();
            reviewSelectedProduct.reviewSelectedProduct("Testing Title Review" , "Just a simple review of a selected product");


        }

        //CP10
        @Test
        public void sendProductEmailToFriend() {


            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            resultProductPage = homePage.results();
            resultProductPage.SelectCellPhone();
            productSelection = homePage.productSelected();
            productSelection.CellPhoneSelectionHTC();
            itemSelected = homePage.itemSelected();
            itemSelected.HTCOneMini();
            emailAFriendPage = homePage.emailAFriendPage();
            emailAFriendPage.EmailAFriend("test987@test.com" , "Just a message for testing");

            
        }

        @AfterMethod
        public void tearDown()
        {
            //chrome.quit();
        }

    }



