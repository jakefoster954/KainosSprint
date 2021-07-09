package com.kainos.ea;

import com.kainos.ea.resources.Job;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
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
}
