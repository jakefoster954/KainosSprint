package com.kainos.ea.resources;

/**
 * Holds all the data about a job.
 * This mirrors the fields in the Database and is the return type of the database queries.
 */
public class Job {

    /**
     * The unique ID for the job.
     */
    private int jobID;

    /**
     * The name of the job.
     */
    private String jobName;

    /**
     * A short description of the job.
     */
    private String jobSpec;

    /**
     * A URL that points to the official documentation for the job.
     */
    private String jobUrl;
    /**
     * The band level ID of the band level the job is in.
     */
    private int bandLevelID;

    /**
     * The name of the band level.
     */
    private String bandLevelName;

    /**
     * The name of the job capability.
     */
    private String capabilityName;

    /**
     * The ID of the job family.
     */
    private int jobFamilyID;

    /**
     * The ID of the job family.
     */
    private String jobFamilyName;

    /**
     * Create a job with test data.
     */
    public Job() {
        jobID = 0;
        jobName = "Default job name";
        jobSpec = "Default job Spec";
        jobUrl = "Default job URL";
        bandLevelID = 99;
        bandLevelName = "Default job Band Level name";
        capabilityName = "Default job Capability";
        jobFamilyID = 11;
        jobFamilyName = "Default job Job Family name";
    }

    /**
     * Creates an instance of the <code>Job</code> class with the following data.
     *
     * @param jobID The ID of the job. This is not known to the user and its only purpose is to be a primary key for the Job table.
     * @param jobName The name of the job.
     * @param jobSpec A short description of the job.
     * @param jobUrl The url where the official job information is located.
     * @param bandLevelID The ID of the band level. This is not known to the user and its only purpose is to be a primary key for the BandLevel table.
     * @param capabilityName The name of the capability the job belongs to.
     * @param bandLevelName The name of the band level the job belongs to.
     * @param jobFamilyID The ID of the job family. This is not known to the user and its only purpose is to be a primary key for the JobFamily table.
     */
    public Job(int jobID, String jobName, String jobSpec, String jobUrl, int bandLevelID, String capabilityName, String bandLevelName, int jobFamilyID) {
        this.setJobID(jobID);
        this.setJobName(jobName);
        this.setJobSpec(jobSpec);
        this.setJobUrl(jobUrl);
        this.setBandLevelID(bandLevelID);
        this.setCapabilityName(capabilityName);
        this.setBandLevelName(bandLevelName);
        this.setJobFamilyID(jobFamilyID);
    }

    public void splitCapabilityAndJobFamily() {
        jobFamilyName = capabilityName.split("/ ")[1];
        capabilityName = capabilityName.split("/ ")[0];
    }

    /**
     * Get the <code>jobID</code> if the <code>jobID</code> exists.
     * @return The ID of the job.
     */
    public int getJobID() {
        return jobID;
    }

    /**
     * Set a unique ID for the job.
     * @param jobID the ID of the job.
     */
    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    /**
     * Get the <code>jobName</code> if the <code>jobName</code> exists.
     * @return The name of the job.
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * Get the <code>jobName</code> if the <code>jobName</code> exists.
     * All spaces in the jobName will be replaced with hyphens.
     * @return The name of the job.
     */
    public String getJobNameAsURL() {
        return jobName.replace(" ", "-");
    }

    /**
     * Set the name of the job.
     * @param jobName The name of the job.
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * Get a description of the job.
     * @return The name of the job.
     */
    public String getJobSpec() {
        return jobSpec;
    }

    /**
     * Set a short description for this job.
     * @param jobSpec A short description of the job role.
     */
    public void setJobSpec(String jobSpec) {
        this.jobSpec = jobSpec;
    }

    /**
     * Get the url pointing to the location where you can find out more information about the job.
     * @return The url that points to the job description.
     */
    public String getJobUrl() {
        return jobUrl;
    }

    /**
     * Set the url where you can find out more information about the job.
     * @param jobUrl A url pointing to the official documentation for this job.
     */
    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    /**
     * Get the ID of the band level the job belongs to.
     * @return The ID of the band level the job belongs to.
     */
    public int getBandLevelID() {
        return bandLevelID;
    }

    /**
     * Set the ID that corresponds to the band level of the job.
     * @param bandLevelID The ID of the band level the job belongs to.
     */
    public void setBandLevelID(int bandLevelID) {
        this.bandLevelID = bandLevelID;
    }

    /**
     * Get the name of the capability the job belongs to.
     * @return The name of the capability.
     */
    public String getCapabilityName() { return capabilityName; }

    /**
     * Set the name of the capability.
     * @param capabilityName The name of  the capability.
     */
    public void setCapabilityName(String capabilityName) { this.capabilityName = capabilityName; }

    /**
     * Get the name of the band the job belongs to.
     * @return The name of the band the job belongs to.
     */
    public String getBandLevelName() { return bandLevelName; }

    /**
     * Set the name of the band level.
     * @param bandLevelName The name of the band the job belongs to.
     */
    public void setBandLevelName(String bandLevelName) { this.bandLevelName = bandLevelName; }

    /**
     * Get the ID of the job family.
     * @return The ID of the job family.
     */
    public int getJobFamilyID() { return jobFamilyID; }

    /**
     * Set the ID that corresponds to the job family.
     * @param jobFamilyID The ID of the job family.
     */
    public void setJobFamilyID(int jobFamilyID) { this.jobFamilyID = jobFamilyID; }

    /**
     * Get the Name of the job family.
     * @return The Name of the job family.
     */
    public String getJobFamilyName() { return jobFamilyName; }

    /**
     * Set the Name that corresponds to the job family.
     * @param jobFamilyName The Name of the job family.
     */
    public void setJobFamilyName(String jobFamilyName) { this.jobFamilyName = jobFamilyName; }
}