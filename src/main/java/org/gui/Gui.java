package org.gui;

import org.player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Gui extends JFrame implements ActionListener {
    Player[] p = new Player[2];
    public Gui(){
        p[0] = new Player('x', true);
        p[1] = new Player('o', false);

        this.add(new GamePanel(p));

        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
