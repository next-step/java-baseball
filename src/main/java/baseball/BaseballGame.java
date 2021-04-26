package baseball;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersComparator;
import baseball.domain.BaseballNumbersProvider;
import baseball.domain.Score;
import baseball.domain.player.Computer;
import baseball.domain.player.Player;
import baseball.ui.BaseballIO;

import static baseball.domain.BaseballGameRule.COUNT_OF_BASEBALL_NUMBERS;
import static baseball.domain.player.PlayStatus.PLAY;
import static baseball.ui.message.IOMessage.CORRECT_ANSWER_MESSAGE;

public class BaseballGame {

    private static Computer computer;
    private static BaseballNumbers playerNumbers;

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        computer = new Computer(generateComputerNumber());
        Player player = new Player(PLAY);
        while (player.isPlaying()) {
            playingGame();
            // TODO 진행여부 묻고, 상태 변경
            //player.setPlayStatus(STOP);
        }
    }

    private static void playingGame() {
        requirePlayerNumber();
    }

    private static void requirePlayerNumber() {
        while (isNotValidPlayerNumber() || isNotCorrectAnswer()) {
            generatePlayerNumber();
        }
    }

    private static boolean isNotValidPlayerNumber() {
        return playerNumbers == null;
    }

    private static boolean isNotCorrectAnswer() {
        BaseballNumbers computerBaseballNumbers = computer.getBaseballNumbers();
        Score score = BaseballNumbersComparator.getScore(computerBaseballNumbers, playerNumbers);
        return !isCorrectAnswer(score);
    }

    private static boolean isCorrectAnswer(Score score) {
        if (score.getStrike() == COUNT_OF_BASEBALL_NUMBERS.getValue()) {
            BaseballIO.printlnMessage(CORRECT_ANSWER_MESSAGE.getMessage());
            return true;
        }
        BaseballIO.printResult(score.getStrike(), score.getBall());
        return false;
    }

    private static void generatePlayerNumber() {
        try {
            playerNumbers = new BaseballNumbers(BaseballIO.readInput());
        } catch (Exception e) {
            playerNumbers.setNull();
            BaseballIO.printlnMessage(e.getMessage());
        }
    }

    private static BaseballNumbers generateComputerNumber() {
        return BaseballNumbersProvider.provideBaseballNumbers();
    }

}
