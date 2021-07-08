package com.kainos.ea;

import com.kainos.ea.resources.Job;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DTO {
    public static List<Job> retriveJobsFromDB() throws ClassNotFoundException, IOException, SQLException {
        Class driver = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DBConnector.getConnection();

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT * FROM KainosSprint.JobRole ORDER BY bandLevelID DESC;");
        List<Job> jobs = new ArrayList<Job>();

        while (rs.next())
        {
            jobs.add(new Job(rs.getInt("jobID"),
                    rs.getString("jobName"),
                    rs.getString("jobSpec"),
                    rs.getString("jobUrl"),
                    rs.getInt("bandLevelID")));
        }
        return jobs;
    }
}