package org.connection;

import org.player.Player;

//might delete this class

public class PlayerRecord {
    private char symbol;
    private int score;
    private Conn c;

    //public void get

    public void synchDB(){
    }

    public PlayerRecord(Conn c){
        this.c = c;
    }
}
