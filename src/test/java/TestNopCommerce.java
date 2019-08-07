import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObject.*;
import sun.awt.OSInfo;
import utils.SeleniumUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class TestNopCommerce
    {

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
        private LogoutUser logoutSomeUser;
        protected static ExtentHtmlReporter extentHtmlReporter;
        protected static ExtentReports extentReports;
        protected static ExtentTest extentTest;


        @BeforeSuite(alwaysRun = true)
        @Parameters("browser")
        public void setupSuite(String browser){

            setupReports();
        }

        public void setupReports(){
            extentHtmlReporter = new ExtentHtmlReporter("reports/reporte.html");
            extentHtmlReporter.config().setDocumentTitle("Reports");
            extentHtmlReporter.config().setReportName("Obligatorio - NopCommerce ");
            extentHtmlReporter.config().setTheme(Theme.DARK);

            extentReports = new ExtentReports();
            extentReports.attachReporter(extentHtmlReporter);

            extentReports.setSystemInfo("Ambiente", "Testing");
            extentReports.setSystemInfo("Hostname", "nopcommerce");
            extentReports.setSystemInfo("Sistema Operativo", OSInfo.getOSType().name());
        }


        @BeforeMethod (alwaysRun = true)
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
        public void nuevoUsuarioRegistrado (Method method) {

            extentTest = extentReports.createTest(method.getName());
            addUser = homePage.register();
            assertTrue(homePage.pageTitleIsDiplayed());
            addUser.registerUser("Test" , "Testing" , "14" , "7" , "1986" , "testing1900@test.com" ,
                    "Test1234" , "Test1234");
            assertTrue(addUser.messageSuccessIsDisplayed());
            //logoutSomeUser = homePage.logoutUser();
            logoutSomeUser.logoutUser();


        }

        //CP2
        @Test
        public void checkOutConEfectivo(Method method) {

            extentTest = extentReports.createTest(method.getName());
            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            resultProductPage = homePage.results();
            resultProductPage.SelectCellPhone();
            assertTrue(resultProductPage.ResultProductPageTitleDisplayed());
            productSelection = homePage.productSelected();
            assertTrue(productSelection.ProductSelectionPageDisplayed());
            productSelection.CellPhoneSelectionNokia();
            itemSelected = homePage.itemSelected();
            assertTrue(itemSelected.ProductSelectedTitle());
            itemSelected.NokiCellPhone();
            shoppingCart = homePage.shoppingCartPage();
            assertTrue(shoppingCart.ShoppingCartTitleDisplayed());
            shoppingCart.CheckoutProduct();
            checkoutPage = homePage.checkoutPage();
            assertTrue(shoppingCart.ShoppingCartTitleDisplayed());
            checkoutPage.checkoutProduct("235" , "Test" , "Testing apto 001" , "12345" , "12345678");
            assertTrue(checkoutPage.OrderConfirmationSuccess());
            logoutSomeUser = homePage.logoutUser();


        }

        //CP3
        @Test
        public void checkOutConTarjetaDeCredito (Method method) {

            extentTest = extentReports.createTest(method.getName());
            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com", "Testing$");
            resultProductPage = homePage.results();
            resultProductPage.SelectBook();
            assertTrue(resultProductPage.ResultProductPageTitleDisplayed());
            itemSelected = homePage.itemSelected();
            assertTrue(itemSelected.ProductItemTitle());
            itemSelected.FahrenheitBook();
            shoppingCart = homePage.shoppingCartPage();
            shoppingCart.CheckoutProduct();
            checkoutPage = homePage.checkoutPage();
            assertTrue(shoppingCart.ShoppingCartTitleDisplayed());
            checkoutPage.checkoutProductCreditCard("235" , "Test" , "Testing apto 001" , "12345" , "12345678" ,
                    "Testing Tester" , "0000000000000000" , "12" , "2022" , "1234");
            assertTrue(checkoutPage.OrderConfirmationSuccess());
            logoutSomeUser = homePage.logoutUser();


        }

        //CP4
        @Test(dataProvider = "AddToWishlist" , dataProviderClass = DataProviderClass.class)
        public void agregarWishlist (String userMail , String userPassword , String productSearch , Method method){

            extentTest = extentReports.createTest(method.getName());
            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser(userMail , userPassword);
            searchAndResultPage = homePage.searchAndResultPage();
            searchAndResultPage.searchProduct(productSearch);
            assertTrue(searchAndResultPage.ResultsProductsDisplayed());
            productSelection = homePage.productSelected();
            assertTrue(searchAndResultPage.SearchTitleDisplayed());
            productSelection.SelectedProductDataProvider(productSearch);
            assertTrue(productSelection.WishlistItemTitleDisplayed());
            logoutSomeUser = homePage.logoutUser();
        }

        //CP5
        @Test
        public void compareProducts (Method method) {

            extentTest = extentReports.createTest(method.getName());
            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            searchAndResultPage = homePage.searchAndResultPage();
            searchAndResultPage.searchProduct("ring");
            assertTrue(searchAndResultPage.ResultsProductsDisplayed());
            productSelection = homePage.productSelected();
            assertTrue(productSelection.ProductSelectionPageDisplayed());
            productSelection.ProductCompareList();
            compareProductPage = homePage.compareProductPage();
            assertTrue(compareProductPage.clearListButton());
            logoutSomeUser = homePage.logoutUser();
        }

        //CP6
        @Test
        public void changePasswordUser(Method method) {

            extentTest = extentReports.createTest(method.getName());
            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            myAccountPage = homePage.myAccountPage();
            assertTrue(myAccountPage.MyAccountPageTitleDisplayed());
            myAccountPage.changePassword("Testing#" , "Testing$" , "Testing$");
            logoutSomeUser = homePage.logoutUser();

        }

        //CP7
        @Test
        public void newAddress(Method method) {

            extentTest = extentReports.createTest(method.getName());
            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            myAccountPage = homePage.myAccountPage();
            assertTrue(myAccountPage.MyAddressPageTitleDisplayed());
            myAccountPage.addNewAddress("Test1" , "Testing1" ,
                    "testing2019@testing.com" , "1" ,
                    "62" , "City" , "Testing 1212 block 2" ,
                    "12345" , "1234567");
            logoutSomeUser = homePage.logoutUser();

        }

        //CP8
        @Test
        public void removeItemFromCart (Method method){

            extentTest = extentReports.createTest(method.getName());
            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            resultProductPage = homePage.results();
            resultProductPage.SelectCellPhone();
            assertTrue(resultProductPage.ResultProductPageTitleDisplayed());
            productSelection = homePage.productSelected();
            productSelection.CellPhoneSelectionNokia();
            itemSelected = homePage.itemSelected();
            assertTrue(itemSelected.ProductItemTitle());
            itemSelected.NokiCellPhone();
            resultProductPage.SelectBook();
            assertTrue(resultProductPage.ResultProductPageTitleDisplayed());
            assertTrue(itemSelected.ProductItemTitle());
            itemSelected.FahrenheitBook();
            checkoutPage = homePage.checkoutPage();
            assertTrue(checkoutPage.ShoppingCartTitleDisplayed());
            checkoutPage.deleteCheckoutProduct();
            logoutSomeUser = homePage.logoutUser();
        }

        //CP9
        @Test
        public void reviewProduct (Method method){

            extentTest = extentReports.createTest(method.getName());
            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            resultProductPage = homePage.results();
            resultProductPage.SelectCameraAndPhoto();
            assertTrue(resultProductPage.ResultProductPageTitleDisplayed());
            productSelection = homePage.productSelected();
            assertTrue(productSelection.ProductSelectionPageDisplayed());
            productSelection.SelectedCamera();
            itemSelected = homePage.itemSelected();
            assertTrue(itemSelected.ProductTitleName());
            itemSelected.NikonCamera();
            reviewSelectedProduct = homePage.reviewSelectedProduct();
            assertTrue(reviewSelectedProduct.ReviewProductTitle());
            reviewSelectedProduct.reviewSelectedProduct("Testing Title Review" , "Just a simple review of a selected product");
            logoutSomeUser = homePage.logoutUser();

        }

        //CP10
        @Test
        public void sendProductEmailToFriend(Method method) {

            extentTest = extentReports.createTest(method.getName());
            loginSomeUser = homePage.login();
            assertTrue(homePage.loginTitleIsDisplayed());
            loginSomeUser.loginUser("testing2002@testing.com" , "Testing$");
            resultProductPage = homePage.results();
            resultProductPage.SelectCellPhone();
            assertTrue(resultProductPage.ResultProductPageTitleDisplayed());
            productSelection = homePage.productSelected();
            assertTrue(productSelection.ProductSelectionPageDisplayed());
            productSelection.CellPhoneSelectionHTC();
            itemSelected = homePage.itemSelected();
            assertTrue(itemSelected.ProductTitleName());
            itemSelected.HTCOneMini();
            emailAFriendPage = homePage.emailAFriendPage();
            emailAFriendPage.EmailAFriend("test987@test.com" , "Just a message for testing");
            logoutSomeUser = homePage.logoutUser();
            
        }

        @AfterMethod(alwaysRun = true)
        public void teardownTest(final ITestResult result) throws IOException {
            softAssert.assertAll();
            if (result.getStatus() == ITestResult.FAILURE) {
                extentTest.log(Status.FAIL,
                        "Test Case " + result.getName() + " failed");
                extentTest.log(Status.FAIL,
                        "Caused: " + result.getThrowable());
                String screenShoot = SeleniumUtils.takeScreenShot(chrome);
                extentTest.log(Status.FAIL, "Image: ");
                extentTest.addScreenCaptureFromPath(screenShoot);
            } else if (result.getStatus() == ITestResult.SKIP) {
                extentTest.log(Status.SKIP,
                        "Test Case " + result.getName() + " skipped");
                extentTest.log(Status.SKIP,
                        "Caused: " + result.getThrowable());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                extentTest.log(Status.PASS,
                        "Test Case " + result.getName() + " passed");
            }

        }
        @AfterSuite(alwaysRun = true)
        public void flush()
        {
            extentReports.flush();
            //chrome.quit();
        }

    }



