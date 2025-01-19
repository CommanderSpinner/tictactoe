package org.connection;

import org.player.Player;

public class PlayerRecord {
    char symbol;
    int score;
    Conn c;
    Player p;

    public void synchDB(){
    }

    public PlayerRecord(Conn c, Player p){
        this.c = c;
        this.p = p;
    }
}
