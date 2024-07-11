package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.HomePage;
import pages.SearchPage;
import utilities.LoadProperties;

public class CompareTest extends TestBase{

    HomePage homePage;
    ComparePage comparePage;
    SearchPage searchPage;

    String product = LoadProperties.data.getProperty("product");
    String productTwo = LoadProperties.data.getProperty("productTwo");
    String comparePageMsg = LoadProperties.data.getProperty("comparePageMsg");
    String removeMsg = LoadProperties.data.getProperty("removeMsg");
    String emptyCompareMsg = LoadProperties.data.getProperty("emptyCompareMsg");


    @Test
    public void addProductsToCompare(){
        searchPage = new SearchPage(driver);
        comparePage = new ComparePage(driver);
        searchPage.productSearch(product);
        Assert.assertTrue(searchPage.assertResults().contains(product));
        searchPage.openProductDetails(By.linkText(product));
        comparePage.addProductToCompare();
        searchPage.productSearch(productTwo);
        Assert.assertTrue(searchPage.assertResults().contains(productTwo));
        searchPage.openSecondProductDetails();
        comparePage.addProductToCompare();
    }

    @Test(priority = 1)
    public void compareProducts(){
        homePage = new HomePage(driver);
        homePage.navigateToComparePage();
        Assert.assertTrue(comparePage.assertComparePage().contains(comparePageMsg));
        comparePage.compareProducts();
        homePage.printOrder();
    }

    @Test(priority = 2,enabled = false)
    public void clearCompareList(){
        comparePage.removeProductFromCompare();
        Assert.assertTrue(comparePage.assertRemoveConfirmation().contains(removeMsg));
        comparePage.removeProductFromCompare();
        Assert.assertTrue(comparePage.assertEmptyList().contains(emptyCompareMsg));
    }
}
