package org.player;

public class Player {
    char symbol;
    static char fields[];
    boolean turn = false;
    int score;

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

    public boolean getTurn(){
        return this.turn;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public char getSymbol(){
        return symbol;
    }

    public boolean checkWinner(){

        return false;
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
