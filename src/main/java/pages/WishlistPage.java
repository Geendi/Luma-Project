package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WishlistPage extends PageBase{
    //ToDo add driver
    WebDriver driver;

    public WishlistPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //ToDo adding locators
    //--------------------------------------------------------------------------------
    private final By addToWishList = By.cssSelector("a.action.towishlist");
    private final By addedMessage = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    private final By continueShoppingButton = By.linkText("here");
    private final By wishListPage= By.cssSelector("span.base");
    private final By removeButton = By.cssSelector("a.btn-remove.action.delete");
    private final By removeMessage = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    private final By emptyMessage = By.cssSelector("div.message.info.empty");
    //--------------------------------------------------------------------------------
    //ToDo adding methods
    public void removeItem(By productName){
        action.moveToElement(driver.findElement(productName)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeButton));
        action.moveToElement(driver.findElement(removeButton)).click().build().perform();
    }

    public String assertAdded(){
        return driver.findElement(addedMessage).getText();
    }

    public String assertWishListPage(){
        return driver.findElement(wishListPage).getText();
    }

    public String assertRemoveItem(){
        return driver.findElement(removeMessage).getText();
    }

    public String assertEmptyList(){
        return driver.findElement(emptyMessage).getText();
    }

    public void addToWishList(){
        click(driver, addToWishList);
    }

    public void continueShopping(){
        click(driver, continueShoppingButton);
    }


}
