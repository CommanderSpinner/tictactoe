package org.gui;

import org.player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GamePanel extends JPanel implements ActionListener {
    JButton[] fields;
    public GamePanel(Player[] p){
        for (int i = 0; i < 9; i++){
            fields[i] = new JButton();
            this.add(fields[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
