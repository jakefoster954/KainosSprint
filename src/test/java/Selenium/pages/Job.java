package Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Job extends PageObject {
    @FindBy(id = "") private WebElement jobROLEtitle;

    public Job(WebDriver driver) {
        super(driver);
    }

    public String getJobRoleTitle() {
        return jobROLEtitle.getText();
    }
}
