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

    public boolean setField(){

        if (fields[fieldNumber].getText().equals("")) {
            fields[fieldNumber].setText(p.getSymbol() + "");
            return true;
        }

        return false;
    }
}
