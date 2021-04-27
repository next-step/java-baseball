package com.syl.game;

import com.syl.game.baseball.ui.BaseBallGame;

public class GameApplication {

    public static void main(String[] args) {

        BaseBallGame game = new BaseBallGame();
        do {
            game.play();
        } while (game.replay());

    }
}
