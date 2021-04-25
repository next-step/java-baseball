package numberBaseball.view;

import java.util.Scanner;

public class ConsoleInput {
    public static final String MESSAGE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static Scanner scanner = new Scanner(System.in);

    public static String inputGameNumber() {
        System.out.print(MESSAGE_INPUT_NUMBER);
        return scanner.next();
    }
}
