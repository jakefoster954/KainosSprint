package com.kainos.ea.resources.webservice;

import com.kainos.ea.DTO;

import java.io.IOException;
import java.sql.SQLException;

public abstract class WebService {
    protected PermissionLevel permissionLevel;

    public void validateSessionKey(String sessionKey) throws SQLException, IOException {
        if(!DTO.getSessionKeyFromDB(sessionKey)){
            return;
        }


        if(!){

        }
    }
}
