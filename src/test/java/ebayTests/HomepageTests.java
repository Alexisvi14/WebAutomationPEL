package ebayTests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomepageTests extends BaseTest {

    @Test(dataProvider="usernameData")
    public void loginButtonTest(String username) throws InterruptedException {
        var loginPage = homePageEbay.clickLoginButton();
        loginPage.clickUsernameBox(username);
        loginPage.clickContinueButton();
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.getErrorMsg(),
                "No pudimos encontrar esta cuenta de eBay.", "El mensaje no fue el esperado");
        Assert.assertTrue(!loginPage.getErrorMsg().isEmpty());
    }
    @DataProvider
    public Object[][] usernameData(){
        Object[][] data = new Object[3][1];
        data[0][0] = "hellohellojajagmail";
        data[1][0] = "ahsdiusjndkasndujewkiu";
        data[2][0] = "iu32whuewhut21t21y";
        return data;
    }
    @Test
    public void searchButtonTest() throws InterruptedException {
        homePageEbay.clickSearchBox("Iphone");
        homePageEbay.clickSearchButton();
        Thread.sleep(5000);
        homePageEbay.getNumberOfSearchedElements();
    }

    @Test()
    public void submenuElements() throws InterruptedException {
        homePageEbay.hoverModeLink();
        Thread.sleep(5000);

    }

    @Test()
    public void dropdownTest() throws InterruptedException {
        homePageEbay.clickCategoriesDropdown();
    }

    @Test()
    public void hoverSportsTest(){
        homePageEbay.hoverSportsLink();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Deportes acuáticos")));

    }
    @Test()
    public void sportList(){
        homePageEbay.clickSportsLink();
        List<WebElement> sportsLinks = getDriver().findElements(By.cssSelector("[class = 'b-module b-list b-speciallinks b-display--landscape']"));
        for (WebElement element:sportsLinks) {
            System.out.println(element.getText());
        }
    }
}
