package Selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Job extends PageObject {
    @FindBy(id = "jobHeader")
    private WebElement jobRoleTitle;
    @FindBy(id = "capabilityHeader")
    private WebElement capabilityName;
    @FindBy(id = "bandLevelHeader")
    private WebElement bandLevelName;
    @FindBy(linkText = "Delete Job Role")
    private WebElement deleteJobRole;

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

    public void clickDelete() {
        deleteJobRole.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getWebElementByElementText(String text){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ text() = '"+text+"' ]")));
        return element.getText();
    }
}
