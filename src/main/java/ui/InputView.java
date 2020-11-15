package ui;

import java.util.Scanner;

public class InputView {
    private static final String NOTICE_INPUT = "숫자를 입력해주세요 : ";
    private static final int GO_BUTTON = 1;
    private static final int STOP_BUTTON = 2;
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
        int button;
        try {
            button = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력해주세요.");
        }

        if (button != GO_BUTTON && button != STOP_BUTTON) {
            throw new IllegalArgumentException("새로 시작하려면 " + GO_BUTTON + ", 종료하려면 " + STOP_BUTTON + "를 입력하세요.");
        }
        return button;
    }
}
