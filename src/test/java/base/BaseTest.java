package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    @BeforeClass
    @Parameters("Browser")
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/alexisvillamayor/Solvd/Dev/chromedriver");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
//        if (browser.equalsIgnoreCase("Chrome")){
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
//            driver = new ChromeDriver(options);
//        } else if (browser.equalsIgnoreCase("Firefox")) {
//            driver = new FirefoxDriver();
//        }
        driver.manage().window().maximize();
//        loginPageFacebook = new LoginPage(driver);
        homePageEbay = new HomePage(driver);
        goHome();
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
