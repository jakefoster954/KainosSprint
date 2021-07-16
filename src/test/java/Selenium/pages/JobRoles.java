package Selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobRoles extends PageObject {
    @FindBy(linkText = "Test") private WebElement testJobResult;
    @FindBy(id = "jobName") private WebElement jobNameInput;
    @FindBy(id = "jobSpec") private WebElement jobSpecInput;
    @FindBy(id = "jobURL") private WebElement jobURLInput;
    @FindBy(id = "capability") private WebElement capabilityInput;
    @FindBy(id = "bandLevel") private WebElement bandNameInput;
    //TODO: Remove dodgey xpath
    @FindBy(xpath = "/html/body/div/main/div/div/div[2]/div/div[2]/form/button") private WebElement submit;
    @FindBy(linkText = "Logout") private WebElement logout;

    public JobRoles(WebDriver driver) {
        super(driver);
    }

    public void clickTestJobResult() {
        testJobResult.click();
    }

    public String getTestJobResult() {
        return testJobResult.getText();
    }

    public void setJobName(String jobName){
        jobNameInput.sendKeys(jobName);
    }

    public void setJobSpec(String jobSpec){
        jobSpecInput.sendKeys(jobSpec);
    }

    public void setJobURL(String jobURL){
        jobURLInput.sendKeys(jobURL);
    }

    public void clickLogout(){
        logout.click();
    }

    public void setCapability(String capability){
        Select select = new Select(capabilityInput);
        select.selectByValue(capability);
    }

    public void setBandName(String bandName){
        Select select = new Select(bandNameInput);
        select.selectByValue(bandName);
    }

    public void clickSubmit(){
        submit.click();
    }

    public void clickSpecificJob(String jobName) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ text() = '"+jobName+"' ]")));
        element.click();
    }

    public String getErrorMessageByElementText(String text){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ text() = '"+text+"' ]")));
        return element.getText();
    }
}