package com.ssp.rules;

import org.junit.Test;

import static com.ssp.rules.Turn.*;
import static com.ssp.rules.TurnResult.*;
import static org.junit.Assert.*;

public class TurnTest {

    @Test
    public void paperDefeatsStoneOnly() throws Exception {
        assertTurnDefeatsOtherTurnOnly(PAPER, STONE);
    }

    @Test
    public void stoneDefeatsScissorsOnly() throws Exception {
        assertTurnDefeatsOtherTurnOnly(STONE, SCISSORS);
    }

    @Test
    public void scissorsDefeatPaperOnly() throws Exception {
        assertTurnDefeatsOtherTurnOnly(SCISSORS, PAPER);
    }

    private void assertTurnDefeatsOtherTurnOnly(Turn turn, Turn otherTurn) {

        for (Turn possibleOtherTurn : Turn.values()) {

            if (turn.defeats(possibleOtherTurn)) {
                assertEquals(possibleOtherTurn, otherTurn);

            } else {
                assertNotEquals(possibleOtherTurn, otherTurn);
            }
        }
    }


    @Test
    public void competeWithWinResultConditions() throws Exception {

        assertEquals(PAPER.competeWith(STONE), WIN);
        assertEquals(STONE.competeWith(SCISSORS), WIN);
        assertEquals(SCISSORS.competeWith(PAPER), WIN);
    }

    @Test
    public void competeWithLooseResultConditions() throws Exception {

        assertEquals(PAPER.competeWith(SCISSORS), LOOSE);
        assertEquals(STONE.competeWith(PAPER), LOOSE);
        assertEquals(SCISSORS.competeWith(STONE), LOOSE);
    }

    @Test
    public void competeWithDrawResultConditions() throws Exception {

        for (Turn turn : Turn.values()) {
            assertEquals(turn.competeWith(turn), DRAW);
        }
    }

    @Test
    public void swappingCompeteWithNegatesResult() throws Exception {

        for (Turn turnA : Turn.values()) {

            for (Turn turnB : Turn.values()) {

                TurnResult turnBCompeteWithTurnA = turnB.competeWith(turnA);
                TurnResult turnACompeteWithTurnB = turnA.competeWith(turnB);

                switch (turnACompeteWithTurnB) {

                    case WIN:
                        assertEquals(turnBCompeteWithTurnA, LOOSE);
                        break;

                    case LOOSE:
                        assertEquals(turnBCompeteWithTurnA, WIN);
                        break;

                    case DRAW:
                        assertEquals(turnBCompeteWithTurnA, DRAW);
                        break;

                    default:
                        throw new IllegalStateException("Not implemented: " + turnACompeteWithTurnB);
                }
            }
        }
    }
}