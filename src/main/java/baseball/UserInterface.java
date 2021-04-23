package baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInterface {
    private static final Pattern VALID_INPUT_PATTERN = Pattern.compile("[0-9]{3}");
    private static final Scanner scanner = new Scanner(System.in);

    public static String printGuideAndScanUserInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        String userInput = scanner.next();

        if (!VALID_INPUT_PATTERN.matcher(userInput).matches()) {
            return printGuideAndScanUserInput();
        }

        return userInput;
    }

    public static void printStrike(int count) {
        System.out.printf("%d 스트라이크 ", count);
    }

    public static void printGameComplete() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }
}
