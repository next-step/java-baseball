package domain;

import view.InputView;
import view.OutputView;

public class BaseBallGame {

    private static final int RESTART = 1;
    private static final int EXIT = 2;

    public void playBall () {
        int restartFrag = RESTART;
        while (restartFrag != EXIT) {
            ComputerBallNumber computerBallNumber = new ComputerBallNumber(new RandomNumberGenerator());
            boolean isMatch = false;
            repeatUntilMatchBalls(isMatch, computerBallNumber);
            OutputView.printAllMatchBallsMessage();
            restartFrag = inputRestartFlagWithValidation();
        }
    }

    private static void repeatUntilMatchBalls(boolean isMatch, ComputerBallNumber computerBallNumber) {
        while (!isMatch) {
            PlayerBallNumber playerBallNumber = createPlayerWithInputNumber();
            BaseBallResult baseBallResult = new BaseBallResult(computerBallNumber, playerBallNumber);
            OutputView.printBaseBallResult(baseBallResult);
            isMatch = baseBallResult.isThreeStrike();
        }
    }

    private static PlayerBallNumber createPlayerWithInputNumber() {
        try {
            return new PlayerBallNumber(new PlayerNumberGenerator(InputView.inputPlayerBallNumber()));
        } catch (IllegalArgumentException | NullPointerException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return createPlayerWithInputNumber();
        }
    }

    private static int inputRestartFlagWithValidation() {
        try {
            int input = InputView.inputRestartOrExitNumber();
            checkGameProgressValue(input);
            return input;
        } catch (IllegalArgumentException | NullPointerException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputRestartFlagWithValidation();
        }
    }

    private static void checkGameProgressValue(int gameProgressValue) {
        if (gameProgressValue != RESTART && gameProgressValue != EXIT) {
            throw new IllegalArgumentException("입력할 수 있는 범위가 아닙니다.");
        }
    }

}
