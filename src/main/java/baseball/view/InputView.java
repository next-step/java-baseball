package baseball.view;

import java.util.*;
import java.util.regex.Pattern;

public class InputView {

    private static final String QUESTION_PLAY_NUMBERS = "숫자를 입력해주세요 :  ";
    private static final String QUESTION_PLAY_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 :  ";
    private static final String INPUT_NUMBERS_DELIMITER = ",";
    private static final String INPUT_NUMBERS_BRACES = "{}()[]<>";
    private static final Pattern patternNumbersOnly = Pattern.compile("(^[0-9]*$)\"");
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> setBallNumber() {
        List<Integer> ballNumbers = setBallNumber(inputBallNumbers());
        return ballNumbers;
    }

    // open to Test
    public static List<Integer> setBallNumber(String inputBallNumbers) {
        Set<Integer> ballNumbers = new HashSet<>();
        List<String> splitedStrings = splitInput(inputBallNumbers);
        for (String numberString : splitedStrings) {
            ballNumbers.add(Integer.valueOf(numberString));
        }
        return new ArrayList<>(ballNumbers);
    }

    private static List<String> splitInput(String inputBallNumbers) {
        List<String> splitedStrings = new ArrayList<>();
        char[] splitedChars = inputBallNumbers.toCharArray();
        for (char splitedChar : splitedChars) {
            boolean isNumber = isNumberCheck(splitedChar);
            boolean isExtraInput = checkExtraInput(splitedChar, isNumber);
            if (!isExtraInput && isNumber) {
                splitedStrings.add(String.valueOf(splitedChar));
            }
        }
        return splitedStrings;
    }

    private static boolean checkExtraInput(char splitedChar, boolean isNumber) {
        String inputString = String.valueOf(splitedChar);
        if (!isNumber && !INPUT_NUMBERS_BRACES.contains(inputString) && !INPUT_NUMBERS_DELIMITER.contains(inputString)) {
            throw new IllegalArgumentException("숫자만 입력 가능");
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

    private static String inputBallNumbers() {
        System.out.print(QUESTION_PLAY_NUMBERS);
        String result = scanner.next();
        return result;
    }

    public static boolean restart() {
        System.out.println(QUESTION_PLAY_AGAIN);
        String result = scanner.next();
        if (result.equals("1")) return true;
        if (result.equals("2")) return false;
        //todo:: 1 재시작 ,2 종료 키 아닌 경우, 우선은 종료처리.
        return false;
    }

}
