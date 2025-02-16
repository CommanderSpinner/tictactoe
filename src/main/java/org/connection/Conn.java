package org.connection;

import java.io.File;
import java.sql.*;

import org.player.Player;

public class Conn {
    private final String url;
    private final Connection c;

    public Conn() throws SQLException {
        url = "jdbc:sqlite:game.db";

        c = DriverManager.getConnection(url);

        if (c != null) {
            System.out.println("Connection to SQLite has been established.");
            printTable();
            System.out.println(new File("game.db").getAbsolutePath());
        } else {
            System.out.println("Connection failure");
        }
    }

    public void syncDB(Player p) throws SQLException {
        Statement s = c.createStatement();
        s.executeUpdate("UPDATE player SET score = " + p.getScore() + " WHERE symbol = '" + p.getSymbol() + "'");
    }

    public void readDB(Player p) throws SQLException {
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM player WHERE symbol = '" + p.getSymbol() + "'");

        while (rs.next()) {
            p.setScore(rs.getInt("score"));
        }

        System.out.println(p.getSymbol() + ": " + p.getScore());
    }

    public void closeConn() throws SQLException {
        c.close();
        System.out.println("Connection closed");
    }

    private void printTable() throws SQLException {
        String query = "SELECT * FROM player";

        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("database:");

        while (rs.next()) {
            System.out.println(rs.getString("symbol") + "|" + rs.getInt("score"));
        }
    }
}