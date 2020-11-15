package game.baseball.number.factory;

import game.baseball.number.NumberBaseballGame;

public class GameFactory {

    private GameFactory() {
    }

    public static NumberBaseballGame newNumberBaseballGame() {
        return new NumberBaseballGame();
    }
}