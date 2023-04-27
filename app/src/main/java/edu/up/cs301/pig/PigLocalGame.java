package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    PigGameState piggie;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {

        this.piggie = new PigGameState();
        //TODO  You will implement this constructor
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (piggie.getPlayerID() == playerIdx) {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {


        if(action instanceof PigHoldAction){
            Random random = new Random();
            if(piggie.getPlayerID() == 0){
                piggie.setPlayer0Score(piggie.getrTotal()+piggie.getPlayer0Score());
            } else {
                piggie.setPlayer1Score(piggie.getrTotal()+piggie.getPlayer1Score());
            }
            alternatePlayers();
            piggie.setrTotal(0);
            return true;
        } else if (action instanceof PigRollAction){
            Random random = new Random();
            piggie.setdValue(random.nextInt(6)+1);
            if(piggie.getdValue() == 1){
                piggie.setrTotal(0);
                alternatePlayers();
            } else {
                piggie.setrTotal(piggie.getdValue()+piggie.getrTotal());


            }
            return true;
        }
        return false;


       /* //TODO  You will implement this method
        if (action instanceof PigRollAction) {
            Random random = new Random();


            piggie.setdValue(random.nextInt(6) + 1);
            if (piggie.getdValue() != 1) {
                piggie.setrTotal(piggie.getdValue()+piggie.getrTotal());

            } else {
                piggie.setrTotal(0);
                if (piggie.getPlayerID() == 1) {
                    if(players.length == 2){
                        piggie.setPlayerID(0);
                    }
                } else {
                    piggie.setPlayer0Score(piggie.getrTotal());
                    if(players.length == 2){
                        piggie.setPlayerID(1);

                    }
                }
                return true;
            }
        }

        if(action instanceof PigHoldAction){
           if(piggie.getPlayerID() == 1){
               piggie.setPlayer1Score(piggie.getrTotal() + piggie.getPlayer1Score());
               if(players.length == 2){
                   piggie.setPlayerID(0);
               }

           } else {
               piggie.setPlayer0Score(piggie.getrTotal() + piggie.getPlayer0Score());
               if(players.length == 2){
                   piggie.setPlayerID(1);
               }
           }
            piggie.setrTotal(0);

            return true;
        }

        return true;*/
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        p.sendInfo(new PigGameState(this.piggie));

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if(piggie.getPlayer0Score() >= 50) {
            return "Player1" + piggie.getPlayer0Score();
        }

        if(piggie.getPlayer1Score() >= 50){
            return "Player 2" + piggie.getPlayer1Score();
        }

        //TODO  You will implement this method
        return null;
    }

    public void alternatePlayers() {
        if(players.length == 1){
            return;
        } else {
            if(piggie.getPlayerID() == 0){
                piggie.setPlayerID(1);
            } else if(piggie.getPlayerID() == 1){
                piggie.setPlayerID(0);
            }
            /*else if(piggie.getPlayerID() == 2){
                piggie.setPlayerID(3);
            }else if(piggie.getPlayerID() == 3){
                piggie.setPlayerID(0);
            }*/
        }
    }

}// class PigLocalGame
