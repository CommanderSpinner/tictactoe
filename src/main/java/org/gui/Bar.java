package org.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bar extends JMenuBar implements ActionListener {
    JMenu[] items;
    public Bar(){
        items = new JMenu[2];
        items[0] = new JMenu("Game");
        items[1] = new JMenu("Stats");

        items[0].addActionListener(this);
        items[1].addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == items[0]) {
            System.out.println("Game menu clicked");
        } else if (e.getSource() == items[1]) {
            System.out.println("Stats menu clicked");
        }
    }
}
