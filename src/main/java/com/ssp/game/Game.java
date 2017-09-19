package com.ssp.game;

import com.ssp.player.Player;
import com.ssp.rules.TurnResult;

public class Game {

    final private Player playerA;

    final private Player playerB;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public GameResult run(int rounds) {

        int winCountA = 0;
        int winCountB = 0;

        for (int i = 0; i < rounds; i++) {

            TurnResult turnResultA = playerA.competeWith(playerB);

            switch (turnResultA) {
                case WIN:
                    winCountA++;
                    break;

                case LOOSE:
                    winCountB++;
                    break;

                default:
                    // (Draws are derived from the total rounds, no counting necessary)
                    break;
            }
        }

        return new GameResult(rounds, winCountA, winCountB);
    }
}
