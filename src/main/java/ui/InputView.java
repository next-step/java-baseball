package ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputString() {
        System.out.println("값을 입력해주세요 : ");
        return scanner.next();
    }
}
