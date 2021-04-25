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
            String guess = UserInterface.printGuideAndScanGuessNumber();

            guessResult = BaseBallReferee.calculate(goal, guess);
            UserInterface.printGuessResult(guessResult);
        }
        UserInterface.printGameComplete();
    }

    public boolean wantAnotherGame() {
        String userInput = UserInterface.printGuideAndScanExitCommand();

        return UserInterface.COMMAND_ANOTHER_GAME.equals(userInput);
    }

    @VisibleForTesting
    boolean isGuessCorrect(BaseBallGuessResult guessResult) {
        return guessResult.getStrikeCount() == BaseBallRandomNumber.RANDOM_NUMBER_LENGTH;
    }
}
