package baseball;

import baseball.controller.Game;
import baseball.domain.BaseballRandomDigits;

public class Application {
    public static void main(String[] args) {
        BaseballRandomDigits randomBaseballDigits = new BaseballRandomDigits();
        Game game = new Game(randomBaseballDigits);
        game.start();
    }
}
