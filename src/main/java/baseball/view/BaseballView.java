package baseball.view;

import baseball.constants.MessageType;

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
}
