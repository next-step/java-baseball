package baseball;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersProvider;
import baseball.domain.player.Computer;
import baseball.domain.player.Player;
import baseball.ui.BaseballIO;

import static baseball.domain.player.PlayStatus.PLAY;

public class BaseballGame {

    private static Computer computer;
    private static BaseballNumbers playerNumber;

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        computer = new Computer(generateComputerNumber());
        Player player = new Player(PLAY);
        while (player.isPlaying()) {
            playingGame();
            // TODO 진행여부 묻고, 상태 변경
            // player.setPlayStatus(STOP);
        }
    }

    private static void playingGame() {
        // TODO 맞힐때 까지 반복
        requirePlayerNumber();
    }

    private static void requirePlayerNumber() {
        while (playerNumber == null) {
            generatePlayerNumber();
        }
    }

    private static void generatePlayerNumber() {
        try {
            playerNumber = new BaseballNumbers(BaseballIO.readInput());
        } catch (Exception e) {
            BaseballIO.printlnMessage(e.getMessage());
        }
    }

    private static BaseballNumbers generateComputerNumber() {
        return BaseballNumbersProvider.provideBaseballNumbers();
    }

}
