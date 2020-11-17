package me.lozm.baseball.common;

import java.util.Scanner;

public class CommonUtils {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;
    public static final int ANSWER_SIZE = 3;
    public static final int CORRECT_ANSWER_SIZE = 3;

    public static final boolean CANDIDATE_IS_USED = true;
    public static final boolean CANDIDATE_IS_NOT_USED = false;

    public static final String RESTART_YES = "1";
    public static final String RESTART_NO = "2";

    public static final String REG_EXP_ANSWER = "([1-9]{"+ANSWER_SIZE+"})";
    public static final String REG_EXP_RESTART = "([1-2]{1})";

    public static final String INPUT_MESSAGE_ANSWER = "" + ANSWER_SIZE + "자리 숫자를 입력해주세요: ";
    public static final String INPUT_MESSAGE_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ";

    private static Scanner scanner = new Scanner(System.in);

    public static String input(String printMessage, String inputRegExp) {
        String input = null;
        boolean isNotComplete = true;
        while (isNotComplete) {
            System.out.println(printMessage);
            input = scanner.next();
            isNotComplete = input.matches(inputRegExp) ? false : true;
        }
        return input;
    }

}