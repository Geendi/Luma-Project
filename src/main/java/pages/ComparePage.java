package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparePage extends PageBase{
    //ToDo add driver
    WebDriver driver;

    public ComparePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //ToDo adding locators
    //--------------------------------------------------------------------------------
    private final By compareButton = By.cssSelector("a.action.tocompare");
    private final By comparePage = By.cssSelector("span.base");
    private final By removeButton = By.cssSelector("a.action.delete");
    private final By removeMessage = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    private final By emptyMessage = By.cssSelector("div.message.info.empty");
    private final By okButton = By.cssSelector("button.action-primary.action-accept");

    @FindBy(tagName = "tr")
    public List<WebElement> allRows;

    @FindBy(tagName = "td")
    public List<WebElement> allCols;
    //--------------------------------------------------------------------------------
    //ToDo adding methods
    public String assertComparePage(){
        return driver.findElement(comparePage).getText();
    }

    public String assertRemoveConfirmation(){
        return driver.findElement(removeMessage).getText();
    }

    public String assertEmptyList(){
        return driver.findElement(emptyMessage).getText();
    }

    public void addProductToCompare(){
        click(driver, compareButton);
    }

    public void removeProductFromCompare(){
        click(driver, removeButton);
        click(driver, okButton);
    }

    public void compareProducts(){
        System.out.println(allRows.size());
        for (WebElement row : allRows){
            System.out.println(row.getText() + "\t");
            for (WebElement col : allCols){
                System.out.println(col.getText() + "\t");
            }
        }
    }
}
