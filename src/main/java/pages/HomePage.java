package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends PageBase{

    //ToDo add driver
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    //ToDo adding locators
    //--------------------------------------------------------------------------------
    private final By signInButton = By.linkText("Sign In");
    private final By registerButton = By.linkText("Create an Account");
    private final By compareList = By.partialLinkText("Compare Products");
    //--------------------------------------------------------------------------------
    //ToDo adding methods
    public void navigateToRegisterPage(){
        click(driver, registerButton);
    }

    public void navigateToLoginPage(){
        click(driver, signInButton);
    }

    public void navigateToComparePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(compareList));
        click(driver, compareList);
    }
}
