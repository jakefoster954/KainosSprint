package com.kainos.ea;

import com.kainos.ea.resources.Job;
import com.kainos.ea.resources.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DTO {
    Class driver = Class.forName("com.mysql.cj.jdbc.Driver");

    protected DTO() throws ClassNotFoundException {
    }

    public static List<Job> retriveJobsFromDB() throws ClassNotFoundException, IOException, SQLException {
        Connection c = DBConnector.getConnection();

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT * FROM KainosSprint.FullData;");
        List<Job> jobs = new ArrayList<Job>();

        while (rs.next())
        {
            jobs.add(new Job(rs.getInt("jobID"),
                    rs.getString("jobName"),
                    rs.getString("jobSpec"),
                    rs.getString("jobUrl"),
                    rs.getInt("bandLevelID"),
                    rs.getString("capabilityName"),
                    rs.getString("bandName")));
        }
        return jobs;
    }
    public static Job addJobToDB(Job job) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        Statement st = c.createStatement();

        String query = "INSERT INTO JobRole VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = c.prepareStatement(query);

        preparedStmt.setInt(1, job.getJobID());
        preparedStmt.setString(2, job.getJobName());
        preparedStmt.setString(3, job.getJobSpec());
        preparedStmt.setString(4, job.getJobUrl());
        preparedStmt.setInt(5, job.getBandLevelID());
        //TODO: change to real FamilyID, when it's implemented
        preparedStmt.setInt(6, 22);


        preparedStmt.execute();
        return job;
    }

    public static List<User> loginUser(User user) throws ClassNotFoundException, IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement st = c.prepareStatement("SELECT * FROM KainosSprint.User WHERE userEmail=? AND userPassword=?;");
        st.setString(1,user.getUserEmail());
        st.setString(2,user.getUserPassword());

        ResultSet rs = st.executeQuery();
        List<User> users = new ArrayList<>();

        while (rs.next())
        {
            users.add(new User(rs.getInt("userID"),
                    rs.getString("userEmail"),
                    rs.getString("userPassword"),
                    rs.getString("userType")));
        }

        return users;
    }
}
