package com.ssp.rules;

import static com.ssp.rules.TurnResult.*;

public enum Turn {

    STONE, SCISSORS, PAPER;


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
