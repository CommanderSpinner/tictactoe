package org.gui;

import org.player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Gui extends JFrame implements ActionListener {
    Player[] p;
    JMenuBar bar;
    ArrayList<JPanel> panels;
    public Gui(){
        p = new Player[2];
        panels = new ArrayList<>();
        bar = new Bar(panels);

        p[0] = new Player('x', true);
        p[1] = new Player('o', false);

        this.setJMenuBar(bar);;
        panels.add(new GamePanel(p));
        panels.add(new DisplayPanel());


        for (int i = 0; i < panels.size(); i++){
            this.add(panels.get(i));
        }
        panels.getFirst().setVisible(true);

        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
