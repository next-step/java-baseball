package game.baseball.number;

import game.baseball.number.participants.NumbersBaseballGame;
import game.baseball.number.status.GameProgressStatus;

public class GameStarter {

    public static void main(String[] args) {
        NumbersBaseballGame numbersBaseballGame = new NumbersBaseballGame();
        do {
            numbersBaseballGame.start();
        } while (GameProgressStatus.checkRestartOrExit(GameProgressStatus.inputRestartOrExit()));
    }
}
