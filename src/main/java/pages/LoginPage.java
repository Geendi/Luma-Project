package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{

    //ToDo add driver
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //ToDo adding locators
    //--------------------------------------------------------------------------------
    private final By loginPageMessage = By.cssSelector("span.base");
    private final By emailText = By.id("email");
    private final By passwordText = By.id("pass");
    private final By signInButton = By.id("send2");
    private final By forgotButton = By.linkText("Forgot Your Password?");
    private final By forgotPageMessage = By.cssSelector("span.base");
    private final By resetEmail = By.id("email_address");
    private final By resetButton = By.cssSelector("button.action.submit.primary");
    private final By forgotCompleteMessage = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    private final By loggedInMessage = By.cssSelector("span.logged-in");
    //--------------------------------------------------------------------------------
    //ToDo adding methods
    public String assertLoginPage(){
        return driver.findElement(loginPageMessage).getText();
    }

    public String assertLoggedIn(){
        return driver.findElement(loggedInMessage).getText();
    }

    public String assertForgotPage(){
        return driver.findElement(forgotPageMessage).getText();
    }

    public String assertCompleteForgotProcess(){
        return driver.findElement(forgotCompleteMessage).getText();
    }

    public void enterLoginData(String email, String password){
        setText(driver,emailText, email);
        setText(driver,passwordText, password);
        click(driver, signInButton);
    }

    public void forgotPassword(String mail){
        setText(driver,resetEmail, mail);
        click(driver, resetButton);
    }

    public void openForgotPassword(){
        click(driver, forgotButton);
    }
}
