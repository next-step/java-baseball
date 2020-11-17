package game.baseball.number.utils;

import static game.baseball.number.exceptions.ExceptionCodes.SUPPRESS_INSTANCE;

import game.baseball.number.exceptions.InvalidRestartOrExitInputException;
import java.util.Scanner;

public final class ConsoleInputUtil {

    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleInputUtil() {
        throw new AssertionError(SUPPRESS_INSTANCE);
    }

    public static String input(HelperTexts helperTexts) {
        ConsoleOutputUtil.print(helperTexts);
        try {
            return SCANNER.nextLine();
        } catch (RuntimeException e) {
            throw new InvalidRestartOrExitInputException(e);
        }
    }
}
