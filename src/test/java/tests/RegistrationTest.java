package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import utilities.ExcelReader;
import utilities.LoadProperties;

public class RegistrationTest extends TestBase{
    HomePage homePage;
    RegistrationPage registrationPage;

    String registrationMsg = LoadProperties.data.getProperty("registrationMsg");
    String loggedInMsg = LoadProperties.data.getProperty("loggedInMsg");
    String logOutMsg = LoadProperties.data.getProperty("logOutMsg");


    @Test(dataProviderClass = ExcelReader.class, dataProvider = "ExcelData")
    public void registerNewUser(String firstName, String lastName, String email, String password){
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage.navigateToRegisterPage();
        Assert.assertEquals(registrationPage.assertRegisterPage(), registrationMsg);
        registrationPage.enterRegisterData(firstName,lastName,email, password, password);
        Assert.assertTrue(registrationPage.assertCompleteRegistration().contains(loggedInMsg));
        registrationPage.logOut();
        Assert.assertTrue(registrationPage.assertSignOut().contains(logOutMsg));
    }
}
