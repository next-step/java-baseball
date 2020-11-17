package baseball;

import java.util.List;

import baseball.domain.BallCount;
import baseball.domain.BallNumber;

/**
 * BaseBall Game
 * 2020.11.15.
 * parksangdonews
 */
public class BaseBallGame {

    public static final String INPUT_LENGTH_ERROR = "";
    private BallNumber dealerNumber;
    private BallCount ballCount;

    private BaseBallGame() {
    }

    public BaseBallGame(BallNumber dealerNumber) {
        this.dealerNumber = dealerNumber;
    }

    public void play(BallNumber playerInputNumber) {
        ballCount = new BallCount();
        List<String> dealerNumbers = dealerNumber.getBallNumber();
        List<String> playerInputNumbers = playerInputNumber.getBallNumber();
        getBallCount(dealerNumbers, playerInputNumbers);
    }

    private void getBallCount(List<String> dealerNumbers, List<String> playerInputNumbers) {
        for (int index = 0; index < dealerNumbers.size(); index++) {
            checkStrike(dealerNumbers, playerInputNumbers, index);
        }
        for (int index = 0; index < dealerNumbers.size(); index++) {
            checkBall(dealerNumbers, playerInputNumbers, index);
        }
    }

    private void checkStrike(List<String> dealerNumbers, List<String> playerInputNumbers, int strikeIndex) {
        if (dealerNumbers.get(strikeIndex).equals(playerInputNumbers.get(strikeIndex))) {
            ballCount.addStrikeCount(strikeIndex);
        }
    }

    private void checkBall(List<String> dealerNumbers, List<String> playerInputNumbers, int index) {
        if (ballCount.isStrikeLocation(index)) {
            return;
        }
        if (dealerNumbers.contains(playerInputNumbers.get(index)) && !ballCount.isStrikeLocation(index)) {
            ballCount.addBallCount();
        }
    }

    public boolean isFinish() {
        return ballCount.isThreeStrike();
    }

    public BallCount getBallCount() {
        return ballCount;
    }

}
