package com.game;

import com.game.baseball.BaseballGame;
import com.game.global.Game;

import java.util.InputMismatchException;

public class GameApplication {

    private Game game;

    public GameApplication(Game game) {
        this.game = game;
    }


    public static void main(String[] args) {
        GameApplication gameApplication = new GameApplication(new BaseballGame());
        gameApplication.run();
    }


    private void run() {
        game.setup();
        game.play();
        game.replay();
    }

}
