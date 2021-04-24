package baseball.ui;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_INPUT_NUMBERS = "숫자를 입력해주세요. : ";
    private static final String MESSAGE_INPUT_REPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputPitchNumbers() {
        System.out.print(MESSAGE_INPUT_NUMBERS);
        return scanner.nextLine();
    }

    public static int inputReplay() {
        System.out.println(MESSAGE_INPUT_REPLAY);
        return Integer.parseInt(scanner.nextLine());
    }
}
