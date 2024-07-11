package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import utilities.LoadProperties;

public class SearchTest extends TestBase{
    SearchPage searchPage;

    String product = LoadProperties.data.getProperty("product");

    @Test
    public void searchForProduct(){
        searchPage = new SearchPage(driver);
        searchPage.productSearch(product);
        Assert.assertTrue(searchPage.assertResults().contains(product));
        searchPage.openProductDetails(By.linkText(product));
    }

    @Test(priority = 1)
    public void searchUsingAutoSuggest(){
        searchPage.productSearchUsingAutoSuggest(product);
        Assert.assertTrue(searchPage.assertResults().contains(product));
        searchPage.openProductDetails(By.linkText(product));
    }
}
