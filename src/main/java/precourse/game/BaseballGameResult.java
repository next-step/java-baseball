package precourse.game;

import static precourse.constant.BaseballSpecification.*;

import java.util.StringJoiner;

import precourse.baseball.Baseballs;

public class BaseballGameResult {

    private static final String CORRECT_ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_IN_KOREAN = "낫싱";
    private static final String STRIKE_IN_KOREAN = "스트라이크";
    private static final String BALL_IN_KOREAN = "볼";
    private static final String DELIMITER = " ";
    private static final int ZERO = 0;
    private final int strike;
    private final int ball;

    public BaseballGameResult(Baseballs computerBaseballs, Baseballs userBaseballs) {
        strike = computerBaseballs.countStrike(userBaseballs);
        ball = computerBaseballs.countBall(userBaseballs);
    }

    public boolean isWrongAnswer() {
        return !isCorrect();
    }

    public String getResult() {
        if (isCorrect()) {
            return CORRECT_ANSWER;
        }

        if (isNothing()) {
            return NOTHING_IN_KOREAN;
        }

        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        addBallCount(stringJoiner);
        addStrikeCount(stringJoiner);

        return stringJoiner.toString();
    }

    private void addStrikeCount(StringJoiner stringJoiner) {
        if (hasStrike()) {
            stringJoiner.add(strike + STRIKE_IN_KOREAN);
        }
    }

    private void addBallCount(StringJoiner stringJoiner) {
        if (hasBall()) {
            stringJoiner.add(ball + BALL_IN_KOREAN);
        }
    }

    private boolean hasBall() {
        return ball > ZERO;
    }

    private boolean hasStrike() {
        return strike > ZERO;
    }

    private boolean isNothing() {
        return strike == ZERO && ball == ZERO;
    }

    private boolean isCorrect() {
        return strike == MAX_BASEBALLS.getValue();
    }

}
