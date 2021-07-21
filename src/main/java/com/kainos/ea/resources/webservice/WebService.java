package com.kainos.ea.resources.webservice;

import com.kainos.ea.DTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * An abstract validation that contains all the validation and the logger for all child classes.
 */
public abstract class WebService {
    /**
     * The logger.
     */
    protected Logger logger = LogManager.getLogger(WebService.class);

    /**
     * Checks if the session cookie exists. If it doesn't it returns 401.
     * If the session cookie does exist, it will check if the session cookie is valid.
     * If its valid, 200 is returned. Otherwise 403 is returned.
     * @param sessionCookieValue The session cookie provided by the front end
     * @param permissionLevels A list of all the permission levels that are allowed to
     * @return Status code. Either 200, 401 or 403.
     * @throws SQLException Invalid SQL syntax
     * @throws IOException Create connection to database.
     */
    protected Response.Status isSessionCookieValid(String sessionCookieValue, List<PermissionLevel> permissionLevels) throws SQLException, IOException {
        if (sessionCookieValue == null) {
            return Response.Status.UNAUTHORIZED;
        } else if (!isSessionKeyValid(sessionCookieValue, permissionLevels)) {
            return Response.Status.FORBIDDEN;
        }
        return Response.Status.OK;
    }

    private boolean isSessionKeyValid(String sessionKey, List<PermissionLevel> permissionLevels) throws SQLException, IOException {
        // Verify session key exists
        if (!DTO.isSessionKeyInDB(sessionKey)) {
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
