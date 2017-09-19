package com.ssp.player.playbehavior;

import com.ssp.rules.Turn;

import java.util.Random;

/**
 * A {@code PlayBehavior} which makes the player select random turns.
 *
 */
public class RandomPlayBehavior implements PlayBehavior {

    private final Random random;

    /**
     * Initializes a new {@code RandomPlayBehavior} with a given {@code Random} instance.
     *
     * @param random {@code Random} instance used to decide about turns.
     */
    public RandomPlayBehavior(Random random) {
        this.random = random;
    }

    /**
     * Initializes a new {@code RandomPlayBehavior} with a fresh {@code Random} instance.
     */
    public RandomPlayBehavior() {
        this(new Random());
    }

    public Turn takeTurn() {

        int moveOptionCount = Turn.values().length;
        int randomOptionIndex = random.nextInt(moveOptionCount);

        return Turn.values()[randomOptionIndex];
    }
}
