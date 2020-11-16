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
    private static BallNumber dealerNumber;

    private BallCount ballCount;

    private BaseBallGame() {
    }

    public BaseBallGame(BallNumber dealerNumber) {
        this.dealerNumber = dealerNumber;
        //todo:: input error Check

    }

    public void play(BallNumber playerInputNumber) {
        ballCount = new BallCount();
        List<Integer> dealerNumbers = dealerNumber.getBallNumber();
        List<Integer> playerInputNumbers = playerInputNumber.getBallNumber();
        getBallCount(dealerNumbers, playerInputNumbers);
        // test log
        System.out.println(dealerNumbers);
    }

    private void getBallCount(List<Integer> dealerNumbers, List<Integer> playerInputNumbers) {
        for (int index = 0; index < dealerNumbers.size(); index++) {
            checkStrike(dealerNumbers, playerInputNumbers, index);
            checkBall(dealerNumbers, playerInputNumbers, index);
        }
    }

    private void checkBall(List<Integer> dealerNumbers, List<Integer> playerInputNumbers, int index) {
        if (dealerNumbers.contains(playerInputNumbers.get(index)) && !ballCount.isStrikeLocation(index)) {
            ballCount.addBallCount();
        }
    }

    private void checkStrike(List<Integer> dealerNumbers, List<Integer> playerInputNumbers, int strikeIndex) {
        if (dealerNumbers.get(strikeIndex).equals(playerInputNumbers.get(strikeIndex))) {
            ballCount.addStrikeCount();
            ballCount.addStrikeIndex(strikeIndex);
        }
    }

    public boolean isFinish() {
        return ballCount.isThreeStrike();
    }

    public BallCount getBallCount() {
        return ballCount;
    }

}
