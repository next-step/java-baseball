package com.game;

import com.game.baseball.BaseballGame;
import com.game.common.Game;

public class GameApplication {

    public static void main(String[] args) {
        Game game = new BaseballGame();
        game.start();
    }
}
