package org.gui;

import org.connection.Conn;
import org.player.Player;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

class Gui extends JFrame {
    private JMenuBar bar;
    private JPanel cardPanel; // The container managed by CardLayout
    private CardLayout cardLayout; // CardLayout instance
    private ArrayList<JPanel> panels;

    private Player[] players;

    private Conn c;

    public Gui() throws SQLException {
        c = new Conn();

        players = new Player[2];
        players[0] = new Player('x', true);
        players[1] = new Player('o', false);

        this.addPanels();

        this.makeCardPanel();

        this.initFrame();

        this.shutdownHook();
    }

    private void addPanels() throws SQLException {
        panels = new ArrayList<>();
        panels.add(new GamePanel(players, c));
        panels.add(new DisplayPanel());
    }

    private void makeCardPanel(){
        cardLayout = new CardLayout(); // Initialize CardLayout
        cardPanel = new JPanel(cardLayout); // Assign CardLayout to JPanel
        bar = new Bar(cardPanel, cardLayout);

        this.setJMenuBar(bar);

        // Add your panels to the cardPanel
        cardPanel.add(panels.get(0), "GamePanel");
        cardPanel.add(panels.get(1), "DisplayPanel");

        // Add the cardPanel to the JFrame
        this.add(cardPanel);

        // Set the initial panel
        cardLayout.show(cardPanel, "GamePanel");
    }

    private void initFrame(){
        // JFrame settings
        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setVisible(true);
    }

    private void shutdownHook(){
        // close conn on shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (c != null) {
                    System.out.println("Closing Connention");
                    c.syncDB(players[0]);
                    c.syncDB(players[1]);
                    c.closeConn();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }));
    }
}
