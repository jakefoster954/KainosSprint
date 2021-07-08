package Selenium;

import Selenium.pages.JobRoles;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class test extends FunctionalTest{
    @Test
    public void signMeUp() {
        driver.get("http://www.kimschiller.com/page-object-pattern-tutorial/index.html");
        JobRoles jobRoles = new JobRoles(driver);
        assertTrue(jobRoles.confirmationHeader().equals("blah"));
    }
}
