package org.connection;

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
        } else {
            System.out.println("Connection failure");
        }
    }

    public void synchDB(Player p) throws SQLException {
        Statement s = c.createStatement();
        s.executeUpdate("INSET INTO player (score) VALUES (" + p.getScore() + ") WHERE symbol = " + p.getSymbol());
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
}