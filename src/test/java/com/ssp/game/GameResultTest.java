package com.ssp.game;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameResultTest {


    @Test
    public void resultWithNoDraws() throws Exception {

        GameResult noDrawsResult = new GameResult(10, 5, 5);
        assertEquals(noDrawsResult.getDraws(), 0);
    }


    @Test
    public void resultWithOnlyDraws() throws Exception {

        GameResult onlyDrawsResult = new GameResult(10, 0, 0);
        assertEquals(onlyDrawsResult.getDraws(), 10);
    }

    @Test
    public void resultWithSomeDraws() throws Exception {

        GameResult someDrawsResult = new GameResult(10, 3, 4);
        assertEquals(someDrawsResult.getDraws(), 3);
    }

}