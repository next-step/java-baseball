package ui;

import domain.BaseballResult;

public class UserOutput {
    private static final String FOUR_BALL_RESULT = "포볼입니다.(맞춘 공이 없습니다.)";
    private static final String BALL_FOOTER = " 볼";
    private static final String STRIKE_FOOTER = " 스트라이크";
    private static final String APPENDER = " / ";

    public static String parseResult(BaseballResult baseballResult) {
        if (baseballResult.isFourBall()) {
            return FOUR_BALL_RESULT;
        }
        if (baseballResult.getBallCount() == 0) {
            return baseballResult.getStrikeCount() + STRIKE_FOOTER;
        }
        if (baseballResult.getStrikeCount() == 0) {
            return baseballResult.getBallCount() + BALL_FOOTER;
        }
        return baseballResult.getBallCount() + BALL_FOOTER + APPENDER + baseballResult.getStrikeCount() + STRIKE_FOOTER;
    }
}
