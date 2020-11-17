package baseball;

import java.util.ArrayList;
import java.util.List;

public class Checker {

    public static void checkStrikeOrBall(int input, List<Integer> answer, Result result) {
        List<Integer> inputList = convertInputToList(input);
        for (int i = 0; i < Constants.ANSWER_SIZE; i++) {
            checkStrike(inputList.get(i), answer.get(i), result);
            checkBall(inputList.get(i), answer.get(i), answer, result);
        }
    }

    private static void checkStrike(int input, int answer, Result result) {
        if (input == answer) {
            result.setStrike(result.getStrike() + 1);
        }
    }

    private static void checkBall(int input, int answer, List<Integer> inputList, Result result) {
        if (input != answer && inputList.contains(input)) {
            result.setBall(result.getBall() + 1);
        }
    }

    private static List<Integer> convertInputToList(int input) {
        List<Integer> inputList = new ArrayList<>();
        int num = 100;
        for (int i = 0; i < Constants.ANSWER_SIZE; i++) {
            inputList.add(input / num);
            input -= inputList.get(i) * num;
            num /= 10;
        }
        return inputList;
    }
}
