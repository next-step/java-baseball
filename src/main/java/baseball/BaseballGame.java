package baseball;

import baseball.constant.GameCommandType;
import baseball.domain.BaseballNumbers;
import baseball.domain.GameScore;
import baseball.exception.BizException;
import baseball.exception.BizExceptionType;
import baseball.util.BaseballUtil;
import baseball.util.MessageUtil;

import java.util.Scanner;

public class BaseballGame {

    boolean isExit = false;
    private Scanner scanner = new Scanner(System.in);


    public void play() {
        while (!isExit) {
            doGame();
        }
    }

    public void doGame() {

        //3개 맞출 때까지
        boolean isGameClear = false;
        String[] randomNumbers = BaseballUtil.getRandomNumbers();

        while (!isGameClear) {
            MessageUtil.printStartMessage();
            String inputText = scanner.nextLine();

            BaseballNumbers baseballNumbers = new BaseballNumbers(inputText);
            baseballNumbers.checkValidation();

            GameScore gameScore = new GameScore();
            gameScore.checkGameScore(randomNumbers, baseballNumbers.getNumbers());

            MessageUtil.printGameResult(gameScore);
            isGameClear = gameScore.isGameClear();
        }
        MessageUtil.printRetryAskMessage();
        askExit();
    }

    public void askExit() {
        String command = scanner.nextLine();
        if (!GameCommandType.isExistType(command)) {
            throw new BizException(BizExceptionType.INVALID_COMMAND);
        }
        if (command.equals(GameCommandType.EXIT.getCommand())) {
            isExit = true;
        }
    }

}
