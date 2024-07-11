package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends PageBase{

    //ToDo add driver
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //ToDo adding locators
    //--------------------------------------------------------------------------------
    private final By registerPageMessage = By.cssSelector("span.base");
    private final By firstNameText = By.id("firstname");
    private final By lastNameText = By.id("lastname");
    private final By emailText = By.id("email_address");
    private final By passwordText = By.id("password");
    private final By confirmPasswordText = By.id("password-confirmation");
    private final By createButton = By.cssSelector("button.action.submit.primary");
    private final By createCompleteMessage = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    private final By accountDropMenu = By.cssSelector("button.action.switch");
    private final By signOutButton = By.partialLinkText("Sign Out");
    private final By signOutMessage = By.cssSelector("span.base");
    //--------------------------------------------------------------------------------
    //ToDo adding methods
    public String assertRegisterPage(){
        return driver.findElement(registerPageMessage).getText();
    }

    public String assertCompleteRegistration(){
        return driver.findElement(createCompleteMessage).getText();
    }

    public String assertSignOut(){
        return driver.findElement(signOutMessage).getText();
    }

    public void enterRegisterData(String firstName, String lastName, String email, String password, String confirmPassword){
        setText(driver,firstNameText, firstName);
        setText(driver,lastNameText, lastName);
        setText(driver,emailText, email);
        setText(driver,passwordText, password);
        setText(driver,confirmPasswordText, confirmPassword);
        click(driver,createButton);
    }

    public void logOut(){
        click(driver, accountDropMenu);
        click(driver, signOutButton);
    }
}
