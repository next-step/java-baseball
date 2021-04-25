package application.cli;

import domain.core.Game;
import domain.core.InputCoin;

public class GameMachine {
    private final Game game;
    private boolean hasCoin;

    private GameMachine(Game game) {
        this.game = game;
    }

    public static GameMachine of(Game game){
        return new GameMachine(game);
    }

    private void init() {
        this.hasCoin = true;
    }

    public void start() {
        init();
        while (hasCoin) {
            game.start();
            reGame();
        }
    }

    private void reGame() {
        InputCoin inputCoin = InputCoin.newInstance();
        if (inputCoin.getInput().equals("2")) {
            hasCoin = false;
        }
    }
}
