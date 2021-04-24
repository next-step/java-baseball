package baseball;

import com.google.common.annotations.VisibleForTesting;

import static baseball.BaseBallRandomNumber.RANDOM_NUMBER_LENGTH;

public class BaseBallGame {
    private final BaseBallRandomNumber randomNumber = new BaseBallRandomNumber();

    public void newGame() {
        randomNumber.initialize();
    }

    public void startGame() {
        BaseBallGuessResult guessResult = new BaseBallGuessResult();
        while (!guessResult.isCorrect()) {
            guessResult = guessNumber(UserInterface.printGuideAndScanUserInput());
            UserInterface.printGuessResult(guessResult);
        }
        UserInterface.printGameComplete();
    }

    @VisibleForTesting
    BaseBallGuessResult guessNumber(String guess) {
        BaseBallGuessResult guessResult = new BaseBallGuessResult();
        guessResult.setStrike(countStrike(randomNumber.getNumber(), guess));
        guessResult.setBall(countBall(randomNumber.getNumber(), guess));

        return guessResult;
    }

    @VisibleForTesting
    int countStrike(String goal, String guess) {
        int strike = 0;
        for (int i = 0; i< RANDOM_NUMBER_LENGTH; i++) {
            strike += goal.charAt(i) == guess.charAt(i) ? 1 : 0;
        }
        return strike;
    }

    @VisibleForTesting
    int countBall(String goal, String guess) {
        int ball = 0;
        for (int i = 0; i< RANDOM_NUMBER_LENGTH; i++) {
            ball += goal.contains(guess.substring(i, i + 1)) ? 1 : 0;
            ball -= goal.charAt(i) == guess.charAt(i) ? 1 : 0;
        }
        return ball;
    }
}
