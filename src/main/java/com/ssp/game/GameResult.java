package com.ssp.game;

import java.io.PrintStream;

public class GameResult {

    private final int roundsPlayed;

    private final int playerAWins;

    private final int playerBWins;

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

    public void printTo(PrintStream stream) {

        stream.println("Player A won " + playerAWins + " times.");
        stream.println("Player B won " + playerBWins + " times.");
        stream.println("Draw ....... " + getDraws() + " times.");
    }
}
