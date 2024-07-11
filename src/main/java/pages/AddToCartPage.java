package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartPage extends PageBase{
    //ToDo add driver
    WebDriver driver;

    public AddToCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //ToDo adding locators
    //--------------------------------------------------------------------------------
    private final By addToCartButton = By.cssSelector("button.action.primary.tocart");
    private final By addedMessage = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    private final By removeButton = By.cssSelector("a.action.action-delete");
    private final By cartPageMessage = By.cssSelector("span.base");
    private final By shoppingCart = By.linkText("shopping cart");
    private final By blueColor = By.id("option-label-color-93-item-50");
    private final By blackColor = By.id("option-label-color-93-item-49");
    private final By size = By.id("option-label-size-143-item-166");
    //--------------------------------------------------------------------------------
    //ToDo adding methods
    public String assertShoppingPage(){
        return driver.findElement(cartPageMessage).getText();
    }

    public String assertAddItemToCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addedMessage));
        return driver.findElement(addedMessage).getText();
    }

    public void addItemToCart(){
        click(driver, addToCartButton);
    }

    public void removeItemFromCart(){
        click(driver, removeButton);
    }

    public void chooseSpecifics(boolean color){
        click(driver, size);
        if (color){
            click(driver, blueColor);
        }else{
            click(driver, blackColor);
        }
    }



    public void navigateToCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCart)).click();
    }




}
