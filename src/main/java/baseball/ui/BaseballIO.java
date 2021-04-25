package baseball.ui;

import java.util.Scanner;

import static baseball.ui.message.IOMessage.REQUIRE_NUMBER_MESSAGE;

public class BaseballIO {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readInput() {
        printMessage(REQUIRE_NUMBER_MESSAGE.getMessage());
        return scanner.next();
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }
}
