package org.player;

import javax.swing.*;

public class Game {
    private Player p;
    private JButton[] fields;
    private int fieldNumber;

    public Game(Player p, JButton[] fields, int fieldNumber){
        this.fieldNumber = fieldNumber;
        this.p = p;
        this.fields = fields;
    }
}
