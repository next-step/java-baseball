package ui;

import java.util.Scanner;

public class InputView {
    private static final String NOTICE_INPUT = "숫자를 입력해주세요 : ";
    private static Scanner scanner = new Scanner(System.in);

    public static int inputNumber() {
        System.out.println(NOTICE_INPUT);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해주세요.");
        }
    }

    public static int restartOrEnd() {
        int button = 0;
        try {
            button = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해주세요.");
        }

        if (button != 1 && button != 2) {
            throw new IllegalArgumentException("새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        return button;
    }
}
