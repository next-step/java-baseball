package view;

import java.util.Scanner;

public class InputView {
    private static final int RESTART_GAME = 1;
    private static final int END_GAME = 2;
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 " + RESTART_GAME + ", 종료하려면 " + END_GAME + "를 입력하세요";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        return SCANNER.next();
    }

    public static boolean restart() {
        System.out.println(INPUT_RESTART_MESSAGE);
        return RESTART_GAME == SCANNER.nextInt();
    }
}
