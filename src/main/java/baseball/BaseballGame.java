package baseball;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersProvider;
import baseball.domain.player.Computer;
import baseball.domain.player.Player;
import baseball.ui.BaseballIO;

import static baseball.domain.player.PlayStatus.PLAY;

public class BaseballGame {

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        Computer computer = new Computer(BaseballNumbersProvider.provideBaseballNumbers());
        Player player = new Player(PLAY);
        if (player.getPlayStatus() == PLAY) {
            BaseballNumbers playerNumber = new BaseballNumbers(BaseballIO.readInput());
        }
    }

}
