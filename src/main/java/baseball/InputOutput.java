package baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputOutput {
    private static Scanner scan = new Scanner(System.in);
    private static Message message = new Message();

    private static final String pattern = "^[0-9]*$";

    public InputOutput() {}


    public static String input() {
        String input = scan.nextLine();

        return input;
    }

    public static int inputNumber() {
        String input = input();

        while (!checkInputNumber(input)) {
            println(message.INPUT_NUMBER_INVALID_VALUE);
            print(message.INPUT_NUMBER);
            input = input();
        }
        int inputNumber = parseInt(input);

        return inputNumber;
    }

    public static boolean checkInputNumber(String input) {
        if (!Pattern.matches(pattern, input) || input.equals("")) {
            return false;
        }

        if (parseInt(input.trim()) == 9) {
            return true;
        }

        if (input.length() != 3) {
            return false;
        }

        return true;
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static void println(String str) {
        System.out.println(str);
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
