package org.gui;

import org.connection.Conn;
import org.player.Game;
import org.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class GamePanel extends JPanel implements ActionListener {
    private JButton[] fields;
    private Player[] p;

    public GamePanel(Player[] p, Conn c) throws SQLException {
        fields = new JButton[9];

        this.p = p;

        c.readDB(p[0]);
        c.readDB(p[1]);

        this.setLayout(new GridLayout(0, 3, 10, 10));

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
                int playerNum = -1;

                // check which player should get checked
                if(p[0].getTurn()){
                    playerNum = 0;
                } else {
                    playerNum = 1;
                }

                Game g = new Game(p[playerNum], fields, i);
                System.out.println("Field " + (i) + " was clicked!");
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
