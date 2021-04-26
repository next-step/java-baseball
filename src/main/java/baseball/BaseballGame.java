package baseball;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersComparator;
import baseball.domain.BaseballNumbersProvider;
import baseball.domain.Score;
import baseball.domain.player.Computer;
import baseball.domain.player.PlayStatus;
import baseball.domain.player.Player;
import baseball.ui.BaseballIO;

import static baseball.domain.BaseballGameRule.COUNT_OF_BASEBALL_NUMBERS;
import static baseball.domain.player.PlayStatus.PLAY;
import static baseball.ui.message.IOMessage.CORRECT_ANSWER_MESSAGE;
import static baseball.ui.message.IOMessage.END;

public class BaseballGame {

    private static Computer computer;
    private static BaseballNumbers playerNumbers;

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        computer = new Computer(generateComputerNumber());
        Player player = new Player(PLAY);
        initPlayerNumbers();
        while (player.isPlaying()) {
            playingGame();
            askReplay(player);
            reStartGame(player);
        }
    }

    private static void reStartGame(Player player) {
        if (player.isPlaying()) {
            startGame();
            return;
        }
        BaseballIO.printlnMessage(END.getMessage());
    }

    private static void askReplay(Player player) {
        String response = null;
        do {
            response = BaseballIO.askReplay();
        } while (!isValidResponse(player, response));
        player.setPlayStatus(PlayStatus.getPlayStatus(response));
    }

    private static boolean isValidResponse(Player player, String response) {
        try {
            PlayStatus.getPlayStatus(response);
            return true;
        } catch (Exception e) {
            return false;
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
            playerNumbers = new BaseballNumbers(BaseballIO.requirePlayerNumber());
        } catch (Exception e) {
            initPlayerNumbers();
            BaseballIO.printlnMessage(e.getMessage());
        }
    }

    private static void initPlayerNumbers() {
        playerNumbers = null;
    }

    private static BaseballNumbers generateComputerNumber() {
        return BaseballNumbersProvider.provideBaseballNumbers();
    }

}
