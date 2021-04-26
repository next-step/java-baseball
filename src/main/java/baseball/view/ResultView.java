package baseball.view;

import baseball.domain.Computer;

public class ResultView {
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE = "%s스트라이크 ";
    private static final String BALL_MESSAGE = "%s볼";
    private static final String BLANK_MESSAGE = "";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printScore(Computer computer) {
        System.out.println(makeScoreMessage(computer));
    }

    public void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    private String makeScoreMessage(Computer computer) {
        if (computer.isNothing()) {
            return NOTHING_MESSAGE;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(strikeToString(computer.getStrike()));
        builder.append(ballToString(computer.getBall()));
        return builder.toString();
    }

    private String strikeToString(int strike) {
        return strike != 0 ? String.format(STRIKE_MESSAGE, strike) : BLANK_MESSAGE;
    }

    private String ballToString(int ball) {
        return ball != 0 ? String.format(BALL_MESSAGE, ball) : BLANK_MESSAGE;
    }
}
