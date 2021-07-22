package com.kainos.ea.resources;

public class Capability {
    private int capabilityID;
    private String capabilityName;
    private String leadName;
    private String leadMessage;
    private String leadPhoto;
    private String capabilityJobFamilyName = "";

    public Capability() {}

    public Capability(int capabilityID, String capabilityName, String leadName, String leadMessage, String leadPhoto) {
        this.capabilityID = capabilityID;
        this.capabilityName = capabilityName;
        this.leadName = leadName;
        this.leadMessage = leadMessage;
        this.leadPhoto = leadPhoto;
    }

    public Capability(int capabilityID, String capabilityName, String leadName, String leadMessage, String leadPhoto, String capabilityJobFamilyName) {
        this.capabilityID = capabilityID;
        this.capabilityName = capabilityName;
        this.leadName = leadName;
        this.leadMessage = leadMessage;
        this.leadPhoto = leadPhoto;
        this.capabilityJobFamilyName = capabilityJobFamilyName;
    }

    public int getCapabilityID() {
        return capabilityID;
    }

    public void setCapabilityID(int capabilityID) {
        this.capabilityID = capabilityID;
    }

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public String getLeadName() {
        return leadName;
    }

    public String getLeadNameAsURL() {
        return leadName.replace(" ", "-");
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public String getLeadMessage() {
        return leadMessage;
    }

    public void setLeadMessage(String leadMessage) {
        this.leadMessage = leadMessage;
    }

    public String getLeadPhoto() {
        return leadPhoto;
    }

    public void setLeadPhoto(String leadPhoto) {
        this.leadPhoto = leadPhoto;
    }

    public String getCapabilityJobFamilyName() {
        return capabilityJobFamilyName;
    }

    public void setCapabilityJobFamilyName(String capabilityJobFamilyName) {
        this.capabilityJobFamilyName = capabilityJobFamilyName;
    }
}
