package com.ssp.player.playbehavior;

import com.ssp.rules.Turn;

import java.util.Random;

public class RandomPlayBehavior implements PlayBehavior {


    private final Random random;

    public RandomPlayBehavior(Random random) {
        this.random = random;
    }

    public RandomPlayBehavior() {
        this(new Random());
    }


    public Turn takeTurn() {

        int moveOptionCount = Turn.values().length;
        int randomOptionIndex = random.nextInt(moveOptionCount);

        return Turn.values()[randomOptionIndex];
    }
}
