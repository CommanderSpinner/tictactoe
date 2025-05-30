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
    private boolean win = false;

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

                int playerNum = p[0].getTurn() ? 0 : 1;

                Game g = new Game(p[playerNum], fields, i);

                System.out.println("Field " + i + " was clicked!");

                if (g.setField()) { // Only proceed if move is valid
                    p[playerNum].setTurn(false);
                    p[1 - playerNum].setTurn(true); // Switch turn to the other player

                    win = g.checkWin(); // Check for win AFTER move is made

                    if (win) {
                        int response = JOptionPane.showConfirmDialog(
                                null,
                                "Player " + (playerNum + 1) + " wins!\nDo you want to play again?",
                                "Game Over",
                                JOptionPane.YES_NO_OPTION
                        );

                        if (response == JOptionPane.YES_OPTION) {
                            resetPanel();
                        } else {
                            System.exit(0);
                        }
                    }
                    win = false;
                }
                break;
            }
        }
    }

    private void resetPanel() {
        for (int i = 0; i < fields.length; i++) {
            fields[i].setText("");
        }
    }


    /*
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
                win = g.checkWin();

                System.out.println("Field " + (i) + " was clicked!");


                if (g.setField()) { // Only switch turn if move is valid
                    p[playerNum].setTurn(false);
                    p[1 - playerNum].setTurn(true); // Switch turn to the other player
                }

                // replay game if won
                if (win){
                    int response = JOptionPane.showConfirmDialog(
                            null,
                            "Do you want to play again?",
                            "Play Again",
                            JOptionPane.YES_NO_OPTION
                    );

                    System.out.println("responce: " + response);
                }

                break;
            }
        }
    }
    */

}
