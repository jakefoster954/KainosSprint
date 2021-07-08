package UnitTest;

import com.kainos.ea.resources.Job;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class JobTest {

    @Test
    public void constructor_ValidArguments_ObjectCreated() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        String capability = "Test Capability";
        String bandLevel = "Test Band Level";
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID, capability, bandLevel);

        assertNotNull(job);
        assertEquals(job.getJobID(), jobID);
        assertEquals(job.getJobName(), jobName);
        assertEquals(job.getJobSpec(), jobSpec);
        assertEquals(job.getJobUrl(), jobUrl);
        assertEquals(job.getBandLevelID(), bandLevelID);
    }

    @Test
    public void getJobID_ValidTest_JobIDReturned() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        String capability = "Test Capability";
        String bandLevel = "Test Band Level";
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID, capability, bandLevel);

        int result = job.getJobID();

        assertEquals(result, jobID);
    }

    @Test
    public void getJobName_ValidTest_JobNameReturned() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        String capability = "Test Capability";
        String bandLevel = "Test Band Level";
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID, capability, bandLevel);

        String result = job.getJobName();

        assertEquals(result, jobName);
    }

    @Test
    public void getJobNameAsURL_JobNameWithSpacesInput_JobNameWithHyphensReturned() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        String capability = "Test Capability";
        String bandLevel = "Test Band Level";
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID, capability, bandLevel);

        String result = job.getJobNameAsURL();

        assertEquals("Test-Name", result);
    }

    @Test
    public void getJobNameAsURL_JobNameWithNoSpacesInput_JobNameWithNoHyphensReturned() {
        int jobID = 0;
        String jobName = "Test";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        String capability = "Test Capability";
        String bandLevel = "Test Band Level";
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID, capability, bandLevel);

        String result = job.getJobNameAsURL();

        assertEquals("Test", result);
    }

    @Test
    public void getJobSpec_ValidTest_JobSpecReturned() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        String capability = "Test Capability";
        String bandLevel = "Test Band Level";
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID, capability, bandLevel);

        String result = job.getJobSpec();

        assertEquals(result, jobSpec);
    }

    @Test
    public void getJobUrl_ValidTest_JobUrlReturned() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        String capability = "Test Capability";
        String bandLevel = "Test Band Level";
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID, capability, bandLevel);

        String result = job.getJobUrl();

        assertEquals(result, jobUrl);
    }

    @Test
    public void getBandLevelID_ValidTest_BandLevelIDReturned() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        String capability = "Test Capability";
        String bandLevel = "Test Band Level";
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID, capability, bandLevel);

        int result = job.getBandLevelID();

        assertEquals(result, bandLevelID);
    }

    @Test
    public void setJobID_ValidJobIDInput_JobIDSetToNewValue() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        String capability = "Test Capability";
        String bandLevel = "Test Band Level";
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID, capability, bandLevel);

        int newJobId = 1;
        job.setJobID(newJobId);

        assertEquals(job.getJobID(), newJobId);
    }

    @Test
    public void setJobName_ValidJobNameInput_JobNameSetToNewValue() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        String capability = "Test Capability";
        String bandLevel = "Test Band Level";
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID, capability, bandLevel);

        String newJobName = "Test1 Name1";
        job.setJobName(newJobName);

        assertEquals(job.getJobName(), newJobName);
    }

    @Test
    public void setJobSpec_ValidJobSpecInput_JobSpecSetToNewValue() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        String capability = "Test Capability";
        String bandLevel = "Test Band Level";
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID, capability, bandLevel);

        String newJobSpec = "Test1 Spec1";
        job.setJobSpec(newJobSpec);

        assertEquals(job.getJobSpec(), newJobSpec);
    }

    @Test
    public void setJobUrl_ValidJobUrlInput_JobUrlSetToNewValue() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        String capability = "Test Capability";
        String bandLevel = "Test Band Level";
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID, capability, bandLevel);

        String newJobUrl = "Test1 URL1";
        job.setJobUrl(newJobUrl);

        assertEquals(job.getJobUrl(), newJobUrl);
    }

    @Test
    public void setBandLevelID_ValidBandLevelIDInput_BandLevelIDSetToNewValue() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        String capability = "Test Capability";
        String bandLevel = "Test Band Level";
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID, capability, bandLevel);

        int newBandLevelID = 1;
        job.setBandLevelID(newBandLevelID);

        assertEquals(job.getBandLevelID(), newBandLevelID);
    }
}
