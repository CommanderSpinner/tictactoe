package org.connection;

import java.io.File;
import java.sql.*;

import org.player.Player;

public class Conn {
    private final String url;
    private Connection c;

    public Conn() throws SQLException {
        url = "jdbc:sqlite:game.db";

        c = DriverManager.getConnection(url);

        if (c != null) {
            System.out.println("Connection to SQLite has been established.");
            printTables();
            System.out.println(new File("game.db").getAbsolutePath());
        } else {
            System.out.println("Connection failure");
        }
    }

    public void synchDB(Player p) throws SQLException {
        Statement s = c.createStatement();
        s.executeUpdate("INSERT INTO player (score) VALUES (" + p.getScore() + ") WHERE symbol = " + p.getSymbol());
    }

    public void readDB(Player p) throws SQLException {
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM player WHERE symbol = " + p.getSymbol());

        while (rs.next()) {
            p.setScore(rs.getInt("score"));
        }

        System.out.println(p.getSymbol() + ": " + p.getScore());
    }

    public void closeConn() throws SQLException {
        c.close();
        System.out.println("Connection closed");
    }

    private void printTables() throws SQLException {
        String query = "SELECT name FROM sqlite_master WHERE type='table' AND name NOT LIKE 'sqlite_%';";

        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("List of tables in the database:");

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }
}