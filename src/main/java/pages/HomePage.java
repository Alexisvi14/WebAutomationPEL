package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    @FindBy(xpath = "//a[@_sp='m570.l1524']")
    WebElement loginButton;
    @FindBy(className = "gh-tb")
    WebElement searchBox;
    @FindBy(id = "gh-btn")
    WebElement searchButton;
    @FindBy(css = "div#srp-river-results li")
    List<WebElement> searchedElements;
    @FindBy(id = "gh-cat")
    WebElement dropdownCategories;
    @FindBy(linkText = "Deportes")
    WebElement sportsCategory;
    @FindBy(xpath = "(//a[contains(text(), 'Moda')])[2]")
    WebElement modeCategory;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLoginButton(){
        loginButton.click();
        return new LoginPage(driver);
    }
    public void clickSearchBox(String elementToSearch){
        searchBox.sendKeys(elementToSearch);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void getNumberOfSearchedElements(){
        System.out.println(searchedElements.size());
    }

    public void hoverSportsLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(sportsCategory).perform();
    }
    public void clickSportsLink(){
        sportsCategory.click();
    }

    public void hoverModeLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(modeCategory).perform();
    }

    public void clickCategoriesDropdown() throws InterruptedException {
        dropdownCategories.click();
        Thread.sleep(3000);
        Select selectDrop = new Select(dropdownCategories);
        selectDrop.selectByIndex(2);
        Thread.sleep(3000);
    }
}
