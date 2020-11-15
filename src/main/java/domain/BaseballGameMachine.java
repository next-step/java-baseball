package domain;

public class BaseballGameMachine {
    private BaseballGame baseballGame;
    private boolean baseballGameContinue;

    public BaseballGameMachine(BaseballGame baseballGame, boolean baseballGameContinue) {
        this.baseballGame = baseballGame;
        this.baseballGameContinue = baseballGameContinue;
    }

    public static BaseballGameMachine initGame() {
        return new BaseballGameMachine(BaseballGame.startNewGame(), true);
    }

    public GuessResult getGuessResult(GameNumber userNumber) {
        return baseballGame.getGuessResult(userNumber);
    }

    public boolean isContinueGuess(GuessResult guessResult) {
        return !guessResult.isThreeStrike();
    }

    public boolean isBaseballGameContinue() {
        return baseballGameContinue;
    }

    public void continueGameByInput(int input) {
        if (stopGameIfInputNumberTwo(input)) return;
        if (continueGameIfInputNumberOne(input)) return;
        throw new IllegalArgumentException("1 또는 2의 값을 입력해야 합니다.");
    }

    private boolean continueGameIfInputNumberOne(int input) {
        if (input == 1) {
            baseballGame = BaseballGame.startNewGame();
            baseballGameContinue = true;
            return true;
        }
        return false;
    }

    private boolean stopGameIfInputNumberTwo(int input) {
        if (input == 2) {
            baseballGameContinue = false;
            return true;
        }
        return false;
    }

}
