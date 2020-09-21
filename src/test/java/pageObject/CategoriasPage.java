package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class CategoriasPage extends BasePage {

    @FindBy(xpath = "//a[@class='nav-menu-categories-link']")
    private WebElement categorias;
    @FindBy(xpath = "//a[contains(text(),'Tecnología')]")
    private WebElement categoriaTecnologia;
    @FindBy(xpath = "//a[contains(text(),'TVs')]")
    private WebElement televisores;
    @FindBy(xpath = "//button[@class='andes-dropdown__trigger']")
    private WebElement ordenar;
    @FindBy (xpath = "//a[contains(text(),'Menor precio')]")
    private WebElement menorPrecio;
    @FindBy (xpath = "//h2[contains(text(),'TV Noblex EE24X4000')]")
    private WebElement articuloMenorPrecio;
    @FindBy (xpath = "//div[@class='ui-pdp-price mt-16 ui-pdp-price--size-large']//span[@class='price-tag-fraction'][contains(text(),'19.999')]")
    private WebElement menorPrecioTV;

    public void SeleccionCategoria() {

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[@class='nav-menu-categories-link']"))));
        categorias.click();
        categoriaTecnologia.click();
        televisores.click();

    }

    public void OrdenarPorMenorPrecio()

    {
        ordenar.click();
        menorPrecio.click();
        articuloMenorPrecio.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='ui-pdp-price mt-16 ui-pdp-price--size-large']//span[@class='price-tag-fraction'][contains(text(),'19.999')]"))));
        //Assert.assertEquals(menorPrecioTV.getText() , "19.999");

    }



    public CategoriasPage(WebDriver chrome) {
        super(chrome);
    }
}
