package com.ssp.rules;

import static com.ssp.rules.TurnResult.*;

/**
 * The possible turns for a player when playing the game.
 *
 * Also contains the static game rules which define the outcome
 * of a game round depending on the turns selected by the two players.
 *
 */
public enum Turn {

    STONE, SCISSORS, PAPER;

    /**
     * Returns the outcome of a game round in which this turn competes with a given other turn.
     *
     * @param otherTurn The turn to compete with.
     * @return The result of competing with the given other turn.
     */
    public TurnResult competeWith(Turn otherTurn) {

        if (this.equals(otherTurn)) {
            return DRAW;
        }

        if (this.defeats(otherTurn)) {
            return WIN;

        } else {
            return LOOSE;
        }
    }

    /**
     * Returns {@code true} if this turn defeats the given turn, {@code false} otherwise.
     *
     * @param turn
     * @return
     */
    public boolean defeats(Turn turn) {

        switch (this) {

            case PAPER:
                return turn.equals(STONE);

            case STONE:
                return turn.equals(SCISSORS);

            case SCISSORS:
                return turn.equals(PAPER);

            default:
                throw new IllegalStateException("Turn " + turn + " not implemented.");
        }
    }
}
