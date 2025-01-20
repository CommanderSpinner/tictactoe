package org.player;

import org.connection.Conn;
import org.connection.PlayerRecord;

public class Player {
    char symbol;
    static char fields[];
    boolean turn = false;

    public Player(char symbol, boolean turn){
        this.symbol = symbol;
        this.turn = turn;

        if(fields == null || fields.length == 0){
            fields = new char[9];
            for (int i = 0; i < fields.length; i++){
                fields[i] = ' ';
            }
        }
    }

    public char getSymbol(){
        return symbol;
    }

    static private boolean checkField(int field){
        return fields[field] == ' ';
    }

    static public boolean setFields(Player p, int field){
        if(p.turn) {
            if (checkField(field)) {
                fields[field] = p.getSymbol();
                p.turn = false;
                return true;
            }
        }
        return false;
    }
}
