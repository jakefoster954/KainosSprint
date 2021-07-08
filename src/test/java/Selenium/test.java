package Selenium;

import Selenium.pages.JobRoles;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class test extends FunctionalTest{
    @Test
    public void viewJobRole() {
        driver.get("http://localhost:8080/api/job-roles");
        JobRoles jobRoles = new JobRoles(driver);
        String jobRoleTitle = jobRoles.getFirstJobResult();
        jobRoles.clickFirstJobResult();
    }
}
