package Selenium;

import Selenium.pages.Job;
import Selenium.pages.JobRoles;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class test extends FunctionalTest {
    @Test
    public void viewJobRole() {
        driver.get("http://localhost:8080/api/job-roles");
        JobRoles jobRoles = new JobRoles(driver);
        String jobRoleTitle = jobRoles.getTestJobResult();
        jobRoles.clickTestJobResult();
        Job job = new Job(driver);
        assertEquals(job.getJobRoleTitle(), jobRoleTitle);
        assertTrue(job.getCapabilityName().contains("Engineering"));
        assertTrue(job.getBandLevelName().contains("CEO"));
    }
}
