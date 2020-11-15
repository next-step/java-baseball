package baseball.view;

import baseball.domain.BallCount;

public class ResultView {

    public static void printBallCount(BallCount ballCount) {
        System.out.print(ballCount.getStrikeCount() == 0 ? "" : ballCount.getStrikeCount() + " STRIKE \t");
        System.out.println(ballCount.getBallCount() == 0 ? "" : ballCount.getStrikeCount() + " BALL");
        System.out.println(ballCount.isNothing() ? "NOTHING" : "");
    }

}
