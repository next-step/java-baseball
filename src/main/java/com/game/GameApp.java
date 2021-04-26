package com.game;
import com.game.baseball.BaseballGame;
import com.game.player.ComGeneration;
import com.game.player.UserGeneration;

public class GameApp {
    public static void main(String[] args) {
        boolean isPlayingGame = true;
        while (isPlayingGame) {
            BaseballGame baseballGame = new BaseballGame(new ComGeneration(), new UserGeneration());
            baseballGame.playGame();
            baseballGame.exitGame();
            isPlayingGame = baseballGame.isRunning();
        }
    }
}

