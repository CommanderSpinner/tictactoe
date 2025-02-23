package org.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Bar extends JMenuBar implements ActionListener {
    JMenu menu;
    JMenuItem[] menuItems;
    JPanel cardPanel;
    CardLayout cardLayout;

    public Bar(JPanel cardPanel, CardLayout cardLayout) {
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        menu = new JMenu("panels");
        menuItems = new JMenuItem[2];

        menuItems[0] = new JMenuItem("Game");
        menuItems[1] = new JMenuItem("Stats");

        menuItems[0].addActionListener(this);
        menuItems[1].addActionListener(this);

        menu.add(menuItems[0]); // Add the JMenuItem to the Game menu
        menu.add(menuItems[1]); // Add the JMenuItem to the Stats menu

        this.add(menu); // Add the Game menu to the menu bar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItems[0]){
            cardLayout.show(cardPanel, "GamePanel");
            System.out.println("game panel");
        } else if (e.getSource() == menuItems[1]) {
            cardLayout.show(cardPanel, "DisplayPanel");
            System.out.println("display panel");
        }
    }
}
