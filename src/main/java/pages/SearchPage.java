package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage extends PageBase{
    //ToDo add driver
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //ToDo adding locators
    //--------------------------------------------------------------------------------
    private final By searchText = By.id("search");
    private final By searchButton = By.cssSelector("button.action.search");
    private final By searchResult = By.cssSelector("span.base");
    private final By secondProduct = By.linkText("Montana Wind Jacket");

    @FindBy(xpath = "//ul[@role='listbox']")
    List<WebElement> productList;
    //--------------------------------------------------------------------------------
    //ToDo adding methods
    public String assertResults(){
        return driver.findElement(searchResult).getText();
    }
    public void productSearch(String productName){
        setText(driver, searchText, productName);
        click(driver, searchButton);
    }

    public void openProductDetails(By product){
        click(driver, product);
    }

    public void openSecondProductDetails(){
        click(driver, secondProduct);
    }

    public void productSearchUsingAutoSuggest(String products){
        setText(driver, searchText, products);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));
        productList.getFirst().click();

    }

}
