package Selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Job extends PageObject {
    @FindBy(xpath = "/html/body/div/div/div/div[1]/h1") private WebElement jobRoleTitle;

    public Job(WebDriver driver) {
        super(driver);
    }

    public String getJobRoleTitle() {
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        return jobRoleTitle.getText();
    }
}
