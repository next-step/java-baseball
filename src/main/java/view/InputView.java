package view;

import java.util.Scanner;

public class InputView {
    private static final int RESTART = 1;
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        return SCANNER.next();
    }

    public static boolean restart() {
        System.out.println(INPUT_RESTART_MESSAGE);
        return RESTART == SCANNER.nextInt();
    }
}
