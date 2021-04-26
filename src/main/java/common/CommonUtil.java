package common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonUtil {
    public static String scannerNextMessageAndPattern(String message, String pattern) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        try {
            return scanner.next(pattern);
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            scanner.nextLine();
            scannerNextMessageAndPattern(message, pattern);
        }
        return null;
    }
}
