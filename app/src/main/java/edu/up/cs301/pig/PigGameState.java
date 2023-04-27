package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;


public class PigGameState extends GameState {
    private int playerID;
    private int player0Score;
    private int player1Score;
    private int rTotal;
    private int dValue;

    public PigGameState() {
        playerID = 0;
        player0Score = 0;
        player1Score = 0;
        rTotal = 0;
        dValue = 1;
    }

    public PigGameState(PigGameState pigGameState){
        this.playerID = pigGameState.getPlayerID();
        this.player0Score = pigGameState.getPlayer0Score();
        this.player1Score = pigGameState.getPlayer1Score();
        this.rTotal = pigGameState.getrTotal();
        this.dValue = pigGameState.getdValue();
    }

    public int getPlayerID() {
        return playerID;

    }

    public int getPlayer0Score(){
        return player0Score;
    }

    public int getPlayer1Score(){
        return player1Score;
    }

    public int getrTotal(){
        return rTotal;
    }

    public int getdValue(){
        return dValue;
    }

    public void setPlayerID (int playerID){
        this.playerID = playerID;
    }

    public void setPlayer0Score (int player0Score){
        this.player0Score = player0Score;
    }

    public void setPlayer1Score (int player1Score){
        this.player1Score = player1Score;
    }

    public void setrTotal (int rTotal){
        this.rTotal = rTotal;

    }

    public void setdValue  (int dValue){
        this.dValue = dValue;
    }



}
