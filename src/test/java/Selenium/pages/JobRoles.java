package Selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobRoles extends PageObject {
    @FindBy(xpath = "//*[@id=\"jobTable\"]/tbody/tr[1]/td/a") private WebElement firstJobResult;

    public JobRoles(WebDriver driver) {
        super(driver);
    }

    public void clickFirstJobResult() {
        firstJobResult.click();
    }

    public String getFirstJobResult() {
        return firstJobResult.getText();
    }
}