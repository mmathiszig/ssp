package com.ssp.player;

import com.ssp.player.playbehavior.RepeatedPlayBehavior;
import com.ssp.rules.Turn;
import com.ssp.rules.TurnResult;
import org.junit.Test;

import static com.ssp.rules.Turn.PAPER;
import static com.ssp.rules.Turn.STONE;
import static com.ssp.rules.TurnResult.DRAW;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void paperPlayerCompetesWithStonePlayer() throws Exception {

        Player paperPlayer = new Player(new RepeatedPlayBehavior(PAPER));
        Player stonePlayer = new Player(new RepeatedPlayBehavior(STONE));

        assertEquals(paperPlayer.competeWith(stonePlayer), TurnResult.WIN);
        assertEquals(stonePlayer.competeWith(paperPlayer), TurnResult.LOOSE);
    }

    @Test
    public void paperPlayerCausesDrawWithHimself() throws Exception {

        Player paperPlayer = new Player(new RepeatedPlayBehavior(PAPER));

        assertEquals(paperPlayer.competeWith(paperPlayer), DRAW);
    }

}