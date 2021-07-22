package Selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Capabilities extends PageObject {
    @FindBy(linkText = "Josh Kelso")
    private WebElement testLeadResult;
    @FindBy(id = "capabilityName")
    private WebElement capabilityNameInput;
    @FindBy(xpath = "/html/body/div/main/div/div/div[2]/div[2]/form/button")
    private WebElement submit;
    @FindBy(id = "capabilityLead")
    private WebElement capabilityLeadInput;
    @FindBy(xpath = "/html/body/div/main/div/div/div[1]/div/table/tbody/tr[1]/td[3]/a")
    private WebElement firstDeleteButton;

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

    public void setCapabilityLead(String capabilityLead) {
        Select select = new Select(capabilityLeadInput);
        select.selectByValue(capabilityLead);
    }

    public void clickDeleteButtonForFirstCapability() {
        firstDeleteButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getCapabilityText(String capability){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ text() = '"+capability+"' ]")));
        return element.getText();
    }

    public String getErrorMessageByElementText(String text){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ text() = '"+text+"' ]")));
        return element.getText();
    }
}
