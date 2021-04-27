package baseball.utils;

import java.util.Scanner;

public class PrintUtils {
    public static int requestInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }
}
