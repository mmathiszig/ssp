package com.ssp.player;

import com.ssp.player.playbehavior.PlayBehavior;
import com.ssp.rules.TurnResult;
import com.ssp.rules.Turn;

public class Player {

    private PlayBehavior playBehavior;

    public Player(PlayBehavior playBehavior) {
        this.playBehavior = playBehavior;
    }

    public TurnResult competeWith(Player opponent) {

        Turn ownTurn = takeTurn();
        Turn opponentsTurn = opponent.takeTurn();

        return ownTurn.competeWith(opponentsTurn);
    }

    private Turn takeTurn() {
        return playBehavior.takeTurn();
    }
}
