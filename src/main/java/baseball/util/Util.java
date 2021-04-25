package baseball.util;

import java.util.Scanner;

public class Util {

    /**
     * 입력
     *
     * @param text
     * @return
     */
    public static String input(String text) {
        System.out.println(text);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        return input;
    }

}
