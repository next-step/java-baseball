package numberBaseball.view;

import java.util.Scanner;

public class ConsoleInput {
    public static final String MESSAGE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String MESSAGE_REPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public static String inputGameNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(MESSAGE_INPUT_NUMBER);
        return scanner.next();
    }

    public static String inputReplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MESSAGE_REPLAY);
        return scanner.nextLine();
    }
}
