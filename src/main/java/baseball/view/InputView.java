package baseball.view;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    private static final String QUESTION_PLAY_NUMBERS = "숫자를 입력해주세요 :  ";
    private static final String INPUT_NUMBERS_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static Set<Integer> setBallNumber() {
        Set<Integer> ballNumbers = setBallNumber(inputBallNumbers());
        return ballNumbers;
    }

    // open to Test
    public static Set<Integer> setBallNumber(String inputBallNumbers) {
        Set<Integer> ballNumbers = new HashSet<>();
        String[] splitedStrings = inputBallNumbers.split(INPUT_NUMBERS_DELIMITER);
        for (String numberString : splitedStrings) {
            ballNumbers.add(Integer.valueOf(numberString));
        }
        return ballNumbers;
    }

    private static String inputBallNumbers() {
        System.out.print(QUESTION_PLAY_NUMBERS);
        String result = scanner.next();
        return result;
    }

}
