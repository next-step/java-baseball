package baseball;

import com.google.common.annotations.VisibleForTesting;

public class BaseBallGame {
    private final BaseBallRandomNumber randomNumber = new BaseBallRandomNumber();

    public void newGame() {
        randomNumber.initialize();
    }

    public void startGame() {
        BaseBallGuessResult guessResult = new BaseBallGuessResult();
        while (!isGuessCorrect(guessResult)) {
            String goal = randomNumber.getNumber();
            String guess = UserInterface.printGuideAndScanUserInput();

            guessResult = BaseBallReferee.calculate(goal, guess);
            UserInterface.printGuessResult(guessResult);
        }
        UserInterface.printGameComplete();
    }

    @VisibleForTesting
    boolean isGuessCorrect(BaseBallGuessResult guessResult) {
        return guessResult.getStrikeCount() == BaseBallRandomNumber.RANDOM_NUMBER_LENGTH;
    }
}
