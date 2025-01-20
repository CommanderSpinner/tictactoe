package org.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
    private final String url;
    Connection c;

    public Conn() throws SQLException {
        url = "jdbc:sqlite:game.db";

        c = DriverManager.getConnection(url)
        if (c != null) {
            System.out.println("Connection to SQLite has been established.");
        } else {
            System.out.println("Connection failure");
        }
    }

}