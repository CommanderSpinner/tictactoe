package org.gui;

import org.connection.Conn;
import org.connection.PlayerRecord;
import org.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

class Gui extends JFrame {
    private JMenuBar bar;
    private JPanel cardPanel; // The container managed by CardLayout
    private CardLayout cardLayout; // CardLayout instance
    private ArrayList<JPanel> panels;

    private Player[] players;

    Conn c;

    public Gui() throws SQLException {
        c = new Conn();

        panels = new ArrayList<>();
        panels.add(new GamePanel(players));
        panels.add(new DisplayPanel());

        players = new Player[2];
        cardLayout = new CardLayout(); // Initialize CardLayout
        cardPanel = new JPanel(cardLayout); // Assign CardLayout to JPanel
        bar = new Bar(cardPanel, cardLayout);

        players[0] = new Player('x', true);
        players[1] = new Player('o', false);

        this.setJMenuBar(bar);

        // Add your panels to the cardPanel
        cardPanel.add(panels.get(0), "GamePanel");
        cardPanel.add(panels.get(1), "DisplayPanel");

        // Add the cardPanel to the JFrame
        this.add(cardPanel);

        // Set the initial panel
        cardLayout.show(cardPanel, "GamePanel");

        // JFrame settings
        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setVisible(true);

        // close conn on shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (c != null) {
                    c.closeConn();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }));
    }
}
