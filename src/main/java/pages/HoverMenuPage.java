package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HoverMenuPage extends PageBase{
    //ToDo add driver
    WebDriver driver;

    public HoverMenuPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //ToDo adding locators
    //--------------------------------------------------------------------------------
    private final By men = By.linkText("Men");
    private final By menTops = By.linkText("Tops");
    private final By tanks = By.linkText("Tanks");
    private final By women = By.linkText("Women");
    private final By womenTops = By.linkText("Tops");
    private final By jackets = By.linkText("Jackets");
    private final By gear = By.linkText("Gear");
    private final By watches = By.linkText("Watches");
    private final By assertTitle = By.id("page-title-heading");
    //--------------------------------------------------------------------------------
    //ToDo adding methods
    public String assertion(){
        return driver.findElement(assertTitle).getText();
    }

    public void hoverMen(){
        action.moveToElement(driver.findElement(men)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(menTops));
        action.moveToElement(driver.findElement(menTops)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(tanks));
        action.moveToElement(driver.findElement(tanks)).click().build().perform();
    }

    public void hoverWomen(){
        action.moveToElement(driver.findElement(women)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenTops));
        action.moveToElement(driver.findElement(womenTops)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(jackets));
        action.moveToElement(driver.findElement(jackets)).click().build().perform();
    }

    public void hoverGear(){
        action.moveToElement(driver.findElement(gear)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(watches));
        action.moveToElement(driver.findElement(watches)).click().build().perform();
    }
}
