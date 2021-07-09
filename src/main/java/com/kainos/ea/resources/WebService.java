package com.kainos.ea.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kainos.ea.DTO;
import freemarker.template.Template;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.*;

@Path("/api")
public class WebService {

    public Response responseReuse( String template, Object dto) {
        try {
            Template temp = TemplateConfigurationContext.getConfiguration().getTemplate(template);

            Map<String, Object> root = new HashMap<>();

            root.put("dto", dto);

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
    @Path("/helloWorld")
    public Response getHelloWorld() {
            List<Job> jobs = Arrays.asList(new Job());
            return responseReuse("helloWorld.ftl", jobs);
    }
    @GET
    @Timed
    @Produces({MediaType.TEXT_HTML})
    @Path("/job-roles")
    public Response getJobRoles() throws SQLException, IOException, ClassNotFoundException {
            List<Job> jobs = DTO.retriveJobsFromDB();
            return responseReuse("job-roles.ftl", jobs);
    }
    @GET
    @Timed
    @Produces({MediaType.TEXT_HTML})
    @Path("/job-roles/{jobName}")
    public Response getJobSpec(@PathParam("jobName") String jobName) throws SQLException, IOException, ClassNotFoundException {
        Job job = DTO.retriveJobsFromDB().stream().filter(j-> j.getJobNameAsURL().equals(jobName)).findFirst().get();
        return responseReuse("job-roles-name.ftl", job);
    }
}