package Selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CapabilityLead extends PageObject {
    @FindBy(id = "capabilityLeadHeader")
    private WebElement leadName;
    @FindBy(id = "capabilityLeadMsg")
    private WebElement leadMsg;
    @FindBy(id = "capabilityLeadPhoto")
    private WebElement leadPhoto;

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

    public String getLeadNameByElementText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ text() = '" + text + "' ]")));
        return element.getText();
    }
}
