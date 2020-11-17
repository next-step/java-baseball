package view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPlayerBallNumber() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        return inputWithNumberValidation();
    }

    public static int inputRestartOrExitNumber() {
        System.out.println(RESTART_OR_EXIT_MESSAGE);
        return inputWithNumberValidation();
    }

    private static int inputWithNumberValidation() {
        try {
            String trimmedInput = SCANNER.nextLine().trim();
            return Integer.parseInt(trimmedInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }
    }

}
