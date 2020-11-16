package baseball;

import baseball.domain.BaseballNumbers;
import baseball.exception.InvalidNumbersException;
import baseball.util.RandomNumberGenerate;
import baseball.view.BaseballView;

public class BaseballGame {
    public void run() {
        do {
            start();
        } while (isExit());
    }

    private void start() {
        BaseballNumbers answerNumbers = new BaseballNumbers(
                RandomNumberGenerate.generate(3));

        BaseballNumbers playerNumbers;
        do {
            playerNumbers = confirmNumber(BaseballView.askNumber());
        } while (!checkNumbers(answerNumbers, playerNumbers));
    }

    public boolean checkNumbers(BaseballNumbers answerNumbers, BaseballNumbers playerNumbers) {
        if (answerNumbers.isEmpty() || playerNumbers.isEmpty()) {
            return false;
        }
        return true;
    }

    public BaseballNumbers confirmNumber(int number) {
        try {
            return new BaseballNumbers(number);
        } catch (InvalidNumbersException e) {
            System.out.println(e.getMessage());
        }
        return new BaseballNumbers();
    }

    public boolean isExit() {
        return true;
    }
}
