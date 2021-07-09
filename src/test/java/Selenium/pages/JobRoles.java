package Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobRoles extends PageObject {
    @FindBy(linkText = "Test") private WebElement testJobResult;

    public JobRoles(WebDriver driver) {
        super(driver);
    }

    public void clickTestJobResult() {
        testJobResult.click();
    }

    public String getTestJobResult() {
        return testJobResult.getText();
    }
}