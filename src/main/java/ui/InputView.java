package ui;

import java.util.*;

public class InputView {
    private static final String NOTICE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String EXCEPTION_INTEGER_PARSE = "숫자로 입력해주세요.";
    private static final String NUMBER_SPLIT_TEXT = "";

    private static final Scanner scanner = new Scanner(System.in);

    public static Map<Integer, Integer> inputNumber() {
        System.out.println(NOTICE_INPUT_NUMBER);

        try {
            int number = Integer.parseInt(scanner.nextLine());
            return convertToNumbers(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(EXCEPTION_INTEGER_PARSE);
        }
    }

    public static int restartOrEnd() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(EXCEPTION_INTEGER_PARSE);
        }
    }

    private static Map<Integer, Integer> convertToNumbers(final int number) {
        Map<Integer, Integer> numbers = new LinkedHashMap<>();

        String[] splitNumbers = String.valueOf(number).split(NUMBER_SPLIT_TEXT);
        for (int index = 0; index < splitNumbers.length; index++) {
            numbers.put(Integer.parseInt(splitNumbers[index]), index);
        }

        return numbers;
    }
}
