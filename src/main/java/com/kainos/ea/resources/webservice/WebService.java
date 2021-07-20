package com.kainos.ea.resources.webservice;

import com.kainos.ea.DTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public abstract class WebService {
    protected Logger logger = LogManager.getLogger(WebService.class);

    public Response isSessionCookieValid(String sessionCookieValue, List<PermissionLevel> permissionLevels) throws SQLException, IOException {
        if (sessionCookieValue == null) {
            return Response.Status.UNAUTHORIZED;
        } else if (!isSessionKeyValid(sessionCookieValue, permissionLevels)) {
            return Response.Status.FORBIDDEN;
        }
    }

    private boolean isSessionKeyValid(String sessionKey, List<PermissionLevel> permissionLevels) throws SQLException, IOException {
        // Verify session key exists
        if (!DTO.getSessionKeyFromDB(sessionKey)) {
            return false;
        }

        // Validate session expiry
        long sessionKeyExpiry = Long.parseLong(sessionKey.substring(31));
        if (System.currentTimeMillis() > sessionKeyExpiry) {
            return false;
        }

        // Validate user type
        String userType = sessionKey.substring(0, 4);
        for (PermissionLevel permissionLevel : permissionLevels) {
            if (permissionLevel.toString().substring(0, 4).equals(userType)) {
                return true;
            }
        }

        return false;
    }
}
