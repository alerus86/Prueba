import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        public void checkOutConEfectivo(){
                
        }



    @AfterMethod
    public void tearDown()    {
        chrome.quit();
        }

    }



