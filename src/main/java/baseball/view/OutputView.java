package baseball.view;

import baseball.domain.ResultType;

import java.text.MessageFormat;
import java.util.Map;

public class OutputView {

    private static final String SPACE = " ";

    public static void print(Map<ResultType, Integer> result) {
        if (result.isEmpty()) {
            System.out.println("낫싱");
            return;
        }
        printDetail(result);
    }

    private static void printDetail(Map<ResultType, Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        int countOfStrike = result.getOrDefault(ResultType.STRIKE, 0);
        if (countOfStrike > 0) {
            stringBuilder.append(MessageFormat.format("{0}스트라이크", countOfStrike));
        }
        stringBuilder.append(SPACE);
        int countOfBall = result.getOrDefault(ResultType.BALL, 0);
        if (countOfBall > 0) {
            stringBuilder.append(MessageFormat.format("{0}볼", countOfBall));
        }
        System.out.println(stringBuilder.toString());
    }

}
