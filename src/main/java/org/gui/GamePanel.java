package org.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    JButton[] fields;
    public GamePanel(){
        for (int i = 0; i < 9; i++){
            fields[i] = new JButton();
            this.add(fields[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
