package com.ssp.game;

import com.ssp.player.Player;
import com.ssp.rules.TurnResult;

/**
 * A {@code Game} connects two players to compete with each other in multiple game rounds.
 *
 */
public class Game {

    private final Player playerA;

    private final Player playerB;

    /**
     * Initializes a new game with the given players.
     *
     * @param playerA The first participant.
     * @param playerB The second participant.
     */
    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    /**
     * Makes the two players compete with each other for a given amount of game rounds.
     *
     * @param rounds The desired number of game rounds.
     * @return The combined results of the rounds played.
     */
    public GameResult run(int rounds) {

        int winCountA = 0;
        int winCountB = 0;

        for (int i = 0; i < rounds; i++) {

            TurnResult turnResultA = playerA.competeWith(playerB);

            switch (turnResultA) {
                case WIN:
                    winCountA++;
                    break;

                case LOOSE:
                    winCountB++;
                    break;

                default:
                    // (Draws are derived from the total rounds, no counting necessary)
                    break;
            }
        }

        return new GameResult(rounds, winCountA, winCountB);
    }
}
