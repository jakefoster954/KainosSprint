package com.kainos.ea.resources.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kainos.ea.DTO;
import com.kainos.ea.resources.User;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Path("/api/login")
public class LoginService implements WebService {
    /**
     * Authenticate yourself to gain access to pages on the site.
     * Access to pages is dependent on account permission level.
     * @param user An object holding the username and a hash of the password.
     * @return Status 200. OK if valid credentials. Status 401. Unauthorized otherwise.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/")
    public Response login(User user) throws SQLException, IOException {
        logger.info(String.format("login endpoint reached. User email is %s and User type is %s",
                user.getUserEmail(),
                user.getUserType()));
        User loggedUser = DTO.loginUser(user);
        if (loggedUser==null)
            return Response.status(401).entity("{\"error\": \"Incorrect user email and/or password\"}").build();
        return Response.ok("{\"userType\": \"" + loggedUser.getUserType() + "\"}").build();
    }
}
