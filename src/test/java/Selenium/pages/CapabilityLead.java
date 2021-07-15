package Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CapabilityLead extends PageObject {
    @FindBy(id = "capabilityLeadHeader") private WebElement leadName;
    @FindBy(id = "capabilityLeadMsg") private WebElement leadMsg;
    @FindBy(id = "capabilityLeadPhoto") private WebElement leadPhoto;

    public CapabilityLead(WebDriver driver) {
        super(driver);
    }

    public String getLeadName() {
        return leadName.getText();
    }

    public String getLeadMsg() {
        return leadMsg.getText();
    }

    public boolean leadPhotoExists() {
        return leadPhoto.isDisplayed();
    }
}
