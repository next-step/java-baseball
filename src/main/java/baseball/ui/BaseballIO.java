package baseball.ui;

import java.util.Scanner;

import static baseball.ui.message.IOMessage.*;

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

    public static void printResult(int strike, int ball) {
        StringBuilder message = new StringBuilder();
        if (strike > 0) {
            message.append(strike + STRIKE.getMessage());
        }
        if (ball > 0) {
            message.append(ball + BALL.getMessage());
        }
        if (strike + ball == 0) {
            message.append(NOTHING.getMessage());
        }
        printlnMessage(message.toString());
    }
}
