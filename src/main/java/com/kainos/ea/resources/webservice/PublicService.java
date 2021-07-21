package com.kainos.ea.resources.webservice;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.kainos.ea.DTO;
import com.kainos.ea.resources.User;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Path("/api/login")
public class PublicService extends WebService {
    /**
     * Authenticate yourself to gain access to pages on the site.
     * Access to pages is dependent on account permission level.
     * If a valid username password pair is provided, the session key will be provided to log in.
     * This session key can be used to log into endpoints that have the required permissions.
     * @param user An object holding the username and a hash of the password.
     * @return Status 200. OK if valid credentials and a cookie under the key "Session key". Status 401. Unauthorized otherwise.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/")
    public Response login(User user, @Context HttpServletResponse response) throws SQLException, IOException {
        logger.info("login endpoint reached");
        String sessionKey = DTO.loginUser(user);

        // If user isn't successfully authenticated, return 401.
        if (sessionKey == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        // Set the session key in a cookie and return 200
        logger.info(String.format("User type is %s", sessionKey.substring(0,4)));
        return Response.ok("{\"sessionKey\": \"" + sessionKey + "\"}").build();
    }
}
