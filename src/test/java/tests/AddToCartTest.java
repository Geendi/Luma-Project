package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.SearchPage;
import utilities.LoadProperties;

public class AddToCartTest extends TestBase{
    AddToCartPage addToCartPage;
    SearchPage searchPage;

    String product = LoadProperties.data.getProperty("product");
    String productTwo = LoadProperties.data.getProperty("productTwo");
    String addedCart = LoadProperties.data.getProperty("addedCart");
    String cartPage = LoadProperties.data.getProperty("cartPage");

    @Test
    public void addProductsToCart(){
        addToCartPage = new AddToCartPage(driver);
        searchPage = new SearchPage(driver);
        searchPage.productSearch(product);
        searchPage.openProductDetails(By.linkText(product));
        addToCartPage.chooseSpecifics(true);
        addToCartPage.addItemToCart();
        Assert.assertTrue(addToCartPage.assertAddItemToCart().contains(addedCart));
        searchPage.productSearch(productTwo);
        searchPage.openProductDetails(By.linkText(productTwo));
        addToCartPage.chooseSpecifics(false);
        addToCartPage.addItemToCart();
        addToCartPage.navigateToCart();
        Assert.assertTrue(addToCartPage.assertShoppingPage().contains(cartPage));
        addToCartPage.removeItemFromCart();
    }
}
