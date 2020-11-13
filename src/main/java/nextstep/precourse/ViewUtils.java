package nextstep.precourse;

import java.util.Scanner;

public class ViewUtils {
    private static final String INPUT_NULL_EMPTY_EXCEPTION = "내용을 입력해주세요.";
    private static final String NUMBER_FORMAT_EXCEPTION = "입력된 내용이 숫자가 아닙니다.";
    private static Scanner scanner = new Scanner(System.in);

    public static void print(String line) {
        System.out.print(line);
    }

    public static void printLine(String line) {
        System.out.println(line);
    }

    public static String readLine() {
        String input = scanner.nextLine();

        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NULL_EMPTY_EXCEPTION);
        }

        return input;
    }

    public static int readLineToInt() {
        try {
            return Integer.parseInt(readLine());
        } catch(NumberFormatException e) {
            throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION);
        }
    }
}
