import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObject.*;
import sun.awt.OSInfo;
import utils.SeleniumUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriverWait wait;
    protected WebDriver chrome;
    protected ChromeOptions chromeOptions;
    protected SoftAssert softAssert;
    protected RegisterUserPage addUser;
    protected HomePage homePage;
    protected LoginUser loginSomeUser;
    protected ResultProductPage resultProductPage;
    protected ProductSelectionPage productSelection;
    protected ItemSelectedResult itemSelected;
    protected ShoppingCartPage shoppingCart;
    protected CheckoutPage checkoutPage;
    protected SearchAndResultPage searchAndResultPage;
    protected CompareProductPage compareProductPage;
    protected MyAccountPage myAccountPage;
    protected ReviewSelectedProductPage reviewSelectedProduct;
    protected EmailAFriendPage emailAFriendPage;
    protected LogoutUser logoutSomeUser;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;

    @BeforeSuite(alwaysRun = true)
    @Parameters("browser")
    public void setupSuite(String browser){

        setupReports();
    }

    public void setupReports(){
        extentHtmlReporter = new ExtentHtmlReporter("reports/reports.html");
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
        chrome.quit();

    }
    @AfterSuite(alwaysRun = true)
    public void flush()
    {
        extentReports.flush();

    }

}
