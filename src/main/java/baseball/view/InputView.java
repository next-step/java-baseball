package baseball.view;

import java.util.*;

public class InputView {

    private static final String QUESTION_PLAY_NUMBERS = "숫자를 입력해주세요 :  ";
    private static final String QUESTION_PLAY_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 :  ";
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

    public static boolean restart() {
        System.out.println(QUESTION_PLAY_AGAIN);
        String result = scanner.next();
        if(result.equals("1")) return true;
        if(result.equals("2")) return false;
        //todo:: 1 재시작 ,2 종료 키 아닌 경우, 우선은 종료처리.
        return false;
    }




}
