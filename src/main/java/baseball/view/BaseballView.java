package baseball.view;

import baseball.constants.BaseballCount;
import baseball.constants.MessageType;
import baseball.domain.BaseballResult;
import baseball.exception.InvalidNumbersException;

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

    public static void showWinMessage() {
        System.out.println(MessageType.OUTPUT_WIN.getMessage());
    }

    public static int askRetryOrExit() {
        System.out.println(MessageType.CONFIRM_EXIT.getMessage());
        try {
            return validateRange(Integer.parseInt(scanner.next()));
        } catch (NumberFormatException e) {
            System.out.println(MessageType.INVALID_INPUT_FORMAT.getMessage());
            return askRetryOrExit();
        } catch (InvalidNumbersException e) {
            System.out.println(e.getMessage());
            return askRetryOrExit();
        }
    }

    private static int validateRange(int number) {
        if (number != 1 && number != 2) {
            throw new InvalidNumbersException(MessageType.INVALID_CONFIRM_EXIT);
        }
        return number;
    }
}
