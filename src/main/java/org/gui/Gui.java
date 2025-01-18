package org.gui;

import org.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Gui extends JFrame implements ActionListener {
    Player[] players;
    JMenuBar bar;
    JPanel cardPanel; // The container managed by CardLayout
    CardLayout cardLayout; // CardLayout instance
    ArrayList<JPanel> panels;

    public Gui() {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Example: Switch to DisplayPanel when an action is triggered
        cardLayout.show(cardPanel, "DisplayPanel");
    }
}
