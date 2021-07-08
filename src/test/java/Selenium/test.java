package Selenium;

import Selenium.pages.Job;
import Selenium.pages.JobRoles;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class test extends FunctionalTest{
    @Test
    public void viewJobRole() {
        driver.get("http://localhost:8080/api/job-roles");
        JobRoles jobRoles = new JobRoles(driver);
        String jobRoleTitle = jobRoles.getFirstJobResult();
        jobRoles.clickFirstJobResult();
        Job job = new Job(driver);
        assertEquals(job.getJobRoleTitle(), jobRoleTitle);
    }
}
