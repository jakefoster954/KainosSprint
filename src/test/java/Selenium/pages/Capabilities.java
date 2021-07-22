package Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Capabilities extends PageObject {
    @FindBy(linkText = "Josh Kelso")
    private WebElement testLeadResult;
    @FindBy(id = "capabilityName")
    private WebElement capabilityNameInput;
    @FindBy(xpath = "/html/body/div/main/div/div/div[2]/div[2]/form/button")
    private WebElement submit;

    public Capabilities(WebDriver driver) {
        super(driver);
    }

    public void clickTestLeadResult() {
        testLeadResult.click();
    }

    public void clickSubmit() {
        submit.click();
    }

    public String getTestLeadResult() {
        return testLeadResult.getText();
    }

    public void setCapabilityName(String capabilityName) {
        capabilityNameInput.sendKeys(capabilityName);
    }
}
