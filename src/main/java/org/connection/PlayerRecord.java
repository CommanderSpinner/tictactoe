package org.connection;

import org.player.Player;

public class PlayerRecord {
    private char symbol;
    private int score;
    private Conn c;

    public void synchDB(){
    }

    public PlayerRecord(Conn c){
        this.c = c;
    }
}
