package domain;

public class BaseballGameMachine {
    public static final int INPUT_CONTINUE_GAME = 1;
    public static final int INPUT_STOP_GAME = 2;

    private BaseballGame baseballGame;
    private boolean baseballGameContinue;

    protected BaseballGameMachine(BaseballGame baseballGame, boolean baseballGameContinue) {
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
        if (stopGameIfInputStop(input)) return;
        if (continueGameIfInputContinue(input)) return;
        throw new IllegalArgumentException("1 또는 2의 값을 입력해야 합니다.");
    }

    private boolean continueGameIfInputContinue(int input) {
        if (input == INPUT_CONTINUE_GAME) {
            baseballGame = BaseballGame.startNewGame();
            baseballGameContinue = true;
            return true;
        }
        return false;
    }

    private boolean stopGameIfInputStop(int input) {
        if (input == INPUT_STOP_GAME) {
            baseballGameContinue = false;
            return true;
        }
        return false;
    }


    protected BaseballGame getBaseballGame() {
        return baseballGame;
    }
}
