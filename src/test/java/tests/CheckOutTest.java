package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ExcelReader;
import utilities.LoadProperties;

public class CheckOutTest extends TestBase{
    CheckOutPage checkOutPage;
    AddToCartPage addToCartPage;
    SearchPage searchPage;
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    String product = LoadProperties.data.getProperty("product");
    String street = LoadProperties.data.getProperty("street");
    String state = LoadProperties.data.getProperty("state");
    String city = LoadProperties.data.getProperty("city");
    String zip = LoadProperties.data.getProperty("zip");
    String phone = LoadProperties.data.getProperty("phone");
    String shippingPage = LoadProperties.data.getProperty("shippingPage");


    @Test(dataProviderClass = ExcelReader.class, dataProvider = "ExcelData")
    public void loginForCheckOut(String email, String password){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.navigateToLoginPage();
        loginPage.enterLoginData(email, password);
    }


    @Test(priority = 1)
    public void addProductToCart(){
        addToCartPage = new AddToCartPage(driver);
        searchPage = new SearchPage(driver);
        searchPage.productSearch(product);
        searchPage.openProductDetails(By.linkText(product));
        addToCartPage.chooseSpecifics(true);
        addToCartPage.addItemToCart();
        addToCartPage.navigateToCart();
    }

    @Test(priority = 2)
    public void checkOut(){
        registrationPage = new RegistrationPage(driver);
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.navigateToCheckOutPage();
        Assert.assertTrue(checkOutPage.assertShippingAndPaymentPages().contains(shippingPage));
        checkOutPage.enterShippingData(street, city, state, zip, phone);
        checkOutPage.placeOrder();
        checkOutPage.continueShopping();
    }

    @Test(priority = 3)
    public void trackOrder(){
        checkOutPage.navigateToMyAccount();
        checkOutPage.openOrdersPage();
        checkOutPage.viewOrder();
        Assert.assertTrue(checkOutPage.assertProductName().contains(product));
        registrationPage.logOut();
    }
}
