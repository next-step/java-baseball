package util;

import java.util.ArrayList;
import java.util.List;

public class TransStringNumberToNumberListUtil {

    private static final String EXCEPTION_MESSAGE_INVALID_NUMBER_CHAR = "입력값은 정수여야만 합니다.";

    private TransStringNumberToNumberListUtil() {
    }

    public static List<Integer> toNumberList(String numberString) {
        List<Integer> numbers = new ArrayList<>();
        char[] numberChars = numberString.toCharArray();
        for (char numberChar : numberChars) {
            numbers.add(parseNumber(numberChar));
        }

        return numbers;
    }

    private static int parseNumber(char numberChar) {
        int number;
        try {
            number = Integer.parseInt(String.valueOf(numberChar));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_INVALID_NUMBER_CHAR);
        }
        return number;
    }
}
