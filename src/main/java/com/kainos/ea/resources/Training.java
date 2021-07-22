package com.kainos.ea.resources;

public class Training {
    private String trainingName;
    private String trainingLink;

    public Training() {
    }

    public Training(String trainingName, String trainingLink) {
        this.trainingName = trainingName;
        this.trainingLink = trainingLink;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainingLink() {
        return trainingLink;
    }

    public void setTrainingLink(String trainingLink) {
        this.trainingLink = trainingLink;
    }
}
