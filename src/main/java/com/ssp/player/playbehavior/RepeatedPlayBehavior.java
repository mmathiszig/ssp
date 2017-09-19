package com.ssp.player.playbehavior;

import com.ssp.rules.Turn;

/**
 * A {@code PlayBehavior} which makes the player select the
 * same {@code Turn} over and over again.
 *
 */
public class RepeatedPlayBehavior implements PlayBehavior {

    private final Turn repeatedTurn;

    /**
     * Initializes a new {@code RepeatedPlayBehavior} with the given turn.
     *
     * @param repeatedTurn The turn to be repeated constantly.
     */
    public RepeatedPlayBehavior(Turn repeatedTurn) {
        this.repeatedTurn = repeatedTurn;
    }

    public Turn takeTurn() {
        return repeatedTurn;
    }
}
