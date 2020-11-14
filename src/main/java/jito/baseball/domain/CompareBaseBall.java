package jito.baseball.domain;

import jito.baseball.util.UserInterfaceUtils;

public class CompareBaseBall {

    private static int strike = 0;
    private static int ball = 0;

    public CompareBaseBall() {}

    public String getGameResult(int[] computerNumbers, int[] playerNumbers) {
        countBaseBall(computerNumbers, playerNumbers);
        return getCompareResult();
    }

    public boolean stopGame() {
        boolean flag = false;
        if (strike == 3) {
            UserInterfaceUtils.successMessage();
            UserInterfaceUtils.restartMessage();
            flag = true;
        }
        resetBallCount();
        return flag;
    }

    private void countBaseBall(int[] computerNumbers, int[] playerNumbers) {
        for (int i = 0; i < 3; i++) {
            countStrike(computerNumbers[i], playerNumbers[i]);
            countBall(computerNumbers, playerNumbers[i], i);
        }
    }

    private void countBall(int[] computerNumbers, int playerNumber, int index) {
        for (int i=0; i < computerNumbers.length; i++) {
            if (i == index) continue;
            if (computerNumbers[i] == playerNumber) {
                ball++;
            }
        }
    }

    private void countStrike(int computerNumber, int playerNumber) {
        if (computerNumber == playerNumber) {
            strike++;
        }
    }

    private String getCompareResult() {
        StringBuilder sb = new StringBuilder();
        if (strike == 0 && ball == 0)
            sb.append(BaseBallStatus.NOTHING.getMessage());
        if (strike > 0)
            sb.append(strike).append(" ").append(BaseBallStatus.STRIKE.getMessage());
        if (ball > 0)
            sb.append(ball).append(" ").append(BaseBallStatus.BALL.getMessage());
        return sb.toString();
    }

    private void resetBallCount() {
        strike = 0;
        ball = 0;
    }
}
