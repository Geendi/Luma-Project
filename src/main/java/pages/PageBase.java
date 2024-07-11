package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    //ToDo add driver

    public Actions action;
    public WebDriverWait wait;

    //ToDo create constructor
    public PageBase(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //ToDo adding methods
    public void click(WebDriver driver,By button){
        driver.findElement(button).click();
    }

    public void setText(WebDriver driver,By text, String value){
        driver.findElement(text).sendKeys(value);
    }
}
