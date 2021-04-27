package numberBaseball.domain;

import numberBaseball.dto.ResultResponse;

public class MatchResult {
    public static final String MESSAGE_NOTHING = "낫싱";
    public static final String MESSAGE_BALL = " 볼";
    public static final String MESSAGE_STRIKE = " 스트라이크 ";
    public static final int NOTHING_COUNT = 0;
    public static final int CLEAR_COUNT = 3;
    private final int strikes;
    private final int balls;

    public MatchResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public ResultResponse MatchResultToResponse() {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setResult(convertResultToString());
        resultResponse.setIsClear(isClear());
        return resultResponse;
    }

    private boolean isClear() {
        return strikes == CLEAR_COUNT;
    }

    private String convertResultToString() {
        if (strikes == NOTHING_COUNT && balls == NOTHING_COUNT) {
            return MESSAGE_NOTHING;
        }
        return getStrikesString() + getBallsString();
    }

    private String getBallsString() {
        return getBalls() + MESSAGE_BALL;
    }

    private String getStrikesString() {
        return getStrikes() + MESSAGE_STRIKE;
    }
}
