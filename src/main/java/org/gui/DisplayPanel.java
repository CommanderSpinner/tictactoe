package org.gui;

import org.player.Player;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {
    JLabel[] names;
    JLabel[] scores;

    public DisplayPanel(Player[] p){
        setLayout(new GridLayout(2, 2, 10, 10)); // Grid with 2 rows, 2 columns, and spacing

        names = new JLabel[2];
        scores = new JLabel[2];

        for (int i = 0; i < 2; i++) {
            names[i] = new JLabel("Player " + p[i].getSymbol() + ": ", SwingConstants.RIGHT);
            scores[i] = new JLabel(String.valueOf(p[i].getScore()), SwingConstants.LEFT);

            names[i].setFont(new Font("Arial", Font.BOLD, 14));
            scores[i].setFont(new Font("Arial", Font.PLAIN, 14));

            add(names[i]);
            add(scores[i]);
        }
    }
}
