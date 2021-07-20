package com.kainos.ea.resources.webservice;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kainos.ea.DTO;
import com.kainos.ea.resources.Capability;
import com.kainos.ea.resources.Job;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Path("/api/admin")
public class AdminService implements WebService2 {
    /**
     * Delete a job from the database
     * @param jobRoleName The job you wish to delete
     * @return Status 200. OK if deleting succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     */
    @DELETE
    @Timed
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/delete-job/{jobRoleName}")
    public Response.Status deleteJobRole(@PathParam("jobRoleName") String jobRoleName) throws SQLException, IOException {
        logger.info("delete-job endpoint reached");
        return DTO.deleteJobFromDB(jobRoleName);
    }

    /**
     * Add a job to the database.
     * @param job An instance of the Job class containing all the data requested by the job class.
     * @return Status 200. OK if adding succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/add-job")
    public Response.Status addJobRole(Job job) throws SQLException, IOException {
        logger.info(String.format("add-job endpoint reached. Job name is %s", job.getJobName()));
        return(DTO.addJobToDB(job));
    }

    /**
     * Edit a job from database
     * @param job The job you wish to edit.
     * @return Status 200. OK if editing succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     * @deprecated This will not probably be implemented in fronted till the end of project
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/edit-job")
    public Response.Status editJobRole(Job job) throws SQLException, IOException {
        logger.info("edit-job endpoint reached");
        return DTO.editJobFromDB(job);
    }

    /**
     * Add a capability to the database.
     * @param capability An instance of the Capability class containing all the data requested by the capability class.
     * @return Status 200. OK if adding succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/add-capability")
    public Response.Status addCapability(Capability capability) throws SQLException, IOException {
        return(DTO.addCapabilityToDB(capability));
    }

    /**
     * Delete a capability from the database.
     * Gets capabilityName from path and deletes the corresponding record from database.
     * @param capabilityName The capability you wish to delete
     * @return Status 200. OK if deleting succeeds. Status 500. Internal Server Error otherwise.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     */
    @DELETE
    @Timed
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/delete-capability/{capabilityName}")
    public Response.Status deleteCapability(@PathParam("capabilityName") String capabilityName) throws SQLException, IOException {
        return DTO.deleteCapabilityFromDB(capabilityName);
    }
}
