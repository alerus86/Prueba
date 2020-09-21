import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObject.CategoriasPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriverWait wait;
    protected WebDriver chrome;
    protected ChromeOptions chromeOptions;
    protected SoftAssert softAssert;
    protected CategoriasPage categorias;

    @BeforeSuite(alwaysRun = true)
    @Parameters("browser")
    public void setupSuite(String browser){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chrome = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(chrome, 10);
        categorias = new CategoriasPage(chrome);


    }


    @BeforeMethod (alwaysRun = true)
    public void setupTest(){

        chrome.get("https://www.mercadolibre.com.ar/");
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
    }



    @AfterSuite(alwaysRun = true)
    public void flush()
    {
        chrome.quit();

    }

}
