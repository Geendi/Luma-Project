package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.ExcelReader;
import utilities.LoadProperties;

import java.time.Duration;

public class LoginTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;


    String loginMsg = LoadProperties.data.getProperty("loginMsg");
    String forgotPwMsg = LoadProperties.data.getProperty("forgotPwMsg");
    String forgotPwCompleteMsg = LoadProperties.data.getProperty("forgotPwCompleteMsg");

    @Test(dataProviderClass = ExcelReader.class, dataProvider = "ExcelData")
    public void loginWithRegisteredAcc(String firstName, String email, String password){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage.navigateToLoginPage();
        Assert.assertTrue(loginPage.assertLoginPage().contains(loginMsg));
        loginPage.enterLoginData(email, password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(loginPage.assertLoggedIn().contains(firstName));
        registrationPage.logOut();
    }

    @Test(priority = 1,dataProviderClass = ExcelReader.class, dataProvider = "ExcelData")
    public void useForgotPassword(String email){
        homePage.navigateToLoginPage();
        loginPage.openForgotPassword();
        Assert.assertTrue(loginPage.assertForgotPage().contains(forgotPwMsg));
        loginPage.forgotPassword(email);
        Assert.assertTrue(loginPage.assertCompleteForgotProcess().contains(forgotPwCompleteMsg));
    }
}
