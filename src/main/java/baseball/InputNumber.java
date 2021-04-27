package baseball;

import exception.NotContinuedException;
import exception.NumberOnlyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputNumber {
    private static final String PLAY_START = "숫자를 입력해주세요 :  ";
    private static final String PATTERN_FILTER = "{}()[]<>,";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> setBallNumber(String inputBallNumbers) {
        List<Integer> ballNumbers = new ArrayList<>();
        List<String> splitedStrings = checkInput(inputBallNumbers);
        for (String numberString : splitedStrings) {
            ballNumbers.add(Integer.valueOf(numberString));
        }
        return ballNumbers;
    }

    private static List<String> checkInput(String inputBallNumbers) throws NotContinuedException, NumberOnlyException {

        List<String> splitedStrings = new ArrayList<>();
        char[] splitedChars = inputBallNumbers.toCharArray();
        for (char splitedChar : splitedChars) {
            boolean isNumber = isNumberCheck(splitedChar);
            boolean isExtraInput = isPatternCheck(splitedChar, isNumber);
            if (!isExtraInput && isNumber) {
                splitedStrings.add(String.valueOf(splitedChar));
            }
        }
        isthreeNumberCheck(splitedStrings);
        return splitedStrings;
    }

    private static boolean isPatternCheck(char splitedChar, boolean isNumber) {
        String inputString = String.valueOf(splitedChar);
        if (!isNumber && !PATTERN_FILTER.contains(inputString)) {
            throw new NumberOnlyException();
        }
        return false;
    }

    private static boolean isNumberCheck(char splitedChar) {
        try {
            Integer.valueOf(String.valueOf(splitedChar));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static void isthreeNumberCheck(List<String> splitedStrings) {

        if (splitedStrings.subList(1,2).contains(splitedStrings.get(0))){
            throw new NotContinuedException();
        }
    }

    public static String inputBallNumbers() {
        System.out.println(PLAY_START);
        String result = scanner.next();
        return result;
    }
}
