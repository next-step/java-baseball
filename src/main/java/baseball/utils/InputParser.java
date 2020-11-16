package baseball.utils;

public class InputParser {
    private static final int ANSWER_LENGTH = 3;

    public static int[] parse(String inputStr) {

        if(inputStr.length() != ANSWER_LENGTH)
            throw new IllegalArgumentException();

        int [] inputNums = new int[ANSWER_LENGTH];
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            inputNums[i] = Integer.parseInt(String.valueOf(inputStr.charAt(i)));
        }

        return inputNums;
    }
}
