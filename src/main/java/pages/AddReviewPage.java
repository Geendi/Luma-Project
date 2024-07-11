package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AddReviewPage extends PageBase{
    //ToDo add driver
    WebDriver driver;

    public AddReviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        action = new Actions(driver);
    }

    //ToDo adding locators
    //--------------------------------------------------------------------------------
    private final By reviewButton = By.id("tab-label-reviews-title");
    private final By ratingStars = By.cssSelector("label#Rating_5_label");
    private final By nickNameText = By.id("nickname_field");
    private final By summaryText = By.id("summary_field");
    private final By reviewText = By.id("review_field");
    private final By submitButton = By.cssSelector("button.action.submit.primary");
    private final By reviewPage = By.cssSelector("legend.legend.review-legend");
    private final By addedReview = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    //--------------------------------------------------------------------------------
    //ToDo adding methods
    public String assertReviewPage(){
        return driver.findElement(reviewPage).getText();
    }

    public String assertAddedReview(){
        return driver.findElement(addedReview).getText();
    }

    public void navigateToReview(){
        click(driver, reviewButton);
    }

    public void addReview(String nickName, String summary, String review){
        action.moveToElement(driver.findElement(ratingStars)).click().build().perform();
        setText(driver, nickNameText, nickName);
        setText(driver, summaryText, summary);
        setText(driver, reviewText, review);
        click(driver, submitButton);
    }
}
