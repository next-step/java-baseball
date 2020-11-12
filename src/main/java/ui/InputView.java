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
}
