package com.kainos.ea.resources;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;

public class User {
    private String userEmail;
    private String userPassword;
    private String userSessionKey;

    public User(){}

    public User(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String generateSessionKey(String userType) {
        long cookieMaxAge = 3600000;
        String randomStr = RandomStringUtils.randomAlphanumeric(27);
        long timestamp = System.currentTimeMillis() + cookieMaxAge;
        this.userSessionKey = userType.substring(0,4) + randomStr + timestamp;
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

    public String getUserSessionKey() {
        return userSessionKey;
    }

    public void setUserSessionKey(String userSessionKey) {
        this.userSessionKey = userSessionKey;
    }
}
