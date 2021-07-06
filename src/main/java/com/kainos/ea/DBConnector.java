package com.kainos.ea;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnector {

    private static Connection conn;

    static Connection getConnection() throws IOException {

        FileInputStream propsStream =
                new FileInputStream("DbConnection.properties");

        Properties props = new Properties();
        props.load(propsStream);

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String host = props.getProperty("host");

        if (user == null || password == null || host == null)
            throw new IllegalArgumentException(
                    "Properties file must exist and must contain "
                            + "user, password, and host properties.");

        if (conn != null) {
            return conn;
        }

        try {
            System.out.println("SQL connected :" + host);
            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/KainosSprint?useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            System.out.println("SQL Error:" + e.getMessage());
        }
        return null;
    }
}