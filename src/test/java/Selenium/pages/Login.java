package Selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends PageObject {
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    //TODO: Remove dodgey xpath
    @FindBy(xpath = "/html/body/div/main/div/div/div[2]/form/button")
    private WebElement submit;

    public Login(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSubmit() {
        submit.click();
    }

    public String getErrorMessageByElementText(String text){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ text() = '"+text+"' ]")));
        return element.getText();
    }
}
