package UnitTest;

import com.kainos.ea.resources.Job;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class JobTest {

    @Test
    public void constructor_ValidArguments_ObjectCreated() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;

        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID);

        assertTrue(job != null);
        assertTrue(job.getJobID() == jobID);
        assertTrue(job.getJobName().equals(jobName));
        assertTrue(job.getJobSpec().equals(jobSpec));
        assertTrue(job.getJobUrl().equals(jobUrl));
        assertTrue(job.getBandLevelID() == bandLevelID);
    }

    @Test
    public void getJobID_ValidTest_JobIDReturned() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID);

        int result = job.getJobID();

        assertTrue(result == jobID);
    }

    @Test
    public void getJobName_ValidTest_JobNameReturned() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID);

        String result = job.getJobName();

        assertTrue(result.equals(jobName));
    }

    @Test
    public void getJobNameAsURL_JobNameWithSpacesInput_JobNameWithHyphensReturned() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID);

        String result = job.getJobNameAsURL();

        assertTrue(result.equals("Test-Name"));
    }

    @Test
    public void getJobNameAsURL_JobNameWithNoSpacesInput_JobNameWithNoHyphensReturned() {
        int jobID = 0;
        String jobName = "Test";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID);

        String result = job.getJobNameAsURL();

        assertTrue(result.equals("Test"));
    }

    @Test
    public void getJobSpec_ValidTest_JobSpecReturned() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID);

        String result = job.getJobSpec();

        assertTrue(result.equals(jobSpec));
    }

    @Test
    public void getJobUrl_ValidTest_JobUrlReturned() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID);

        String result = job.getJobUrl();

        assertTrue(result.equals(jobUrl));
    }

    @Test
    public void getBandLevelID_ValidTest_BandLevelIDReturned() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID);

        int result = job.getBandLevelID();

        assertTrue(result == bandLevelID);
    }

    @Test
    public void setJobID_ValidJobIDInput_JobIDSetToNewValue() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID);

        int newJobId = 1;
        job.setJobID(newJobId);

        assertTrue(job.getJobID() == newJobId);
    }

    @Test
    public void setJobName_ValidJobNameInput_JobNameSetToNewValue() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID);

        String newJobName = "Test1 Name1";
        job.setJobName(newJobName);

        assertTrue(job.getJobName().equals(newJobName));
    }

    @Test
    public void setJobSpec_ValidJobSpecInput_JobSpecSetToNewValue() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID);

        String newJobSpec = "Test1 Spec1";
        job.setJobSpec(newJobSpec);

        assertTrue(job.getJobSpec().equals(newJobSpec));
    }

    @Test
    public void setJobUrl_ValidJobUrlInput_JobUrlSetToNewValue() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID);

        String newJobUrl = "Test1 URL1";
        job.setJobUrl(newJobUrl);

        assertTrue(job.getJobUrl().equals(newJobUrl));
    }

    @Test
    public void setBandLevelID_ValidBandLevelIDInput_BandLevelIDSetToNewValue() {
        int jobID = 0;
        String jobName = "Test Name";
        String jobSpec = "Test Spec";
        String jobUrl = "Test URL";
        int bandLevelID = 0;
        Job job = new Job(jobID, jobName, jobSpec, jobUrl, bandLevelID);

        int newBandLevelID = 1;
        job.setBandLevelID(newBandLevelID);

        assertTrue(job.getBandLevelID() == newBandLevelID);
    }
}
