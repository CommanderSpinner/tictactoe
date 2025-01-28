package org.gui;

import java.sql.DriverManager;
import java.sql.*;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        /*
         String URL = "jdbc:sqlite:game.db";

            // SQL statement to create the player table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS player (" +
                    "symbol CHAR(1) PRIMARY KEY, " +
                    "score INT NOT NULL);";

            // Try-with-resources to manage the connection and statement
            try (Connection conn = DriverManager.getConnection(URL);
                 Statement stmt = conn.createStatement()) {

                // Execute the SQL statement
                stmt.execute(createTableSQL);
                System.out.println("Table 'player' created successfully.");

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }

         */

        new Gui();
    }
}