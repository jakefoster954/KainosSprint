package Selenium;

import Selenium.pages.*;
import org.checkerframework.checker.units.qual.C;
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
        driver.get("http://localhost:3000/login");
        Login login = new Login(driver);
        login.setEmail("admin@kainos.com");
        login.setPassword("123pas");
        login.clickSubmit();
        HomePage home = new HomePage(driver);
        home.clickJobRoles();

        JobRoles jobRoles = new JobRoles(driver);
        String jobRoleTitle = jobRoles.getTestJobResult();
        jobRoles.clickTestJobResult();

        Job job = new Job(driver);
        assertEquals(job.getWebElementByElementText(jobRoleTitle), jobRoleTitle);
        assertTrue(job.getCapabilityName().contains("Engineering"));
        assertTrue(job.getBandLevelName().contains("TEST - DEFAULT"));
        String trainingCourse1 = "Mindset Modules";
        String trainingCourse2 = "Intro To Remote Working";
        String trainingCourse3 = "Managing Your Career";
        assertEquals(job.getWebElementByElementText(trainingCourse1), trainingCourse1);
        assertEquals(job.getWebElementByElementText(trainingCourse2), trainingCourse2);
        assertEquals(job.getWebElementByElementText(trainingCourse3), trainingCourse3);
    }

    @Test
    public void viewCapabilityLead() {
        driver.get("http://localhost:3000/login");
        Login login = new Login(driver);
        login.setEmail("admin@kainos.com");
        login.setPassword("123pas");
        login.clickSubmit();
        HomePage home = new HomePage(driver);
        home.clickCapabilities();

        Capabilities capability = new Capabilities(driver);
        String leadName = capability.getTestLeadResult();
        capability.clickTestLeadResult();
        CapabilityLead lead = new CapabilityLead(driver);
        assertEquals(lead.getLeadNameByElementText(leadName), leadName);
        assertTrue(lead.getLeadMsg().contains("Howdy Partner"));
        assertTrue(lead.leadPhotoExists());
    }

    @Test
    public void loginToSystem_InvalidCredentials() {
        driver.get("http://localhost:3000/login");
        Login login = new Login(driver);
        login.setEmail("fail@kainos.com");
        login.setPassword("123pas");
        login.clickSubmit();
        String errorMessage = "Invalid Email or Password";
        assertEquals(login.getErrorMessageByElementText(errorMessage), errorMessage);
    }

    @Test
    public void addThenDeleteJobRole() {
        driver.get("http://localhost:3000/login");
        Login login = new Login(driver);
        login.setEmail("admin@kainos.com");
        login.setPassword("123pas");
        login.clickSubmit();
        HomePage home = new HomePage(driver);
        home.clickJobRoles();

        String jobName = String.valueOf(System.currentTimeMillis());
        String jobSpec = "Test Job Spec";
        String jobURL = "http://www.google.com";
        String capability = "Artificial Intelligence/ AI Engineering";
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
        assertEquals(job.getWebElementByElementText(jobName), jobName);
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
        login.setEmail("admin@kainos.com");
        login.setPassword("123pas");
        login.clickSubmit();
        HomePage home = new HomePage(driver);
        home.clickJobRoles();

        String errorMessageName = "\"Job Name\" length must be at least 5 characters long";
        String errorMessageSpec = "\"Job Specification\" is not allowed to be empty";
        String errorMessageLink = "\"Job URL\" with value \"\" fails to match the required pattern: /^https?:\\/\\/(.*)/";
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
        login.setEmail("admin@kainos.com");
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

    @Test
    public void addThenDeleteCapability() {
        driver.get("http://localhost:3000/login");
        Login login = new Login(driver);
        login.setEmail("admin@kainos.com");
        login.setPassword("123pas");
        login.clickSubmit();
        HomePage home = new HomePage(driver);
        home.clickCapabilities();

        String capabilityName = ".test" + String.valueOf(System.currentTimeMillis());
        String capabilityLead = "Josh Kelso";

        Capabilities capabilities = new Capabilities(driver);
        capabilities.setCapabilityName(capabilityName);
        capabilities.setCapabilityLead(capabilityLead);
        capabilities.clickSubmit();
        driver.navigate().refresh();
        capabilities.clickDeleteButtonForFirstCapability();
        expectedException.expect(TimeoutException.class);
        capabilities.getCapabilityText(capabilityName);
    }

}


