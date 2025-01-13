package org.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {
    public Gui(){
        this.add(new GamePanel());

        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
