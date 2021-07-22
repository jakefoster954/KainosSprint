package com.kainos.ea;

import com.kainos.ea.resources.Capability;
import com.kainos.ea.resources.Job;
import com.kainos.ea.resources.User;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
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
     * Add a job to the database.
     * @param job An instance of the Job class containing all the data requested by the job class.
     * @return Status 200. OK if adding succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     * Get JobName, JobSpec, JobUrl, CapabilityName and BandLevelName from frontend.
     * Translates CapabilityName to jobFamilyID and BandLevelName to bandLevelID and sends them to database.
     */
    public static Response.Status addJobToDB(Job job) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement preparedStmt = c.prepareStatement("SELECT capabilityName, jobFamilyID " +
                "FROM FullData WHERE capabilityName = ? ");
        preparedStmt.setString(1, job.getCapabilityName());
        ResultSet rs = preparedStmt.executeQuery();
        if (rs.next()){
            job.setJobFamilyID(rs.getInt("jobFamilyID"));
            preparedStmt = c.prepareStatement("SELECT bandLevelID, bandName FROM FullData WHERE bandName = ? ;");
            preparedStmt.setString(1, job.getBandLevelName());
            rs = preparedStmt.executeQuery();}
        if (rs.next())
            job.setBandLevelID(rs.getInt("bandLevelID"));
        else
            return Response.Status.INTERNAL_SERVER_ERROR;

        preparedStmt = c.prepareStatement("INSERT INTO JobRole (`jobName`, `jobSpec`, `jobURL`, `bandLevelID`, `jobFamilyID`)" +
                "VALUES ( ?, ?, ?, ?, ?)");

        preparedStmt.setString(1, job.getJobName());
        preparedStmt.setString(2, job.getJobSpec());
        preparedStmt.setString(3, job.getJobUrl());
        preparedStmt.setInt(4, job.getBandLevelID());
        preparedStmt.setInt(5, job.getJobFamilyID());
        preparedStmt.execute();

        return Response.Status.OK;
    }

    /**
     * Delete a job from the database.
     * @param jobRoleName The name of the job you want to delete.
     * @return Status 200. OK if deleting succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     * Get jobRoleName from path and deletes the corresponding record from database.
     */
    public static Response.Status deleteJobFromDB(String jobRoleName) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement preparedStmt = c.prepareStatement("SELECT `jobName` FROM `KainosSprint`.`JobRole` WHERE (`jobName` = ?)");
        preparedStmt.setString(1, jobRoleName);
        ResultSet rs = preparedStmt.executeQuery();
        if (!rs.next())
            return Response.Status.INTERNAL_SERVER_ERROR;

        preparedStmt = c.prepareStatement("DELETE FROM `KainosSprint`.`JobRole` WHERE (`jobName` = ?)");
        preparedStmt.setString(1, jobRoleName);
        preparedStmt.execute();
        return Response.Status.OK;
    }

    /**
     * Get the user with valid credentials from database.
     * @param user An object holding the username and a hash of the password.
     * @return Corresponding user if valid credentials. Null otherwise.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     */
    public static String loginUser(User user) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement st = c.prepareStatement(
                "SELECT * FROM KainosSprint.User WHERE userEmail=? AND userPassword=?;");
        st.setString(1, user.getUserEmail());
        st.setString(2, user.getUserPassword());

        ResultSet rs = st.executeQuery();

        if(rs.next()) {
            //Generate session key
            String sessionKey = user.generateSessionKey(rs.getString("userType"));
            int userID = rs.getInt("UserID");

            //Store session key
            st = c.prepareStatement(
                    "UPDATE User SET userSessionKey = ? where userID = ?;");
            st.setString(1, sessionKey);
            st.setInt(2, userID);
            st.execute();

            return sessionKey;
        }
        return null;
    }

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
     * Get a list of json objects where each JSON object holds "name" as the key and the capability lead name as the value.
     * The length of the list is equivalent to the number of capability leads in the table.
     * @return A JSONArray of JSONObjects that hold all the capability lead names.
     * @throws IOException  Create connection to database.
     * @throws SQLException Invalid SQL syntax.
     */
    public static JSONArray getCapabilityLeadNames() throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT leadName FROM KainosSprint.CapabilityLead;");

        JSONArray capabilityLeadNames = new JSONArray();
        while (rs.next()) {
            JSONObject row = new JSONObject();
            row.put("name", rs.getString("leadName"));
            capabilityLeadNames.put(row);
        }
        return capabilityLeadNames;
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
        ResultSet rs = st.executeQuery("SELECT * FROM KainosSprint.JobNamesView;");

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

        PreparedStatement st = c.prepareStatement("SELECT * FROM KainosSprint.FullJobDataView WHERE jobName = ?;");
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

        PreparedStatement preparedStmt = c.prepareStatement("SELECT * FROM KainosSprint.CapabilitiesView;");
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
                "SELECT * FROM KainosSprint.FullCapabilityDataView WHERE leadName = ?;");
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

    /**
     * Edit a job in database.
     * Searches database for JobRole with jobID passed from frontend. If found- edits the JobRole with passed data.
     * @param job An instance of the Job class containing all the data requested by the job class.
     * @return Status 200. OK if editing succeeds. Status 500. Internal Server Error otherwise.
     * @throws IOException  Create connection to database.
     * @throws SQLException Invalid SQL syntax.
     * @deprecated This will not probably be implemented in fronted till the end of project
     */
    public static Response.Status editJobFromDB(Job job) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement preparedStmt = c.prepareStatement("SELECT `jobName` FROM KainosSprint.JobRole WHERE `jobID` = ? ");
        preparedStmt.setInt(1, job.getJobID());

        ResultSet rs = preparedStmt.executeQuery();
        if(!rs.next())
            return Response.Status.INTERNAL_SERVER_ERROR;

        preparedStmt = c.prepareStatement("UPDATE `KainosSprint`.`JobRole` " +
                "SET `jobName`= ?, `jobSpec`= ?, `jobURL` = ?, `bandLevelID` = ?, `jobFamilyID`= ? " +
                "WHERE `jobID`= ? ");

        preparedStmt.setString(1, job.getJobName());
        preparedStmt.setString(2, job.getJobSpec());
        preparedStmt.setString(3, job.getJobUrl());
        preparedStmt.setInt(4, job.getBandLevelID());
        preparedStmt.setInt(5, job.getJobFamilyID());
        preparedStmt.setInt(6, job.getJobID());
        preparedStmt.execute();

        return Response.Status.OK;
    }

    /**
     * Add a capability to the database.
     * @param capability An instance of the Capability class containing all the data requested by the capability class.
     * @return Status 200. OK if adding succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     * Get CapabilityName from frontend and checks if it already exists.
     * Get CapabilityName from frontend and sends them to database.
     * Get familyName from frontend and connects Capability with JobFamily in database
     * Checks if Lead sent from frontend exists and eventually adds LeadID it to Capability
     */
    public static Response.Status addCapabilityToDB(Capability capability) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement preparedStmt = c.prepareStatement("SELECT capabilityName FROM Capability " +
                "WHERE capabilityName = ? ");
        preparedStmt.setString(1, capability.getCapabilityName());
        ResultSet rs = preparedStmt.executeQuery();
        if (rs.next())
            return Response.Status.INTERNAL_SERVER_ERROR;

        preparedStmt = c.prepareStatement("INSERT INTO Capability (`capabilityName`) VALUES (?)");
        preparedStmt.setString(1, capability.getCapabilityName());
        preparedStmt.execute();

        if(!capability.getCapabilityJobFamilyName().isEmpty()) {
            preparedStmt = c.prepareStatement("SELECT capabilityID FROM Capability WHERE capabilityName = ? ");
            preparedStmt.setString(1, capability.getCapabilityName());
            rs = preparedStmt.executeQuery();
            if (rs.next()) {
                preparedStmt = c.prepareStatement("INSERT INTO JobFamily (`familyName`, `capabilityID`) VALUES ( ?, ?)");
                preparedStmt.setString(1, capability.getCapabilityJobFamilyName());
                preparedStmt.setString(2, rs.getString("capabilityID"));
                preparedStmt.execute();
            }
        }

        preparedStmt = c.prepareStatement("SELECT leadID from CapabilityLead WHERE leadName = ?;");
        preparedStmt.setString(1, capability.getLeadName());
        rs = preparedStmt.executeQuery();
        if (rs.next()) {
            preparedStmt = c.prepareStatement("UPDATE Capability SET `leadID` = ? WHERE (`capabilityName` = ?);");
            preparedStmt.setInt(1, rs.getInt("leadID"));
            preparedStmt.setString(2, capability.getCapabilityName());
            preparedStmt.execute();
        }

        return Response.Status.OK;
    }

    /**
     * Delete a capability from the database.
     * Gets capabilityName from path and deletes the corresponding record from database.
     * @param capabilityName The name of the capability you want to delete.
     * @return Status 200. OK if deleting succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     */
    public static Response.Status deleteCapabilityFromDB(String capabilityName) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement preparedStmt = c.prepareStatement("SELECT capabilityName FROM Capability WHERE capabilityName = ?");
        preparedStmt.setString(1, capabilityName);
        ResultSet rs = preparedStmt.executeQuery();
        if (!rs.next())
            return Response.Status.INTERNAL_SERVER_ERROR;

        preparedStmt = c.prepareStatement("DELETE FROM Capability WHERE capabilityName = ?");
        preparedStmt.setString(1, capabilityName);
        preparedStmt.execute();
        return Response.Status.OK;
    }

    /**
     * Will return true if the session Key is in the database. False otherwise.
     * @param sessionKey The session key of the session that validates the user.
     * @return true if key is in database. False otherwise.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    public static boolean isSessionKeyInDB(String sessionKey) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement preparedStmt = c.prepareStatement("SELECT userSessionKey FROM User WHERE userSessionKey = ?");
        preparedStmt.setString(1, sessionKey);
        ResultSet rs = preparedStmt.executeQuery();

        return rs.next();
    }

    /**
     * Delete the session key provided from the database if the key provided is in the database.
     * @param sessionKey The session key of the session that validates the user.
     * @return 500 if SQL Query fails. 200 otherwise.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    public static Response.Status deleteSessionKey(String sessionKey) throws IOException, SQLException {
        Connection c = DBConnector.getConnection();

        PreparedStatement preparedStmt = c.prepareStatement("SELECT userSessionKey FROM KainosSprint.User WHERE userSessionKey = ?");
        preparedStmt.setString(1, sessionKey);
        ResultSet rs = preparedStmt.executeQuery();
        if (!rs.next())
            return Response.Status.INTERNAL_SERVER_ERROR;

        preparedStmt = c.prepareStatement("UPDATE `KainosSprint`.`User` " +
                        "SET `userSessionKey`= NULL " +
                        "WHERE `userSessionKey`= ?;");
        preparedStmt.setString(1, sessionKey);
        preparedStmt.execute();
        return Response.Status.OK;
    }
}
