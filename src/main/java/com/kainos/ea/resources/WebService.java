package com.kainos.ea.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import freemarker.template.Template;

import javax.ws.rs.core.Response;
import java.io.StringWriter;
import java.io.Writer;
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
    public Job testJob() {
        Job c = new Job(1, "Developer", "Guy/Lad writing code", 1_200_000);
        return c;
    }

    @GET
    @Timed
    @Produces({MediaType.TEXT_HTML})
    @Path("/helloWorld")
    public Response getHelloWorld() {
        try {
            Template temp = TemplateConfigurationContext.getConfiguration().getTemplate("helloWorld.ftl");

            Job a = new Job(1, "Developer", "Guy/Lad writing code", 1_200_000);
            Job b = new Job(2, "Engineer", "Guy/Lad writing code", 1_200_000);
            Job c = new Job(3, "Tester", "Guy/Lad writing code", 1_200_000);

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
}
