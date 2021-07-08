package com.kainos.ea.resources;

public class Job {
    private int jobID = 0;
    private String jobName = "Job name";
    private String jobSpec = "Job Spec";
    private String jobUrl = "Job URL";
    private int bandLevelID = 0;

    public Job() {
    }
    public Job(int jobID, String jobName, String jobSpec, String jobUrl, int bandLevelID) {
        this.setJobID(jobID);
        this.setJobName(jobName);
        this.setJobSpec(jobSpec);
        this.setJobUrl(jobUrl);
        this.setBandLevelID(bandLevelID);
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobNameAsURL() {
        return jobName.replace(" ", "-");
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobSpec() {
        return jobSpec;
    }

    public void setJobSpec(String jobSpec) {
        this.jobSpec = jobSpec;
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    public int getBandLevelID() {
        return bandLevelID;
    }

    public void setBandLevelID(int bandLevelID) {
        this.bandLevelID = bandLevelID;
    }
}