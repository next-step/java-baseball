package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        System.out.print("숫자를 입력해주세요 : ");
        int number = scanner.nextInt();
        return number;
    }
}
