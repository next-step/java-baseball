package baseball;

import baseball.domain.BaseballNumbersProvider;
import baseball.domain.player.Computer;

public class BaseballGame {

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        Computer computer = new Computer(BaseballNumbersProvider.provideBaseballNumbers());
    }

}
