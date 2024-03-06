package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SportsPage{
    WebDriver driver;

    @FindBy(xpath = "//li[@class='b-links-accordion']")
    List<WebElement> categoriesLinks;

    public SportsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void iterateCategorySection(String linkToSelect){
        for (WebElement link : categoriesLinks) {
            String dropdownText = link.getText();
            if (dropdownText.equalsIgnoreCase(linkToSelect)){
                link.click();
                break;
            }
        }
    }
}
