package Selenium;

import Selenium.pages.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class test extends FunctionalTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void viewJobRole() {
        driver.get("http://localhost:3000/job-roles");
        JobRoles jobRoles = new JobRoles(driver);
        String jobRoleTitle = jobRoles.getTestJobResult();
        jobRoles.clickTestJobResult();
        Job job = new Job(driver);
        assertEquals(job.getJobRoleTitleByElementText(jobRoleTitle), jobRoleTitle);
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
        assertEquals(lead.getLeadNameByElementText(leadName), leadName);
        assertTrue(lead.getLeadMsg().contains("Howdy Partner"));
        assertTrue(lead.leadPhotoExists());
    }

    @Test
    public void loginToSystem_ValidCredentials() {
        driver.get("http://localhost:3000/login");
        Login login = new Login(driver);
        login.setEmail("test@email.com");
        login.setPassword("123pas");
        login.clickSubmit();
        HomePage home = new HomePage(driver);
        assertEquals(home.getHomeHeading(), "Home Page");
        home.clickLogout();
    }

    @Test
    public void addThenDeleteJobRole() {
        driver.get("http://localhost:3000/login");
        Login login = new Login(driver);
        login.setEmail("test@email.com");
        login.setPassword("123pas");
        login.clickSubmit();
        HomePage home = new HomePage(driver);
        home.clickJobRoles();

        String jobName = String.valueOf(System.currentTimeMillis());
        String jobSpec = "Test Job Spec";
        String jobURL = "Test Job URL";
        String capability = "Artificial Intelligence";
        String bandName = "Apprentice";
        JobRoles jobRoles = new JobRoles(driver);
        jobRoles.setJobName(jobName);
        jobRoles.setJobSpec(jobSpec);
        jobRoles.setJobURL(jobURL);
        jobRoles.setCapability(capability);
        jobRoles.setBandName(bandName);
        jobRoles.clickSubmit();
        driver.navigate().refresh(); // Added as Selenium not waiting for page refresh after database insertion
        jobRoles.clickSpecificJob(jobName);

        Job job = new Job(driver);
        assertEquals(job.getJobRoleTitleByElementText(jobName), jobName);
        assertTrue(job.getCapabilityName().contains(capability));
        assertTrue(job.getBandLevelName().contains(bandName));
        job.clickDelete();
        expectedException.expect(TimeoutException.class);
        jobRoles.clickSpecificJob(jobName);
        jobRoles.clickLogout();
    }

    @Test
    public void addJobRole_NoValuesInput() {
        driver.get("http://localhost:3000/login");
        Login login = new Login(driver);
        login.setEmail("test@email.com");
        login.setPassword("123pas");
        login.clickSubmit();
        HomePage home = new HomePage(driver);
        home.clickJobRoles();

        String errorMessageName = "\"Job Name\" length must be at least 5 characters long";
        String errorMessageSpec = "\"Job Specification\" is not allowed to be empty";
        String errorMessageLink = "\"Job URL\" is not allowed to be empty";
        String errorMessageCapabiity = "\"Capability\" is not allowed to be empty";
        String errorMessageBandLevel = "\"Band Level\" is not allowed to be empty";
        JobRoles jobRoles = new JobRoles(driver);
        jobRoles.clickSubmit();

        assertEquals(jobRoles.getErrorMessageByElementText(errorMessageName), errorMessageName);
        assertEquals(jobRoles.getErrorMessageByElementText(errorMessageSpec), errorMessageSpec);
        assertEquals(jobRoles.getErrorMessageByElementText(errorMessageLink), errorMessageLink);
        assertEquals(jobRoles.getErrorMessageByElementText(errorMessageCapabiity), errorMessageCapabiity);
        assertEquals(jobRoles.getErrorMessageByElementText(errorMessageBandLevel), errorMessageBandLevel);
        jobRoles.clickLogout();
    }

    @Test
    public void addJobRole_JobNameInvalidLength() {
        driver.get("http://localhost:3000/login");
        Login login = new Login(driver);
        login.setEmail("test@email.com");
        login.setPassword("123pas");
        login.clickSubmit();
        HomePage home = new HomePage(driver);
        home.clickJobRoles();

        String errorMessageName = "\"Job Name\" length must be at least 5 characters long";
        String jobName = "Test";
        JobRoles jobRoles = new JobRoles(driver);
        jobRoles.setJobName(jobName);
        jobRoles.clickSubmit();

        assertEquals(jobRoles.getErrorMessageByElementText(errorMessageName), errorMessageName);
        jobRoles.clickLogout();
    }

}


