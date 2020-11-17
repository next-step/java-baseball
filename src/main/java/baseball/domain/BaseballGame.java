package baseball.domain;
import baseball.exception.GameMenuException;
import baseball.util.Util;
import baseball.view.Print;

public class BaseballGame {

    private static final int GAME_RESTART = 1;
    private static final int GAME_STOP = 2;

    private BaseballNumbersGenerator baseballNumbersGenerator;
    private BaseballNumbers computerNumbers;
    private BaseballNumbers userNumbers;
    private BallCount ballCount;

    public BaseballGame() {
        this.baseballNumbersGenerator = new BaseballNumbersGenerator();
        this.ballCount = new BallCount();
    }

    public void start() {
        computerNumbers = baseballNumbersGenerator.generateComputerNumbers();

        while (!hasWinner()) {
            ballCount.clear();
            userNumbers = baseballNumbersGenerator.generateUserNumbers(Util.requestUserNumbers());
        }

        Print.infromGameEnd();

        if (shouldRestart()) {
            userNumbers = null;
            start();
        }
    }

    public boolean hasWinner() {
        if (userNumbers == null) {
            return false;
        }

        for (int i = 0; i <userNumbers.size(); i++) {
            checkBallCount(i);
        }
        Print.showCurrentBallCount(ballCount.getCurrent());

        return ballCount.isAllStrike();
    }

    public void checkBallCount(int index) {
        if (computerNumbers.equalsNumberAndIndex(index, userNumbers.get(index))) {
            ballCount.addStrike();
            return;
        }

        if (computerNumbers.contains(userNumbers.get(index))) {
            ballCount.addBall();
        }
    }

    public boolean shouldRestart() {
        int gameMenu = Util.requestRestart();
        if (gameMenu == GAME_RESTART) {
            return true;
        }

        if (gameMenu == GAME_STOP) {
            return false;
        }

        throw new GameMenuException();
    }


}
