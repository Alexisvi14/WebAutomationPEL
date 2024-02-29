package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By loginButton = By.xpath("//a[@_sp='m570.l1524']");
    private By searchBox = By.className("gh-tb");
    private By searchButton = By.id("gh-btn");
    private By searchedElements = By.cssSelector("div#srp-river-results li");
    private By technologyLink = By.xpath("//li[@class='hl-cat-nav__js-tab']//a[contains(text(), 'Tecnología')]");
    private By modeLink = By.xpath("(//a[contains(text(),'Moda')])[2]");
    private By accessoriesForMen = By.xpath("//a[contains(text(),'Accesorios para hombre')]");
    private By dropdownCategories = By.id("gh-cat");

    private By sportsCategory = By.linkText("Deportes");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
    public void clickSearchBox(String elementToSearch){
        driver.findElement(searchBox).sendKeys(elementToSearch);
    }

    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }

    public void getNumberOfSearchedElements(){
        List<WebElement> elements = driver.findElements(searchedElements);
        System.out.println(elements.size());
    }

    public void hoverSportsLink(){
        Actions actions = new Actions(driver);
        WebElement sports = driver.findElement(sportsCategory);
        actions.moveToElement(sports).perform();
    }
    public void clickSportsLink(){
        driver.findElement(sportsCategory).click();
    }

    public void clickCategoriesDropdown() throws InterruptedException {
        driver.findElement(dropdownCategories).click();
        Thread.sleep(3000);
        WebElement dropE = driver.findElement(dropdownCategories);
        Select selectDrop = new Select(dropE);
        selectDrop.selectByIndex(2);
        Thread.sleep(3000);
    }
}
