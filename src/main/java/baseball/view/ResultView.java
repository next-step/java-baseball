package baseball.view;

import baseball.domain.BallCount;

public class ResultView {

    public static final String THREE_STRIKE_ALL_CLEAR = "3개의 숫자를 모두 맞히셨습니다. 게임종료.";
    public static final String NOTHING = "NOTHING.";
    public static final String STRIKE = "STRIKE.\t";
    public static final String BALL = "BALL";

    public static void printBallCount(BallCount ballCount) {
        if (ballCount.isThreeStrike()) {
            System.out.println(THREE_STRIKE_ALL_CLEAR);
            return;
        }
        if (ballCount.isNothing()) {
            System.out.println(NOTHING);
            return;
        }
        if (ballCount.getStrikeCount() > 0) {
            System.out.print(ballCount.getStrikeCount() + STRIKE);
        }
        if (ballCount.getBallCount() > 0) {
            System.out.println(ballCount.getBallCount() == 0 ? "" : ballCount.getStrikeCount() + BALL);
        }
    }
}
