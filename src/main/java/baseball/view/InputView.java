package baseball.view;

import java.util.*;

public class InputView {

    private static final String QUESTION_PLAY_NUMBERS = "숫자를 입력해주세요 :  ";
    private static final String INPUT_NUMBERS_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> setBallNumber() {
        List<Integer> ballNumbers = setBallNumber(inputBallNumbers());
        return ballNumbers;
    }

    // open to Test
    public static List<Integer> setBallNumber(String inputBallNumbers) {
        Set<Integer> ballNumbers = new HashSet<>();
        String[] splitedStrings = inputBallNumbers.split(INPUT_NUMBERS_DELIMITER);
        for (String numberString : splitedStrings) {
            ballNumbers.add(Integer.valueOf(numberString));
        }
        return new ArrayList<>(ballNumbers);
    }

    private static String inputBallNumbers() {
        System.out.print(QUESTION_PLAY_NUMBERS);
        String result = scanner.next();
        return result;
    }

}
