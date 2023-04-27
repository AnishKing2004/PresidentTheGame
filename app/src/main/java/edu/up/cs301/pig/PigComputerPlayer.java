package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState pig = (PigGameState) info;
        if(pig.getPlayerID() != playerNum){
            return;
        }
        Random r = new Random();
        if (r.nextBoolean()){
            sleep(1000);

            PigHoldAction pha = new PigHoldAction(this);

            this.game.sendAction(pha);
        } else {
            sleep(1000);
            PigRollAction pra = new PigRollAction((this));

            this.game.sendAction(pra);
        }
        // TODO  You will implement this method
    }//receiveInfo

}
