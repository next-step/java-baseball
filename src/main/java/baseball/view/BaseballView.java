package baseball.view;

import baseball.constants.BaseballCount;
import baseball.constants.MessageType;
import baseball.domain.BaseballResult;

import java.util.Scanner;

public class BaseballView {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int askNumber() {
        System.out.print(MessageType.INPUT_NUMBER.getMessage());
        try {
            return Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println(MessageType.INVALID_INPUT_FORMAT.getMessage());
            return askNumber();
        }
    }

    public static void showResult(BaseballResult baseballResult) {
        if (baseballResult.isNothing()) {
            System.out.println(BaseballCount.NOTHING.getName());
            return;
        }
        String result = new StringBuilder()
                .append(baseballResult.isExistStrike() ? String.format("%d %s ", baseballResult.getStrike(), BaseballCount.STRIKE.getName()) : "")
                .append(baseballResult.isExistBall() ? String.format("%d %s ", baseballResult.getBall(), BaseballCount.BALL.getName()) : "")
                .toString();
        System.out.println(result);
    }
}
