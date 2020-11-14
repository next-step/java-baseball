package baseball.view;

import baseball.domain.BaseballResult;

import java.text.MessageFormat;

public class OutputView {

    private static final String SPACE = " ";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE_FORMAT = "{0}스트라이크";
    private static final String BALL_MESSAGE_FORMAT = "{0}볼";

    public static void print(BaseballResult result) {
        if (result.isEmpty()) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        printDetail(result);
    }

    private static void printDetail(BaseballResult result) {
        StringBuilder stringBuilder = new StringBuilder();
        printDetailOfStrike(stringBuilder, result);
        stringBuilder.append(SPACE);
        printDetailOfBall(stringBuilder, result);
        System.out.println(stringBuilder.toString());
    }

    private static void printDetailOfStrike(StringBuilder stringBuilder, BaseballResult result) {
        int countOfStrike = result.getCountOfStrike();
        if (countOfStrike > BaseballResult.DEFAULT_COUNT) {
            stringBuilder.append(MessageFormat.format(STRIKE_MESSAGE_FORMAT, countOfStrike));
        }
    }

    private static void printDetailOfBall(StringBuilder stringBuilder, BaseballResult result) {
        int countOfBall = result.getCountOfBall();
        if (countOfBall > BaseballResult.DEFAULT_COUNT) {
            stringBuilder.append(MessageFormat.format(BALL_MESSAGE_FORMAT, countOfBall));
        }
    }

}
