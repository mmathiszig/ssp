package com.ssp.player.playbehavior;

import com.ssp.rules.Turn;
import com.ssp.rules.TurnResult;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

import static com.ssp.rules.Turn.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RandomPlayBehaviorTest {

    @Test
    public void takeTurnReturnsNonEmptyTurn() throws Exception {

        RandomPlayBehavior behavior = new RandomPlayBehavior();
        assertNotNull(behavior.takeTurn());
    }

    @Test
    public void takeTurnReturnsDifferentTurnsForDifferentRandomNumbers() {

        Random random = mock(Random.class);

        when(random.nextInt(anyInt()))
                .thenReturn(0, 1, 2);

        RandomPlayBehavior behavior = new RandomPlayBehavior(random);

        HashSet<Turn> results = new HashSet<Turn>();
        results.add(behavior.takeTurn());
        results.add(behavior.takeTurn());
        results.add(behavior.takeTurn());

        assertTrue(results.contains(PAPER));
        assertTrue(results.contains(STONE));
        assertTrue(results.contains(SCISSORS));
    }

}