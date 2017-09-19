package com.ssp.player.playbehavior;

import com.ssp.rules.Turn;
import org.junit.Test;

import static com.ssp.rules.Turn.*;
import static org.junit.Assert.*;

public class RepeatedPlayBehaviorTest {

    @Test
    public void takeTurnReturnsGivenTurnMultipleTimes() throws Exception {


        for (Turn turn : Turn.values()) {

            RepeatedPlayBehavior behavior = new RepeatedPlayBehavior(turn);

            assertEquals(behavior.takeTurn(), turn);
            assertEquals(behavior.takeTurn(), turn);
            assertEquals(behavior.takeTurn(), turn);
        }
    }

}