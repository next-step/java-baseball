package baseball.view;

import baseball.domain.Computer;

public class ResultView {
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE = "%s스트라이크 ";
    private static final String BALL_MESSAGE = "%s볼";
    private static final String EMPTY_MESSAGE = "";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int ZERO_SCORE = 0;

    public void printScore(Computer computer) {
        System.out.println(makeScoreMessage(computer));
    }

    public void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    private String makeScoreMessage(final Computer computer) {
        if (computer.isNothing()) {
            return NOTHING_MESSAGE;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(strikeToString(computer.getStrike()));
        builder.append(ballToString(computer.getBall()));
        return builder.toString();
    }

    private String strikeToString(final int strike) {
        return isZeroScore(strike) ? EMPTY_MESSAGE : String.format(STRIKE_MESSAGE, strike);
    }

    private String ballToString(final int ball) {
        return isZeroScore(ball) ? EMPTY_MESSAGE : String.format(BALL_MESSAGE, ball);
    }

    private boolean isZeroScore(final int score) {
        return score == ZERO_SCORE;
    }
}
