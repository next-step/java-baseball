package baseball.view;

import java.util.*;

import baseball.exception.DifferentThreeNumberRequiredException;
import baseball.exception.NumberOnlyException;


public class InputView {

    private static final int MAX_BIDDING_COUNT = 3;
    private static final String QUESTION_PLAY_NUMBERS = "숫자를 입력해주세요 :  ";
    private static final String QUESTION_PLAY_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 :  ";
    private static final String INPUT_NUMBERS_DELIMITER = ",";
    private static final String INPUT_NUMBERS_BRACES = "{}()[]<>";
    private static final String INPUT_GAME_RESTART = "1";
    private static final String INPUT_GAME_END = "2";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> setBallNumber() throws DifferentThreeNumberRequiredException, NumberOnlyException {
        List<String> ballNumbers = setBallNumber(inputBallNumbers());
        return ballNumbers;
    }

    // open to Test
    public static List<String> setBallNumber(String inputBallNumbers)
            throws DifferentThreeNumberRequiredException, NumberOnlyException {
        List<String> ballNumbers = new ArrayList<>();
        Set<String> ballNumbersSet = new LinkedHashSet<>();
        ballNumbers = splitInput(inputBallNumbers);
        for (String numberString : ballNumbers) {
            ballNumbersSet.add(numberString);
        }
        if (ballNumbersSet.size() != MAX_BIDDING_COUNT && ballNumbers.size() != MAX_BIDDING_COUNT)
            throw new DifferentThreeNumberRequiredException();
        return new ArrayList<>(ballNumbersSet);
    }

    private static List<String> splitInput(String inputBallNumbers) throws NumberOnlyException {
        List<String> splitedStrings = new ArrayList<>();
        char[] splitedChars = inputBallNumbers.toCharArray();
        for (char splitedChar : splitedChars) {
            addEachInputAfterCheck(splitedStrings, splitedChar);
        }
        return splitedStrings;
    }

    private static void addEachInputAfterCheck(List<String> splitedStrings, char splitedChar) {
        boolean isNumber = isNumberCheck(splitedChar);
        boolean isExtraInput = checkExtraInput(splitedChar, isNumber);
        if (!isExtraInput && isNumber) {
            splitedStrings.add(String.valueOf(splitedChar));
        }
    }

    private static boolean checkExtraInput(char splitedChar, boolean isNumber) throws NumberOnlyException {
        String inputString = String.valueOf(splitedChar);
        if (!isNumber && !INPUT_NUMBERS_BRACES.contains(inputString)
                && !INPUT_NUMBERS_DELIMITER.contains(inputString)) {
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

    private static String inputBallNumbers() {
        System.out.print(QUESTION_PLAY_NUMBERS);
        String result = scanner.next();
        return result;
    }

    public static boolean restart() {
        System.out.println(QUESTION_PLAY_AGAIN);
        String result = scanner.next();
        if (result.equals(INPUT_GAME_RESTART)) {
            return true;
        }
        if (result.equals(INPUT_GAME_END)) {
            return false;
        }
        //todo:: 1 재시작 ,2 종료 키 아닌 경우, 우선은 종료처리.
        return false;
    }

}
