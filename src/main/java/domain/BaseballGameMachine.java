package domain;

import view.InputView;
import view.OutputView;

public class BaseballGameMachine {
    private BaseballGame baseballGame;
    private boolean baseballGameContinue;

    public BaseballGameMachine(BaseballGame baseballGame, boolean baseballGameContinue) {
        this.baseballGame = baseballGame;
        this.baseballGameContinue = baseballGameContinue;
    }

    public static BaseballGameMachine initGame() {
        return new BaseballGameMachine(BaseballGame.startGame(), true);
    }

    public void guessIteration() {
        while (guess());
    }

    public boolean guess() {
        String userNumberRaw = InputView.inputUserNumber();
        GameNumber userNumber = GameNumber.ofByRaw(userNumberRaw);

        GuessResult guessResult = baseballGame.getGuessResult(userNumber);

        OutputView.printResult(guessResult);
        return isContinueGuess(guessResult);
    }

    private boolean isContinueGuess(GuessResult guessResult) {
        return !guessResult.isThreeStrike();
    }

    public boolean isBaseballGameContinue() {
        return baseballGameContinue;
    }

    public void continueGameByInput() {
        int continueNumber = InputView.inputContinueNumber();
        if (continueNumber == 2) {
            baseballGameContinue = false;
            return;
        }
        if (continueNumber == 1) {
            baseballGame = BaseballGame.startGame();
            baseballGameContinue = true;
            return;
        }
        throw new IllegalArgumentException("1 또는 2의 값을 입력해야합니다.");
    }
}
