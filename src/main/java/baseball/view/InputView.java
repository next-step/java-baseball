package baseball.view;

import java.util.Scanner;

public class InputView {
    private static final String NUMBER_REQUEST = "숫자를 입력해주세요: ";
    private static final String COMMAND_REQUEST = "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int input() {
        System.out.print(NUMBER_REQUEST);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int command() {
        System.out.println(COMMAND_REQUEST);
        return Integer.parseInt(scanner.nextLine());
    }
}
