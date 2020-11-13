package baseball.view;

import java.util.Scanner;

public class InputView {
    public static final String ANOTHER_GAME_COMMAND = "1";
    public static final String STOP_COMMAND = "2";
    private static final String ENTER_NUMBERS_MESSAGE = "숫자를 입력 해 주세요:";
    private static final String DO_ANOTHER_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInputNumbers() {
        System.out.println("\n" + ENTER_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }

    public static String getDoAnotherGameCommand() {
        System.out.println("\n" + DO_ANOTHER_GAME_MESSAGE);
        return scanner.nextLine();
    }

    public static boolean isStopCommand(String command) {
        return STOP_COMMAND.equals(command);
    }

    public static boolean isAnotherGameCommand(String command) {
        return ANOTHER_GAME_COMMAND.equals(command);
    }
}
