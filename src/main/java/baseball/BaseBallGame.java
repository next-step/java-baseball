package baseball;

import baseball.domain.BallCount;

import java.util.List;

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
        //todo:: input error Check

    }

    public void play(BallNumber playerInputNumber) {
        ballCount = new BallCount();
        List<String> dealerNumbers = dealerNumber.getBallNumber();
        List<String> playerInputNumbers = playerInputNumber.getBallNumber();
        getBallCount(dealerNumbers, playerInputNumbers);
        // test log
        System.out.println(dealerNumbers);
    }

    private void getBallCount(List<String> dealerNumbers, List<String> playerInputNumbers) {
        for (int index = 0; index < dealerNumbers.size(); index++) {
            checkStrike(dealerNumbers, playerInputNumbers, index);
            checkBall(dealerNumbers, playerInputNumbers, index);
        }
    }

    private void checkBall(List<String> dealerNumbers, List<String> playerInputNumbers, int index) {
        if (dealerNumbers.contains(playerInputNumbers.get(index)) && !ballCount.isStrikeLocation(index)) {
            ballCount.addBallCount();
        }
    }

    private void checkStrike(List<String> dealerNumbers, List<String> playerInputNumbers, int strikeIndex) {
        if (dealerNumbers.get(strikeIndex).equals(playerInputNumbers.get(strikeIndex))) {
            ballCount.addStrikeCount(strikeIndex);
        }
    }

    public boolean isFinish() {
        return ballCount.isThreeStrike();
    }

    public BallCount getBallCount() {
        return ballCount;
    }

}
