package Selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Job extends PageObject {
    @FindBy(id = "jobHeader") private WebElement jobRoleTitle;
    @FindBy(id = "capabilityHeader") private WebElement capabilityName;
    @FindBy(id = "bandLevelHeader") private WebElement bandLevelName;

    public Job(WebDriver driver) {
        super(driver);
    }

    public String getJobRoleTitle() {
        return jobRoleTitle.getText();
    }

    public String getCapabilityName() {
        return capabilityName.getText();
    }

    public String getBandLevelName() {
        return bandLevelName.getText();
    }
}
