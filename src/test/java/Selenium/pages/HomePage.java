package Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {
    @FindBy(linkText = "Job Roles")
    private WebElement jobRoles;
    @FindBy(linkText = "Capabilities")
    private WebElement capabilities;
    @FindBy(linkText = "Logout")
    private WebElement logout;
    //TODO: Will change this not to use dodgey xpath when home page is done
    @FindBy(xpath = "/html/body/div/main/div/h1")
    private WebElement homeHeading;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getHomeHeading() {
        return homeHeading.getText();
    }

    public void clickLogout() {
        logout.click();
    }

    public void clickJobRoles() {
        jobRoles.click();
    }

    public void clickCapabilities() {
        capabilities.click();
    }
}
