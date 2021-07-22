package com.kainos.ea.resources.webservice;

import com.codahale.metrics.annotation.Timed;

import javax.servlet.http.Cookie;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kainos.ea.DTO;
import com.kainos.ea.resources.Capability;
import com.kainos.ea.resources.Job;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Handles all endpoints only an employee or admin can access.
 */
@Path("/api/employee")
public class EmployeeService extends WebService {
    /**
     * Defines the permission levels for the /api/employee endpoint.
     */
    private final List<PermissionLevel> permissionLevels = Arrays.asList(PermissionLevel.EMPLOYEE, PermissionLevel.ADMIN);

    /**
     * Get a list of all capability names in the Database.
     *
     * @param sessionCookie The session key contained in a cookie. Used to authenticate user at endpoint.
     * @return A String representing a list of JSON objects.
     * Each object contains "name" as the key and the capability name as the value.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getCapabilities")
    public Response getCapabilityNames(@CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return Response.status(response).build();

        logger.info("getCapabilityNames endpoint reached");
        JSONArray capabilities = DTO.getCapabilities();
        return Response.ok(capabilities.toString()).build();
    }

    /**
     * Get a list of all band level names in the Database.
     * Each object contains "name" as the key and the band level name as the value.
     *
     * @param sessionCookie The session key contained in a cookie. Used to authenticate user at endpoint.
     * @return A String representing a list of JSON objects.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getBandLevels")
    public Response getBandNames(@CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return Response.status(response).build();

        logger.info("getBandNames endpoint reached");
        JSONArray bandNames = DTO.getBandNames();
        return Response.ok(bandNames.toString()).build();
    }

    /**
     * Get a list of all capability lead names in the Database.
     * Each object contains "name" as the key and the capability lead name as the value.
     *
     * @param sessionCookie The session key contained in a cookie. Used to authenticate user at endpoint.
     * @return A String representing a list of JSON objects.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getCapabilityLeadNames")
    public Response getCapabilityLeadNames(@CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return Response.status(response).build();

        logger.info("getCapabilityLeadNames endpoint reached");
        JSONArray capabilityLeadNames = DTO.getCapabilityLeadNames();
        return Response.ok(capabilityLeadNames.toString()).build();
    }

    /**
     * Get the data required to display the <code>job-roles</code> table.
     * Each JSON object returned will contain <code>jobName</code>,
     * <code>capabilityName</code> and <code>bandName</code>.
     *
     * @param sessionCookie The session key contained in a cookie. Used to authenticate user at endpoint.
     * @return A String representing a list of JSON objects.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getJobNames")
    public Response getJobNames(@CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return Response.status(response).build();

        logger.info("getJobNames endpoint reached");
        JSONArray jobNames = DTO.getJobNames();
        return Response.ok(jobNames.toString()).build();
    }

    /**
     * Get the data required to display a job info page.
     * The json object will contain the <code>jobName</code>, <code>jobSpec</code>, <code>jobUrl</code>,
     * <code>capabilityName</code> and <code>bandName</code>.
     *
     * @param jobName The name of the job you want data on.
     * @param sessionCookie The session key contained in a cookie. Used to authenticate user at endpoint.
     * @return A String representing a json object that contains all the info about a specific job. 404 if not found.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getJobData/{jobName}")
    public Response getJobData(@PathParam("jobName") String jobName, @CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return Response.status(response).build();

        logger.info(String.format("getJobData endpoint reached. '%s' requested", jobName));
        JSONObject jobData = DTO.getJobData(jobName);
        if (jobData.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(jobData.toString()).build();
    }

    /**
     * Get the data required to display the <code>capabilities</code> table.
     * Each JSON object returned will contain <code>capabilityName</code> and the <code>leadName</code>.
     *
     * @param sessionCookie The session key contained in a cookie. Used to authenticate user at endpoint.
     * @return a String representing a list of JSON objects.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getCapabilityLeads")
    public Response getCapabilityLeads(@CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return Response.status(response).build();

        logger.info("getCapabilityLeads endpoint reached");
        JSONArray capabilityLeads = DTO.getCapabilityLeads();
        return Response.ok(capabilityLeads.toString()).build();
    }

    /**
     * Get the data required to display a capability lead info page.
     * The json object will contain the <code>capabilityName</code>, <code>leadName</code>,
     * <code>leadMessage</code> and <code>leadPhoto</code>.
     * The <code>leadPhoto</code> is stored as a url in the database.
     *
     * @param leadName The name of the capability lead you want data on.
     * @param sessionCookie The session key contained in a cookie. Used to authenticate user at endpoint.
     * @return A String representing a json object that contains all the info about a specific job. 404 if not found.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getCapabilityLeadData/{leadName}")
    public Response getCapabilityLeadData(@PathParam("leadName") String leadName, @CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return Response.status(response).build();

        logger.info(String.format("getJobData endpoint reached. '%s' requested", leadName));
        JSONObject capabilityLeadData = DTO.getCapabilityLeadData(leadName);
        if (capabilityLeadData.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(capabilityLeadData.toString()).build();
    }

    /**
     * Delete the session key from the database.
     * The user must be logged in to be able to log out successfully.
     *
     * @param sessionCookie The session key as a cookie.
     * @return Response code 200 if successful. Response code 500 if something goes wrong with SQL query. Response code 401 if user is not logged in. Response code 403 if user is logged in with invalid cookie.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    @DELETE
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/logout")
    public Response logout(@CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return Response.status(response).build();

        logger.info("logout endpoint reached");
        return Response.status(DTO.deleteSessionKey(sessionCookie)).build();
    }

    /**
     * Get the relevant training data for specific band.
     * The json array will consist of objects containing the <code>trainingName</code> and <code>trainingLink</code>
     * @param bandLevel The band level for which you want to view training.
     * @param sessionCookie The session key as a cookie.
     * @return A String representing a json array that contains all the training about a specific band.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getTrainingData/{bandLevel}")
    public Response getTrainingData(@PathParam("bandLevel") String bandLevel, @CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return Response.status(response).build();

        logger.info(String.format("getTrainingData endpoint reached. '%s' requested", bandLevel));
        JSONArray trainingData = DTO.getTrainingDataForBand(bandLevel);
        return Response.ok(trainingData.toString()).build();
    }
}