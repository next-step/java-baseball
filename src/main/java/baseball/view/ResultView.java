package baseball.view;

import baseball.domain.BallCount;

public class ResultView {

    public static final String THREE_STRIKE_ALL_CLEAR = "3개의 숫자를 모두 맞히셨습니다. 게임종료.";

    public static void printBallCount(BallCount ballCount) {
        System.out.print(ballCount.getStrikeCount() == 0 ? "" : ballCount.getStrikeCount() + " STRIKE \t");
        System.out.println(ballCount.getBallCount() == 0 ? "" : ballCount.getStrikeCount() + " BALL");
        System.out.println(ballCount.isNothing() ? "NOTHING" : "");
        System.out.println(ballCount.isThreeStrike() ? THREE_STRIKE_ALL_CLEAR : "");
    }

}
