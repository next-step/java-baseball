package baseball.view;

import java.util.Scanner;

public class InputView {

    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private static void showUserInputMessage() {
        System.out.print(USER_INPUT_MESSAGE);
    }

    public static String inputNumber() {
        Scanner scanner = new Scanner(System.in);
        showUserInputMessage();
        return scanner.nextLine();
    }

}
