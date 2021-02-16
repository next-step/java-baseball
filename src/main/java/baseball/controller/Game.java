package baseball.controller;

import baseball.domain.BaseballDigit;
import baseball.domain.BaseballRandomDigits;
import baseball.domain.GameCommand;
import baseball.view.InputView;

public class Game {
    private final BaseballRandomDigits baseballRandomDigits;
    private final Boolean isRestart = true;

    public Game(BaseballRandomDigits baseballRandomDigits) {
        this.baseballRandomDigits = baseballRandomDigits;
    }

    public void start() {
        initialGame();
        while (isRestart) {
            ballChecker();
            isRestart();
        }
    }

    private void ballChecker() {
        // TODO: random, 입력 값 비교
        BaseballDigit baseballDigit = InputView.getBaseballNumbers();
    }

    private void initialGame() {
        baseballRandomDigits.generateBaseballRandomDigits();
    }

    private Boolean isRestart() {
        if (InputView.restartGame() == GameCommand.RESTART) {
            return true;
        }
        return false;
    }
}
