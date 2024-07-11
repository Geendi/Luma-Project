package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage extends PageBase{
    //ToDo add driver
    WebDriver driver;
    Select select;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //ToDo adding locators
    //--------------------------------------------------------------------------------
    private final By checkOutButton = By.xpath("//button[@data-role='proceed-to-checkout']");
    private final By closeNotification = By.cssSelector("div.ea-stickybox-hide");
    private final By streetText = By.name("street[0]");
    private final By cityText = By.name("city");
    private final By postalCode = By.name("postcode");
    private final By phoneNum = By.name("telephone");
    private final By methodCheckBox = By.cssSelector("input.radio");
    private final By nextButton = By.cssSelector("button.button.action.continue.primary");
    private final By dropDownMenu = By.name("region_id");
    private final By shippingPage = By.cssSelector("div.step-title");
    private final By continueShopping = By.linkText("Continue Shopping");
    private final By placeOrderButton = By.cssSelector("button.action.primary.checkout");
    private final By myAccountButton = By.linkText("My Account");
    private final By accountDropMenu = By.cssSelector("button.action.switch");
    private final By ordersPage =  By.linkText("My Orders");
    private final By viewOrderButton = By.linkText("View Order");
    private final By productName = By.cssSelector("td.col.name");
    //--------------------------------------------------------------------------------
    //ToDo adding methods
    public String assertProductName(){
        return driver.findElement(productName).getText();
    }

    public void viewOrder(){
        click(driver, viewOrderButton);
    }

    public String assertShippingAndPaymentPages(){
        return driver.findElement(shippingPage).getText();
    }

    public void navigateToCheckOutPage(){
        click(driver, closeNotification);
        click(driver, checkOutButton);
    }

    public void placeOrder(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderButton));
        click(driver, closeNotification);
        click(driver, placeOrderButton);
    }

    public void enterShippingData(String street, String city, String state, String code, String phone){
        wait.until(ExpectedConditions.visibilityOfElementLocated(streetText));
        setText(driver, streetText, street);
        setText(driver, cityText, city);
        setText(driver, postalCode, code);
        setText(driver, phoneNum, phone);
        click(driver, methodCheckBox);
        select = new Select(driver.findElement(dropDownMenu));
        select.selectByVisibleText(state);
        click(driver, nextButton);
    }

    public void continueShopping(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShopping));
        click(driver, continueShopping);
    }

    public void navigateToMyAccount(){
        click(driver, accountDropMenu);
        click(driver, myAccountButton);
    }

    public void openOrdersPage(){
        click(driver, ordersPage);
    }
}
