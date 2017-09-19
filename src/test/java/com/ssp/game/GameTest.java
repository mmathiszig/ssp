package com.ssp.game;

import com.ssp.player.Player;
import com.ssp.player.playbehavior.PlayBehavior;
import org.junit.Test;

import static com.ssp.rules.Turn.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    @Test
    public void gameRunReturnsExpectedResult() throws Exception {

        PlayBehavior behaviorA = mock(PlayBehavior.class);
        when(behaviorA.takeTurn()).thenReturn(PAPER, STONE, PAPER, STONE, PAPER, STONE, PAPER);

        PlayBehavior behaviorB = mock(PlayBehavior.class);
        when(behaviorB.takeTurn()).thenReturn(PAPER, STONE, STONE, SCISSORS, STONE, SCISSORS, SCISSORS);

        Game game = new Game(new Player(behaviorA), new Player(behaviorB));

        GameResult result = game.run(7);

        assertEquals(result.getPlayerAWins(), 4);
        assertEquals(result.getPlayerBWins(), 1);
        assertEquals(result.getDraws(), 2);
    }

}