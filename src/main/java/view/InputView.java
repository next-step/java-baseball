package view;

import utils.Validator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_BASEBALL_THREE_NUMBER_MESSAGE = "숫자를 입력해 주세요 :";

    private InputView() {}

    public static int getUserBaseBallInput(){
        System.out.println(INPUT_BASEBALL_THREE_NUMBER_MESSAGE);
        return toInt(scanner.nextLine());
    }

    private static int toInt(String input){
        Validator.stringToIntegerValidation(input);
        return Integer.parseInt(input);
    }
}
