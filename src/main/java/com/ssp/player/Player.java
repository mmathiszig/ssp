package com.ssp.player;

import com.ssp.player.playbehavior.PlayBehavior;
import com.ssp.rules.TurnResult;
import com.ssp.rules.Turn;

/**
 * Each participant of a game is represented by a {@code Player} instance.
 *
 * The class provides logic to play a game round against another player depending
 * on the two players' {@code PlayBehavior} implementations.
 */
public class Player {

    private PlayBehavior playBehavior;

    /**
     * Initializes a new player.
     *
     * @param playBehavior The desired behavior implementation for the player.
     */
    public Player(PlayBehavior playBehavior) {
        this.playBehavior = playBehavior;
    }

    /**
     * Makes the player compete with a given opponent player in a single game round.
     *
     * @param opponent The opponent player to compete with.
     * @return The outcome of competing with the opponent.
     */
    public TurnResult competeWith(Player opponent) {

        Turn ownTurn = takeTurn();
        Turn opponentsTurn = opponent.takeTurn();

        return ownTurn.competeWith(opponentsTurn);
    }

    /**
     * Makes the player take his turn for a game round.
     *
     * @return
     */
    private Turn takeTurn() {
        return playBehavior.takeTurn();
    }
}
