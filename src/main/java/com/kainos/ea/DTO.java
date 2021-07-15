package com.kainos.ea;

import com.kainos.ea.resources.Capability;
import com.kainos.ea.resources.Job;
import com.kainos.ea.resources.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles all connections to the database.
 */
public abstract class DTO {
    /**
     * Ensures the JDBC driver is available.
     */
    private Class driver = Class.forName("com.mysql.cj.jdbc.Driver");


    /**
     * Base constructor. Never used.
     * @throws ClassNotFoundException ???
     */
    private DTO() throws ClassNotFoundException {
    }

    /**
     * @return A list of job objects.
     * @throws SQLException           Invalid SQL syntax
     * @throws IOException            Create connection to database.
     * @deprecated Should use smaller method calls instead.
     * Get all jobs from the data base.
     * Returns jobID, jobName, jobSpec, jobUrl, bandLevelID, bandName, jobFamilyID for all jobs in the database.
     */
    public static List<Job> retrieveJobsFromDB() throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement preparedStmt = c.prepareStatement("SELECT * FROM KainosSprint.FullData;");
        ResultSet rs = preparedStmt.executeQuery();
      
        List<Job> jobs = new ArrayList<>();

        while (rs.next()) {
            jobs.add(new Job(rs.getInt("jobID"),
                    rs.getString("jobName"),
                    rs.getString("jobSpec"),
                    rs.getString("jobUrl"),
                    rs.getInt("bandLevelID"),
                    rs.getString("capabilityName"),
                    rs.getString("bandName"),
                    rs.getInt("jobFamilyID")));
        }
        return jobs;
    }

    /**
     * @return A list of capability objects.
     * @throws SQLException           Invalid SQL syntax.
     * @throws IOException            Create connection to database.
     * @deprecated Should use smaller method calls instead.
     * Get all capabilities from the database.
     * Returns capabilityID, capabilityName, leadName, leadMessage, leadPhoto for all capabilities in the database.
     */
    public static List<Capability> retrieveCapabilitiesFromDB() throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement preparedStmt = c.prepareStatement("SELECT * FROM KainosSprint.Capability;");
        ResultSet rs = preparedStmt.executeQuery();

        List<Capability> capabilities = new ArrayList<>();

        while (rs.next()) {
            capabilities.add(new Capability(rs.getInt("capabilityID"),
                    rs.getString("capabilityName"),
                    rs.getString("leadName"),
                    rs.getString("leadMessage"),
                    rs.getString("leadPhoto")));
        }

        return capabilities;
    }

    public static void addJobToDB(Job job) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement preparedStmt = c.prepareStatement(
          String.format("SELECT capabilityName, jobFamilyID FROM FullData WHERE capabilityName = '%s' ", job.getCapabilityName()));
        ResultSet rs = preparedStmt.executeQuery();
        if (rs.next())
            job.setJobFamilyID(rs.getInt("jobFamilyID"));

        preparedStmt = c.prepareStatement(
                String.format("SELECT bandLevelID, bandName FROM FullData WHERE bandName = '%s' ;", job.getBandLevelName()));
        rs = preparedStmt.executeQuery();
        if (rs.next())
            job.setBandLevelID(rs.getInt("bandLevelID"));

        preparedStmt = c.prepareStatement("INSERT INTO JobRole (`jobName`, `jobSpec`, `jobURL`, `bandLevelID`, `jobFamilyID`)" +
                "VALUES ( ?, ?, ?, ?, ?)");

        preparedStmt.setString(1, job.getJobName());
        preparedStmt.setString(2, job.getJobSpec());
        preparedStmt.setString(3, job.getJobUrl());
        preparedStmt.setInt(4, job.getBandLevelID());
        preparedStmt.setInt(5, job.getJobFamilyID());

        preparedStmt.execute();
    }

    public static void deleteJobFromDB(String jobRoleName) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        String query = "DELETE FROM `KainosSprint`.`JobRole` WHERE (`jobName` = ?)";

        PreparedStatement preparedStmt = c.prepareStatement(query);

        preparedStmt.setString(1, jobRoleName);

        preparedStmt.execute();
    }

    public static List<User> loginUser(User user) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement st = c.prepareStatement(
                "SELECT * FROM KainosSprint.User WHERE userEmail=? AND userPassword=?;");
        st.setString(1, user.getUserEmail());
        st.setString(2, user.getUserPassword());

        ResultSet rs = st.executeQuery();
        List<User> users = new ArrayList<>();

        while (rs.next()) {
            users.add(new User(rs.getInt("userID"),
                    rs.getString("userEmail"),
                    rs.getString("userPassword"),
                    rs.getString("userType")));
        }
        return users;
    }

    // NEW ENDPOINTS

    /**
     * Get a list of json objects where each JSON object holds "name" as the key and the capability name as the value.
     * The length of the list is equivalent to the number of capabilities in the table.
     * The <code>CapabilityName</code> is a unique field in the database.
     * @return A JSONArray of JSONObjects that hold all the capabilities
     * @throws IOException  Create connection to database.
     * @throws SQLException Invalid SQL syntax.
     */
    public static JSONArray getCapabilities() throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT capabilityName FROM KainosSprint.Capability;");

        JSONArray capabilities = new JSONArray();
        while (rs.next()) {
            JSONObject row = new JSONObject();
            row.put("name", rs.getString("capabilityName"));
            capabilities.put(row);
        }
        return capabilities;
    }

    /**
     * Get a list of json objects where each JSON object holds "name" as the key and the band level name as the value.
     * The length of the list is equivalent to the number of capabilities in the table.
     * The <code>bandName</code> is a unique field in the database.
     * @return A JSONArray of JSONObjects that hold all the band level names.
     * @throws IOException  Create connection to database.
     * @throws SQLException Invalid SQL syntax.
     */
    public static JSONArray getBandNames() throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT bandName FROM KainosSprint.BandLevel;");

        JSONArray bandNames = new JSONArray();
        while (rs.next()) {
            JSONObject row = new JSONObject();
            row.put("name", rs.getString("bandName"));
            bandNames.put(row);
        }
        return bandNames;
    }

    /**
     * Get a list of json objects where each JSON object holds the
     * <code>jobName</code>, <code>capabilityName</code> and <code>bandName</code>.
     * The length of the list is equivalent to the number of jobs in the table.
     * The <code>jobName</code> is a unique field in the database.
     * @return A JSONArray of JSONObjects that hold all the data needed for the <code>job-roles</code> contents page.
     * @throws IOException  Create connection to database.
     * @throws SQLException Invalid SQL syntax.
     */
    public static JSONArray getJobNames() throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                        "SELECT jobName, capabilityName, bandName " +
                        "FROM (((JobRole " +
                        "INNER JOIN JobFamily ON JobFamily.jobFamilyID = JobRole.jobFamilyID) " +
                        "INNER JOIN Capability ON Capability.capabilityID = JobFamily.capabilityID) " +
                        "INNER JOIN BandLevel ON BandLevel.bandLevelID = JobRole.bandLevelID);");

        JSONArray jobRolesTable = new JSONArray();
        while (rs.next()) {
            JSONObject row = new JSONObject();
            row.put("jobName", rs.getString("jobName"));
            row.put("capabilityName", rs.getString("capabilityName"));
            row.put("bandName", rs.getString("bandName"));
            jobRolesTable.put(row);
        }
        return jobRolesTable;
    }

    /**
     * Get a json object that holds the
     * <code>jobName</code>, <code>jobSpec</code>, <code>jobUrl</code>,
     * <code>capabilityName</code> and <code>bandName</code>.
     * This will only return one object. Not a list of objects.
     * @param jobName The name of the job you wish to view information about.
     * @return A JSONObject that hold all the data that needs to be displayed for a specific job role.
     * @throws IOException  Create connection to database.
     * @throws SQLException Invalid SQL syntax.
     */
    public static JSONObject getJobData(String jobName) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement st = c.prepareStatement(
                "SELECT jobName, jobSpec, jobUrl, capabilityName, bandName " +
                        "FROM (((JobRole " +
                        "INNER JOIN JobFamily ON JobFamily.jobFamilyID = JobRole.jobFamilyID) " +
                        "INNER JOIN Capability ON Capability.capabilityID = JobFamily.capabilityID) " +
                        "INNER JOIN BandLevel ON BandLevel.bandLevelID = JobRole.bandLevelID) " +
                        "WHERE jobName = ?;");
        st.setString(1, jobName);
        ResultSet rs = st.executeQuery();

        JSONObject jobData = new JSONObject();
        while (rs.next()) {
            jobData.put("jobName", rs.getString("jobName"));
            jobData.put("jobSpec", rs.getString("jobSpec"));
            jobData.put("jobUrl", rs.getString("jobUrl"));
            jobData.put("capabilityName", rs.getString("capabilityName"));
            jobData.put("bandName", rs.getString("bandName"));
        }
        return jobData;
    }

    /**
     * Get a list of json objects where each JSON object holds the <code>capabilityName</code> and the <code>leadName</code>.
     * The <code>capabilityName</code> is the name of the capability and the <code>leadName</code> is the leader of said capability.
     * The length of the list is equivalent to the number of capabilities in the table.
     * Each capability only has one lead.
     * The <code>CapabilityName</code> is a unique field in the database.
     * @return A JSONArray of JSONObjects that hold all the capabilities
     * @throws IOException  Create connection to database.
     * @throws SQLException Invalid SQL syntax.
     */
    public static JSONArray getCapabilityLeads() throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement preparedStmt = c.prepareStatement("SELECT capabilityName, leadName FROM KainosSprint.Capability;");
        ResultSet rs = preparedStmt.executeQuery();

        JSONArray capabilities = new JSONArray();
        while (rs.next()) {
            JSONObject row = new JSONObject();
            row.put("capabilityName", rs.getString("capabilityName"));
            row.put("leadName", rs.getString("leadName"));
            capabilities.put(row);
        }
        return capabilities;
    }

    /**
     * Get a json object that holds the
     * <code>capabilityName</code>, <code>leadName</code>, <code>leadMessage</code> and <code>leadPhoto</code>.
     * The <code>leadPhoto</code> is stored as a url in the database.
     * This will only return one object. Not a list of objects.
     * @param leadName The name of the capability lead you wish to view information about.
     * @return A JSONObject that hold all the data that needs to be displayed for a specific capability lead.
     * @throws IOException  Create connection to database.
     * @throws SQLException Invalid SQL syntax.
     */
    public static JSONObject getCapabilityLeadData(String leadName) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement st = c.prepareStatement(
                "SELECT capabilityName, leadName, leadMessage, leadPhoto " +
                        "FROM Capability " +
                        "WHERE leadName = ?;");
        st.setString(1, leadName);
        ResultSet rs = st.executeQuery();

        JSONObject capabilityData = new JSONObject();
        while (rs.next()) {
            capabilityData.put("capabilityName", rs.getString("capabilityName"));
            capabilityData.put("leadName", rs.getString("leadName"));
            capabilityData.put("leadMessage", rs.getString("leadMessage"));
            capabilityData.put("leadPhoto", rs.getString("leadPhoto"));
        }
        return capabilityData;
    }

    public static Boolean editJobFromDB(Job job) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        String query = String.format("SELECT `jobName` FROM KainosSprint.JobRole WHERE `jobID` = %d ", job.getJobID());
        PreparedStatement preparedStmt = c.prepareStatement(query);

        ResultSet rs = preparedStmt.executeQuery();
        if(!rs.next())
            return false;

        query = String.format("UPDATE `KainosSprint`.`JobRole` " +
                "SET `jobName`= ?, `jobSpec`= ?, `jobURL` = ?, `bandLevelID` = ?, `jobFamilyID`= ? " +
                "WHERE `jobID`= %d ", job.getJobID());

        preparedStmt = c.prepareStatement(query);

        preparedStmt.setString(1, job.getJobName());
        preparedStmt.setString(2, job.getJobSpec());
        preparedStmt.setString(3, job.getJobUrl());
        preparedStmt.setInt(4, job.getBandLevelID());
        preparedStmt.setInt(5, job.getJobFamilyID());

        preparedStmt.execute();
        return true;
    }
}
