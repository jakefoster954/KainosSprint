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
 * Handles all api calls from our front end application.
 */
@Path("/api/employee")
public class EmployeeService extends WebService {
    private final List<PermissionLevel> permissionLevels = Arrays.asList(PermissionLevel.EMPLOYEE, PermissionLevel.ADMIN);

    /**
     * @deprecated Should only be used if database is unavailable.
     * Get a fake list of job roles.
     * Was created to aid those who couldn't connect to VPN.
     * @return Full list of Jobs in the database.
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/helloWorld")
    public List<Job> getHelloWorld() {
            logger.info("getHelloWorld endpoint reached");

            // testing log levels
            logger.debug("debug");
            logger.trace("trace");
            logger.info("info");
            logger.warn("warn");
            logger.error("error");
            logger.fatal("fatal");
            List<Job> jobs = Arrays.asList(new Job());
            return jobs;
    }

    /**
     @deprecated
     * Get a list of job roles from the database.
     * @return Full list of Job objects.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     * @throws ClassNotFoundException ???
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/job-roles")
    public List<Job> getJobRoles() throws SQLException, IOException, ClassNotFoundException {
            List<Job> jobs = DTO.retrieveJobsFromDB();
            return jobs;
    }

    /**
     * @deprecated
     * @param jobName The job that has been selected.
     * @return All the information about the required job.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     * @throws ClassNotFoundException ???
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/job-roles/{jobName}")
    public Job getJobSpec(@PathParam("jobName") String jobName) throws SQLException, IOException, ClassNotFoundException {
        Job job = DTO.retrieveJobsFromDB().stream().filter(j-> j.getJobNameAsURL().equals(jobName)).findFirst().get();
        return job;
    }

    /**
     * @deprecated
     * Get a list of all the capabilities.
     * @return A list of all the capabilities
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     * @throws ClassNotFoundException ???
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/capabilities")
    public List<Capability> getCapabilities() throws SQLException, IOException, ClassNotFoundException {
        List<Capability> capabilities = DTO.retrieveCapabilitiesFromDB();
        System.out.println(capabilities);
        return capabilities;
    }

    /**
     * @deprecated
     * @param leadName The name of the lead for the selected capability.
     * @return An object containing all the information on the capability lead.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     * @throws ClassNotFoundException ???
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/capabilities/{leadName}")
    public Capability getLeadData(@PathParam("leadName") String leadName) throws SQLException, IOException, ClassNotFoundException {
        System.out.println(leadName);
        Capability capability = DTO.retrieveCapabilitiesFromDB().stream().filter(c-> c.getLeadNameAsURL().equals(leadName)).findFirst().get();
        return capability;
    }

    // NEW ENDPOINTS

    /**
     * Get a list of all capability names in the Database.
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
     * @param jobName The name of the job you want data on.
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
     * @param leadName The name of the capability lead you want data on.
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
     * @return Response code 200 if successful. Response code 500 if something goes wrong with SQL query.
     * @return Response code 401 if user is not logged in. Response code 403 if user is logged in with invalid cookie.
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
}