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

    public boolean checkWin(){
        String symbol = p.getSymbol() + "";
        boolean win = false;

        // Check rows
        if (fields[0].getText().equals(symbol) && fields[1].getText().equals(symbol) && fields[2].getText().equals(symbol)) {
            System.out.println("Player wins!");
            win = true;
        } else if (fields[3].getText().equals(symbol) && fields[4].getText().equals(symbol) && fields[5].getText().equals(symbol)) {
            System.out.println("Player wins!");
            win = true;
        } else if (fields[6].getText().equals(symbol) && fields[7].getText().equals(symbol) && fields[8].getText().equals(symbol)) {
            System.out.println("Player wins!");
            win = true;
        }
        // Check columns
        else if (fields[0].getText().equals(symbol) && fields[3].getText().equals(symbol) && fields[6].getText().equals(symbol)) {
            System.out.println("Player wins!");
            win = true;
        } else if (fields[1].getText().equals(symbol) && fields[4].getText().equals(symbol) && fields[7].getText().equals(symbol)) {
            System.out.println("Player wins!");
            win = true;
        } else if (fields[2].getText().equals(symbol) && fields[5].getText().equals(symbol) && fields[8].getText().equals(symbol)) {
            System.out.println("Player wins!");
            win = true;
        }
        // Check diagonals
        else if (fields[0].getText().equals(symbol) && fields[4].getText().equals(symbol) && fields[8].getText().equals(symbol)) {
            System.out.println("Player wins!");
            win = true;
        } else if (fields[2].getText().equals(symbol) && fields[4].getText().equals(symbol) && fields[6].getText().equals(symbol)) {
            System.out.println("Player wins!");
            win = true;
        }

        return win;
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
