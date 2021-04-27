package com.nextstep.baseball;

import com.nextstep.baseball.handler.GameHandler;

public class GameStarter {
    private static final GameHandler gameHandler = new GameHandler();

    public static void main(String[] args) {
        gameHandler.startGame();
    }
}
