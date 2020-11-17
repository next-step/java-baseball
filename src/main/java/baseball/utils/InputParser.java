package baseball.utils;

import baseball.exceptions.QuitException;

public class InputParser {
    private static final int ANSWER_LENGTH = 3;

    public static Integer[] parse(String inputStr) {

        if(inputStr.equals("q")) {
            String quitMessage = "야구 게임을 종료합니다.";
            throw new QuitException(quitMessage);
        }

        if(inputStr.length() != ANSWER_LENGTH)
            throw new IllegalArgumentException();

        Integer [] inputNums = new Integer[ANSWER_LENGTH];
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            inputNums[i] = Integer.parseInt(String.valueOf(inputStr.charAt(i)));
        }

        return inputNums;
    }
}
