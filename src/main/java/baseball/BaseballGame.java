package baseball;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballResult;
import baseball.exception.InvalidNumbersException;
import baseball.util.RandomNumberGenerate;
import baseball.view.BaseballView;

public class BaseballGame {
    public void run() {
        do {
            start();
        } while (isExit(BaseballView.askRetryOrExit()));
    }

    private void start() {
        BaseballNumbers answerNumbers = new BaseballNumbers(
                RandomNumberGenerate.generate(3));
        BaseballNumbers playerNumbers;
        BaseballResult baseballResult;
        do {
            playerNumbers = confirmNumber(BaseballView.askNumber());
            baseballResult = checkNumbers(answerNumbers, playerNumbers);
        } while (!isWin(baseballResult));
    }

    public boolean isWin(BaseballResult baseballResult) {
        if (baseballResult == null) {
            return false;
        }
        BaseballView.showResult(baseballResult);

        boolean isWin = baseballResult.isExactSame();
        if (isWin) {
            BaseballView.showWinMessage();
        }
        return isWin;
    }

    public BaseballResult checkNumbers(BaseballNumbers answerNumbers, BaseballNumbers playerNumbers) {
        if (playerNumbers.isEmpty()) {
            return null;
        }
        return new BaseballResult(answerNumbers, playerNumbers);
    }

    public BaseballNumbers confirmNumber(int number) {
        try {
            return new BaseballNumbers(number);
        } catch (InvalidNumbersException e) {
            System.out.println(e.getMessage());
        }
        return new BaseballNumbers();
    }

    public boolean isExit(int confirm) {
        return confirm == 1;
    }
}
