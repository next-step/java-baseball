package baseball.view;

import java.util.Scanner;

public class InputView {

    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String COMPLETION_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료\n" +
            "게임을 새로 시작하려면 1, 종료 하려면 2를 입력하세요.";

    private static void showUserInputMessage() {
        System.out.print(USER_INPUT_MESSAGE);
    }

    public static String inputNumber() {
        Scanner scanner = new Scanner(System.in);
        showUserInputMessage();
        return scanner.nextLine();
    }

    public static String inputContinue() {
        System.out.println(COMPLETION_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
