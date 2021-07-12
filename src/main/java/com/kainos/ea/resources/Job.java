package com.kainos.ea.resources;

public class Job {
    private int jobID = 0;
    private String jobName = "Job name";
    private String jobSpec = "Job Spec";
    private String jobUrl = "Job URL";
    private int bandLevelID = 10;
    private String capability = "Job Capability";
    private String bandLevel = "Job Band Level";

    public Job() {
    }
    public Job(int jobID, String jobName, String jobSpec, String jobUrl, int bandLevelID, String capability, String bandLevel) {
        this.setJobID(jobID);
        this.setJobName(jobName);
        this.setJobSpec(jobSpec);
        this.setJobUrl(jobUrl);
        this.setBandLevelID(bandLevelID);
        this.setCapability(capability);
        this.setBandLevel(bandLevel);
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

    public String getCapability() { return capability; }

    public void setCapability(String capability) { this.capability = capability; }

    public String getBandLevel() { return bandLevel; }

    public void setBandLevel(String bandLevel) { this.bandLevel = bandLevel; }
}