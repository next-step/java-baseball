package baseball.view;

import baseball.domain.ResultType;

import java.text.MessageFormat;
import java.util.Map;

public class OutputView {

    private static final String SPACE = " ";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE_FORMAT = "{0}스트라이크";
    private static final String BALL_MESSAGE_FORMAT = "{0}볼";

    public static void print(Map<ResultType, Integer> result) {
        if (result.isEmpty()) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        printDetail(result);
    }

    private static void printDetail(Map<ResultType, Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        int countOfStrike = result.getOrDefault(ResultType.STRIKE, 0);
        if (countOfStrike > 0) {
            stringBuilder.append(MessageFormat.format(STRIKE_MESSAGE_FORMAT, countOfStrike));
        }
        stringBuilder.append(SPACE);
        int countOfBall = result.getOrDefault(ResultType.BALL, 0);
        if (countOfBall > 0) {
            stringBuilder.append(MessageFormat.format(BALL_MESSAGE_FORMAT, countOfBall));
        }
        System.out.println(stringBuilder.toString());
    }

}
