package com.ssp.player.playbehavior;

import com.ssp.rules.Turn;

public class RepeatedPlayBehavior implements PlayBehavior {

    private Turn repeatedTurn;

    public RepeatedPlayBehavior(Turn repeatedTurn) {
        this.repeatedTurn = repeatedTurn;
    }

    public Turn takeTurn() {
        return repeatedTurn;
    }
}
