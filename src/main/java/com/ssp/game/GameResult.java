package com.ssp.game;

import java.io.PrintStream;

/**
 * Value object used to store the outcome of several game rounds played in a row.
 */
public class GameResult {

    private final int roundsPlayed;

    private final int playerAWins;

    private final int playerBWins;

    /**
     * Initializes the {@code GameResult} based on the number of game rounds won by each player.
     *
     * @param roundsPlayed The total amount of rounds played.
     * @param playerAWins The amount of rounds won by player A.
     * @param playerBWins The amount of rounds won by player B.
     */
    public GameResult(int roundsPlayed, int playerAWins, int playerBWins) {

        this.roundsPlayed = roundsPlayed;
        this.playerAWins = playerAWins;
        this.playerBWins = playerBWins;
    }

    public int getPlayerAWins() {
        return playerAWins;
    }

    public int getPlayerBWins() {
        return playerBWins;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public int getDraws() {
        return getRoundsPlayed() - getPlayerAWins() - getPlayerBWins();
    }

    /**
     * Prints the results as human readable text.
     *
     * @param stream The {@code PrintStream} used to print the text.
     */
    public void printTo(PrintStream stream) {

        stream.println("Player A won " + playerAWins + " times.");
        stream.println("Player B won " + playerBWins + " times.");
        stream.println("Draw ....... " + getDraws() + " times.");
    }
}
