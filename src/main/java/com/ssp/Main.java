package com.ssp;

import com.ssp.game.Game;
import com.ssp.game.GameResult;
import com.ssp.player.Player;
import com.ssp.player.playbehavior.PlayBehavior;
import com.ssp.player.playbehavior.RandomPlayBehavior;
import com.ssp.player.playbehavior.RepeatedPlayBehavior;

import static com.ssp.rules.Turn.PAPER;

/**
 * Entry point -- This runs a game of multiple rounds with two differently behaving players.
 *
 */
public class Main {

    public static void main(String[] args) {

        // Setup Player A
        PlayBehavior playBehaviorA = new RandomPlayBehavior();
        Player playerA = new Player(playBehaviorA);

        // Setup Player B
        PlayBehavior playBehaviorB = new RepeatedPlayBehavior(PAPER);
        Player playerB = new Player(playBehaviorB);

        // Setup and run game
        Game game = new Game(playerA, playerB);
        GameResult result = game.run(100);

        // Print results
        result.printTo(System.out);
    }
}
