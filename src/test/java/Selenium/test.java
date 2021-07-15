package Selenium;

import Selenium.pages.CapabilityLead;
import Selenium.pages.Job;
import Selenium.pages.JobRoles;
import Selenium.pages.Capabilities;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class test extends FunctionalTest {
    @Test
    public void viewJobRole() {
        driver.get("http://localhost:3000/job-roles");
        JobRoles jobRoles = new JobRoles(driver);
        String jobRoleTitle = jobRoles.getTestJobResult();
        jobRoles.clickTestJobResult();
        Job job = new Job(driver);
        assertEquals(job.getJobRoleTitle(), jobRoleTitle);
        assertTrue(job.getCapabilityName().contains("Engineering"));
        assertTrue(job.getBandLevelName().contains("TEST - DEFAULT"));
    }

    @Test
    public void viewCapabilityLead() {
        driver.get("http://localhost:3000/capabilities");
        Capabilities capability = new Capabilities(driver);
        String leadName = capability.getTestLeadResult();
        capability.clickTestLeadResult();
        CapabilityLead lead = new CapabilityLead(driver);
        assertEquals(lead.getLeadName(), leadName);
        assertTrue(lead.getLeadMsg().contains("Howdy Partner"));
        assertTrue(lead.leadPhotoExists());
    }
}


