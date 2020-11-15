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
    }

    private void getBallCount(List<Integer> dealerNumbers, List<Integer> playerInputNumbers) {
        for (int i = 0; i < dealerNumbers.size(); i++) {
            //todo:: indent 줄이기
            if (dealerNumbers.contains(playerInputNumbers.get(i)) && !isStrike(dealerNumbers.get(i), playerInputNumbers.get(i))) {
                ballCount.addBallCount();
            }
        }
    }

    private boolean isStrike(Integer dealerNumber, Integer playerInputNumber) {
        boolean resultStrike = dealerNumber == playerInputNumber;
        if (resultStrike) ballCount.addStrikeCount();
        return resultStrike;
    }

    public BallCount getBallCount() {
        return ballCount;
    }

}
