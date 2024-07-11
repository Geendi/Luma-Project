package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddReviewPage;
import pages.SearchPage;
import utilities.LoadProperties;

public class AddReviewTest extends TestBase{
    AddReviewPage addReviewPage;
    SearchPage searchPage;

    String product = LoadProperties.data.getProperty("product");
    String reviewPage = LoadProperties.data.getProperty("reviewPage");
    String nickName = LoadProperties.data.getProperty("nickName");
    String summary = LoadProperties.data.getProperty("summary");
    String review = LoadProperties.data.getProperty("review");
    String addedReview = LoadProperties.data.getProperty("addedReview");

    @Test
    public void searchProductForReview(){
        searchPage = new SearchPage(driver);
        searchPage.productSearch(product);
        searchPage.openProductDetails(By.linkText(product));
    }

    @Test(priority = 1)
    public void addReviews(){
        addReviewPage = new AddReviewPage(driver);
        addReviewPage.navigateToReview();
        Assert.assertTrue(addReviewPage.assertReviewPage().contains(reviewPage));
        addReviewPage.addReview(nickName, summary, review);
        Assert.assertTrue(addReviewPage.assertAddedReview().contains(addedReview));
    }
}
