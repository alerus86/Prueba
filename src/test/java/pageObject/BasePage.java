package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver chrome;
    protected WebDriverWait wait;

    public BasePage(WebDriver chrome){
        this.chrome = chrome;
        wait = new WebDriverWait(chrome, 10);
        PageFactory.initElements(chrome , this);
    }

}
