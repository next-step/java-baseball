package baseball.utils;

import baseball.exceptions.QuitException;

public class InputParser {
    private static final int ANSWER_LENGTH = 3;

    public static Integer[] parse(String inputStr) {
        if(inputStr.equals("q"))
            throw new QuitException();

        if(inputStr.length() != ANSWER_LENGTH)
            throw new IllegalArgumentException();

        Integer [] inputNumbers = new Integer[ANSWER_LENGTH];
        for (int i = 0; i < ANSWER_LENGTH; i++)
            inputNumbers[i] = Integer.parseInt(String.valueOf(inputStr.charAt(i)));

        return inputNumbers;
    }
}
