package baseball;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersProvider;
import baseball.domain.player.Computer;
import baseball.ui.BaseballIO;

public class BaseballGame {

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        Computer computer = new Computer(BaseballNumbersProvider.provideBaseballNumbers());
        // TODO 플레이어의 수 입력 받기
        BaseballNumbers playerNumber = new BaseballNumbers(BaseballIO.readInput());
    }

}
