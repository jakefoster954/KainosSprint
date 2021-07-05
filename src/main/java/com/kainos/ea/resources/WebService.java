package com.kainos.ea.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class WebService {

    @GET
    @Path("/print/{msg}")
    @Produces("text/html")
    public String getMsg(@PathParam("msg") String message){
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
}
