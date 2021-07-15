package Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Capabilities extends PageObject {
    @FindBy(linkText = "Josh Kelso") private WebElement testLeadResult;

    public Capabilities(WebDriver driver) {
        super(driver);
    }

    public void clickTestLeadResult() {
        testLeadResult.click();
    }

    public String getTestLeadResult() {
        return testLeadResult.getText();
    }
}
