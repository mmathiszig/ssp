package com.ssp.player.playbehavior;

import com.ssp.rules.Turn;

/**
 * Abstraction of a player's behavior when taking turns.
 *
 * {@code PlayBehavior} allows composition of players with different strategies.
 */
public interface PlayBehavior {

    /**
     * Encapsulates the logic to make a player select a {@code Turn} in a game round.
     *
     * @return The selected turn.
     */
    public Turn takeTurn();
}
