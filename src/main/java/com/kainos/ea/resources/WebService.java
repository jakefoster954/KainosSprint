package com.kainos.ea.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kainos.ea.DBConnector;
import com.kainos.ea.DTO;
import freemarker.template.Template;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

@Path("/api")
public class WebService {

    @GET
    @Path("/print/{msg}")
    @Produces("text/html")
    public String getMsg(@PathParam("msg") String message) {
        return "Hello from a RESTful Web service: " + message;
    }

    @GET
    @Path("/job")
    @Produces(MediaType.APPLICATION_JSON)
    //TEST job-role mock
    public List<Job> testJob() throws ClassNotFoundException, IOException, SQLException {
        return DTO.retriveJobsFromDB();
    }

    @GET
    @Timed
    @Produces({MediaType.TEXT_HTML})
    @Path("/helloWorld")
    public Response getHelloWorld() {
        try {
            Template temp = TemplateConfigurationContext.getConfiguration().getTemplate("helloWorld.ftl");

            Job a = new Job();
            Job b = new Job();
            Job c = new Job();

            List<Job> jobs = Arrays.asList(
                    a, b, c);
            Map<String, Object> root = new HashMap<String, Object>();
            root.put("jobs", jobs);

            Writer writer = new StringWriter();
            temp.process(root, writer);
            return Response.status(Response.Status.ACCEPTED).entity((writer.toString())).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(("Oops! Try again later")).build();
    }

    @GET
    @Timed
    @Produces({MediaType.TEXT_HTML})
    @Path("/job-roles")
    public Response getJobRoles() {
        try {
            Template temp = TemplateConfigurationContext.getConfiguration().getTemplate("job-roles.ftl");

            List<Job> jobs = DTO.retriveJobsFromDB();

            Map<String, Object> root = new HashMap<String, Object>();
            root.put("jobs", jobs);

            Writer writer = new StringWriter();
            temp.process(root, writer);
            return Response.status(Response.Status.ACCEPTED).entity((writer.toString())).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(("Oops! Try again later")).build();
    }
    @GET
    @Timed
    @Produces({MediaType.TEXT_HTML})
    @Path("/job-roles/{jobName}")
    public Response getJobSpec(@PathParam("jobName") String jobName) {
        try {
            Template temp = TemplateConfigurationContext.getConfiguration().getTemplate("job-roles-name.ftl");

            Map<String, Object> root = new HashMap<String, Object>();

            Job job = DTO.retriveJobsFromDB().stream().filter(j-> j.getJobName().replace(" ", "-")
                    .equals(jobName)).findFirst().get();


            root.put("job", job);

            Writer writer = new StringWriter();
            temp.process(root, writer);
            return Response.status(Response.Status.ACCEPTED).entity((writer.toString())).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(("Oops! Try again later")).build();
    }
}