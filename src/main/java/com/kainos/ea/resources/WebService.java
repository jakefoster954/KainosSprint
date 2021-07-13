package com.kainos.ea.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kainos.ea.DTO;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * Handles all api calls from our front end application.
 */
@Path("/api")
public class WebService {

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

    // New endpoints

    /**
     * Get a list of all capability names in the Database.
     * @return a String representing a list of JSON objects. Each object contains "name" as the key and the capability name as the value.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getCapabilities")
    public String getCapabilityNames() throws SQLException, IOException {
        JSONArray capabilities = DTO.getCapabilities();
        return capabilities.toString();
    }

    /**
     * Get a list of all band level names in the Database.
     * @return a String representing a list of JSON objects. Each object contains "name" as the key and the band level name as the value.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     */
    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getBandLevels")
    public String getBandNames() throws SQLException, IOException {
        JSONArray bandNames = DTO.getBandNames();
        return bandNames.toString();
    }

    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getJobNames")
    public String getJobNames() throws SQLException, IOException {
        JSONArray jobNames = DTO.getJobNames();
        return jobNames.toString();
    }

    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getJobData/{jobName}")
    public String getJobData(@PathParam("jobName") String jobName) throws SQLException, IOException {
        JSONObject jobData = DTO.getJobData(jobName);
        return jobData.toString();
    }

    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getCapabilityLeads")
    public String getCapabilityLeads() throws SQLException, IOException {
        JSONArray capabilityLeads = DTO.getCapabilityLeads();
        return capabilityLeads.toString();
    }

    @GET
    @Timed
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getCapabilityData/{leadName}")
    public String getCapabilityLeadData(@PathParam("leadName") String leadName) throws SQLException, IOException {
        JSONObject capabilityLeadData = DTO.getCapabilityLeadData(leadName);
        return capabilityLeadData.toString();
    }

    /**
     * Delete a job from the database
     * @param job The job you wish to delete
     * @return Status 200. OK.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     * @throws ClassNotFoundException ???
     */
    @DELETE
    @Timed
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/delete-job")
    public Response.Status deleteJobRole(Job job) throws SQLException, IOException, ClassNotFoundException {
        DTO.deleteJobFromDB(job);
        return Response.Status.OK;
    }

    /**
     *
     * @param job An instance of the Job class containing all the data requested by the job class.
     * @return Status 200. OK.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/add-job")
    public Response.Status addJobRole(Job job) throws SQLException, IOException {
        DTO.addJobToDB(job);
        return Response.Status.OK;
    }

    /**
     *
     * @param user An object holding the username and a hash of the password.
     * @return Status 200. OK if valid credentials. Status 401. Unauthorized otherwise.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     * @throws ClassNotFoundException ???
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/login")
    public Response login(User user) throws SQLException, IOException, ClassNotFoundException {
        List<User> users = DTO.loginUser(user);
        if (users.isEmpty()) {
            return Response.status(401).entity("{\"error\": \"User not found\"}").build();
        } else {
            User loggedInUser = users.get(0);
            return Response.ok("{\"userType\": \"" + loggedInUser.getUserType() + "\"}").build();
        }
    }
}