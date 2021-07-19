package com.kainos.ea.resources;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;

public class User {
    private int userID = 0;
    private String userEmail;
    private String userPassword;
    private String userType = "N/A";
    private String userSessionKey;

    public User(){}

    public User(int userID, String userEmail, String userPassword, String userType) {
        this.userID = userID;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public void generateSessionKey() {
        String randomStr = RandomStringUtils.randomAlphanumeric(27);
        long timestamp = System.currentTimeMillis() + 3600000;
        this.userSessionKey = this.userType + randomStr + timestamp;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserSessionKey() {
        return userSessionKey;
    }

    public void setUserSessionKey(String userSessionKey) {
        this.userSessionKey = userSessionKey;
    }
}
