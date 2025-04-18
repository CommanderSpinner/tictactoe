package org.player;

import javax.swing.*;

public class Game {
    private Player p;
    private JButton[] fields;
    private int fieldNumber;
    boolean win = false;

    public Game(Player p, JButton[] fields, int fieldNumber){
        this.fieldNumber = fieldNumber;
        this.p = p;
        this.fields = fields;
    }

    // gotta add to check if win
    public void checkWin(){
        if()
    }

    public boolean setField(){

        // if player has won no changes to fields should be able to be made
        char active = p.getSymbol(); // symbol of active player

        if (win){
            return false;
        }

        boolean success = Player.setFields(p, fieldNumber);
        if (success) {
            fields[fieldNumber].setText(String.valueOf(p.getSymbol())); // Update UI button
        }
        return success;
    }
}
