package org.connection;

import org.player.Player;

public class PlayerRecord {
    private char symbol;
    private int score;
    private Conn c;
    private Player p;

    public void synchDB(){
    }

    public PlayerRecord(Conn c, Player p){
        this.c = c;
        this.p = p;
    }
}
