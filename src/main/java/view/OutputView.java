package view;

import domain.hint.Ball;
import domain.result.BaseBallResult;
import domain.hint.Strike;

public class OutputView {

    private static final String STRIKE_BALL_RESULT = "%d 스트라이크 %d 볼";
    private static final String STRIKE_RESULT = "%d 스트라이크";
    private static final String BALL_RESULT = "%d 볼";
    private static final String ALL_MATCH_BALLS_MESSAGE = "3개의 숫자를 모두 맞혔습니다! [게임종료]";

    private OutputView() {
    }

    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public static void printBaseBallResult(BaseBallResult baseBallResult) {
        Strike strike = baseBallResult.getStrike();
        Ball ball = baseBallResult.getBall();
        if (strike.isExistMatching() && ball.isExistMatching()) {
            System.out.println(String.format(STRIKE_BALL_RESULT, strike.getStrikeCount(), ball.getBallCount()));
            return;
        }
        printOneResult(strike, ball);
    }

    private static void printOneResult(Strike strike, Ball ball) {
        if (strike.isExistMatching()) {
            System.out.println(String.format(STRIKE_RESULT, strike.getStrikeCount()));
            return;
        }
        System.out.println(String.format(BALL_RESULT, ball.getBallCount()));
    }

    public static void printAllMatchBallsMessage() {
        System.out.println(ALL_MATCH_BALLS_MESSAGE);
    }

}
