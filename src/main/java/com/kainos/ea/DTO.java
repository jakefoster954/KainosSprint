package com.kainos.ea;

import com.kainos.ea.resources.Job;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class DTO {
    public static List<Job> retriveJobsFromDB() throws ClassNotFoundException, IOException, SQLException {
        Class driver = Class.forName("com.mysql.cj.jdbc.Driver");
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
}
