package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameBox = By.id("userid");
    private By passwordBox = By.id("pass");
    private By continueButton = By.id("signin-continue-btn");
    private By errorMsg = By.id("errormsg");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUsernameBox(String username){
        driver.findElement(usernameBox).sendKeys(username);
    }
    public void clickPasswordBox(String password){
        driver.findElement(passwordBox).sendKeys(password);
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public String getErrorMsg(){
        return driver.findElement(errorMsg).getText();
    }
}
