package com.kainos.ea.resources.webservice;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.CookieParam;
import javax.ws.rs.core.MediaType;

import com.kainos.ea.DTO;
import com.kainos.ea.resources.Capability;
import com.kainos.ea.resources.Job;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Contains all endpoints only an admin account can access.
 */
@Path("/api/admin")
public class AdminService extends WebService {
    /**
     * Defines the permission levels for the /api/admin endpoint.
     */
    private final List<PermissionLevel> permissionLevels = Arrays.asList(PermissionLevel.ADMIN);

    /**
     * Delete a job from the database.
     *
     * @param jobRoleName The job you wish to delete
     * @param sessionCookie The session key contained in a cookie. Used to authenticate user at endpoint.
     * @return Status 200. OK if deleting succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    @DELETE
    @Timed
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/delete-job/{jobRoleName}")
    public Response deleteJobRole(@PathParam("jobRoleName") String jobRoleName, @CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return Response.status(response).build();

        logger.info("delete-job endpoint reached");
        return Response.status(DTO.deleteJobFromDB(jobRoleName)).build();
    }

    /**
     * Add a job to the database.
     *
     * @param job An instance of the Job class containing all the data requested by the job class.
     * @param sessionCookie The session key contained in a cookie. Used to authenticate user at endpoint.
     * @return Status 200. OK if adding succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/add-job")
    public Response addJobRole(Job job, @CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return Response.status(response).build();

        //Hack to handle job family
        job.splitCapabilityAndJobFamily();
        logger.info(job.getCapabilityName() + "  " + job.getJobFamilyName());

        logger.info(String.format("add-job endpoint reached. Job name is %s", job.getJobName()));
        return Response.status(DTO.addJobToDB(job)).build();
    }

    /**
     * Edit a job from database
     *
     * @param job The job you wish to edit.
     * @param sessionCookie The session key contained in a cookie. Used to authenticate user at endpoint.
     * @return Status 200. OK if editing succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     * @deprecated This will not probably be implemented in fronted till the end of project
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/edit-job")
    public Response.Status editJobRole(Job job, @CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return response;

        logger.info("edit-job endpoint reached");
        return DTO.editJobFromDB(job);
    }

    /**
     * Add a capability to the database.
     *
     * @param capability An instance of the Capability class containing all the data requested by the capability class.
     * @param sessionCookie The session key contained in a cookie. Used to authenticate user at endpoint.
     * @return Status 200. OK if adding succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/add-capability")
    public Response addCapability(Capability capability, @CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return Response.status(response).build();

        return Response.status(DTO.addCapabilityToDB(capability)).build();
    }

    /**
     * Delete a capability from the database.
     * Gets capabilityName from path and deletes the corresponding record from database.
     *
     * @param capabilityName The capability you wish to delete
     * @param sessionCookie The session key contained in a cookie. Used to authenticate user at endpoint.
     * @return Status 200. OK if deleting succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax.
     * @throws IOException Create connection to database.
     */
    @DELETE
    @Timed
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/delete-capability/{capabilityName}")
    public Response deleteCapability(@PathParam("capabilityName") String capabilityName, @CookieParam("sessionKey") String sessionCookie) throws SQLException, IOException {
        // Validate session cookie
        Response.Status response = isSessionCookieValid(sessionCookie, permissionLevels);
        if (response != Response.Status.OK) return Response.status(response).build();

        return Response.status(DTO.deleteCapabilityFromDB(capabilityName)).build();
    }
}
