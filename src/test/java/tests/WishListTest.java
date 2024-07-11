package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ExcelReader;
import utilities.LoadProperties;

public class WishListTest extends TestBase{
    WishlistPage wishlistPage;
    LoginPage loginPage;
    SearchPage searchPage;
    HomePage homePage;

    String product = LoadProperties.data.getProperty("product");
    String productTwo = LoadProperties.data.getProperty("productTwo");
    String addedWish = LoadProperties.data.getProperty("addedWish");
    String removedWish = LoadProperties.data.getProperty("removedWish");
    String emptyWish = LoadProperties.data.getProperty("emptyWish");
    String wishPageMsg = LoadProperties.data.getProperty("wishPageMsg");
    String email = LoadProperties.data.getProperty("email");
    String password = LoadProperties.data.getProperty("password");


    @Test(dataProviderClass = ExcelReader.class, dataProvider = "ExcelData")
    public void loginForWishList(String email, String password){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.navigateToLoginPage();
        loginPage.enterLoginData(email, password);
    }

    @Test(priority = 1)
    public void addToWishList(){
        wishlistPage = new WishlistPage(driver);
        searchPage = new SearchPage(driver);
        searchPage.productSearch(product);
        searchPage.openProductDetails(By.linkText(product));
        wishlistPage.addToWishList();
        Assert.assertEquals(wishlistPage.assertWishListPage(), wishPageMsg);
        Assert.assertTrue(wishlistPage.assertAdded().contains(addedWish));
        wishlistPage.continueShopping();
        searchPage.productSearch(productTwo);
        searchPage.openProductDetails(By.linkText(productTwo));
        wishlistPage.addToWishList();
    }

    @Test(priority = 2)
    public void editWishList(){
        wishlistPage.removeItem(By.linkText(product));
        Assert.assertTrue(wishlistPage.assertRemoveItem().contains(removedWish));
        wishlistPage.removeItem(By.linkText(productTwo));
        Assert.assertTrue(wishlistPage.assertEmptyList().contains(emptyWish));
    }
}
