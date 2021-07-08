package Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobRoles extends PageObject {
    @FindBy(tagName = "h1") private WebElement header;

    public JobRoles(WebDriver driver) {
        super(driver);
    }

    public String confirmationHeader() {
        return header.getText();
    }
}