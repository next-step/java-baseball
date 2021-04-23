package baseball;

import java.util.Scanner;

public class UserInterface {
    public static Scanner scanner = new Scanner(System.in);

    public static String printGuideAndScanUserInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.next();
    }

    public static void printInvalidInput(String input) {
        System.out.printf("'%s'는 3자리 숫자가 아닙니다", input);
    }

    public static void printUserNumber(Number number) {
        System.out.printf("'%s' 입력했습니다", number.getNumber());
    }
}
