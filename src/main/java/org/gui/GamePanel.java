package org.gui;

import org.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GamePanel extends JPanel implements ActionListener {
    JButton[] fields;
    Player[] p;
    public GamePanel(Player[] p){
        fields = new JButton[9];

        this.setLayout(new GridLayout(0, 3, 10, 10));

        this.p = p;

        for (int i = 0; i < 9; i++){
            fields[i] = new JButton();
            fields[i].addActionListener(this);
            this.add(fields[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < fields.length; i++) {
            if (e.getSource() == fields[i]) {
                System.out.println("Field " + (i + 1) + " was pressed!");
                // Perform specific actions for each button
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Error something went wrong");
                }
                break;
            }
        }
    }
}
