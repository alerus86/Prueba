package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class ReviewSelectedProductPage extends BasePage {


    @FindBy (id = "AddProductReview_Title")
    private WebElement titleReview;
    @FindBy (id = "AddProductReview_ReviewText")
    private WebElement reviewText;
    @FindBy (id = "addproductrating_3")
    private  WebElement ratingReviewRadioButton;
    @FindBy (css = "input[value='Submit review']")
    private WebElement submitReview;
    @FindBy (className = "page-title")
    private WebElement reviewProductTitle;
    @FindBy (className = "result")
    private WebElement reviewSuccessfullyAdded;

    public void reviewSelectedProduct (String titleReview , String reviewText) {

        this.titleReview.sendKeys(titleReview);
        this.reviewText.sendKeys(reviewText);
        ratingReviewRadioButton.click();
        submitReview.click();
        assertEquals(reviewSuccessfullyAdded.getText() , "Product review is successfully added.");
    }


    public ReviewSelectedProductPage(WebDriver chrome) {
        super(chrome);
    }

    public boolean ReviewProductTitle () {

        return reviewProductTitle.isDisplayed();

    }


}
