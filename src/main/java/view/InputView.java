package view;

import utils.Validator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_BASEBALL_THREE_NUMBER_MESSAGE = "숫자를 입력해 주세요 :";
    private static final String INPUT_RE_START_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static final String YES = "1";
    private static final String NO = "2";
    private InputView() {}

    public static int getUserBaseBallInput() {
        System.out.println(INPUT_BASEBALL_THREE_NUMBER_MESSAGE);
        return toInt(scanner.nextLine());
    }

    public static boolean getReStartInput() {
        System.out.println(INPUT_RE_START_MESSAGE);
        return toBoolean(scanner.nextLine());
    }

    private static int toInt(String input) {
        Validator.stringToIntegerValidation(input);
        return Integer.parseInt(input);
    }

    private static boolean toBoolean(String input){
        return input.equals(YES);
    }
}
