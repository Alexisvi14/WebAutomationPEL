package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;

public class BaseTest {

    private static WebDriver driver;

    protected HomePage homePageEbay;

    public static WebDriver getDriver() {
        return driver;
    }

    public void selectDropdownElementByIndex(WebElement dropdown, int index){
        Select drop = new Select(dropdown);
        drop.selectByIndex(index);
    }

    @BeforeClass
    @Parameters("Browser")
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/alexisvillamayor/Solvd/Dev/chromedriver");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
        options.addArguments("--lang=en-US");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        homePageEbay = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://www.ebay.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
