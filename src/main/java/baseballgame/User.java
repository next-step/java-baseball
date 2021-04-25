package baseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
    private final List<Integer> selectNumbers = new ArrayList<>();

    public List<Integer> getSelectNumbers() {
        return selectNumbers;
    }

    public void selectNumber() {
        printStartMessage();
        selectNumbers.clear();
        String[] inputs = inputNumber();
        checkInputNumberCount(inputs);
        for (int i = 0; i < Const.NUMBER_COUNT; i++) {
            checkInputNumberType(inputs[i]);
            checkDuplicateNumber(parseNumber(inputs[i]));
            selectNumbers.add(parseNumber(inputs[i]));
        }
    }

    private void printStartMessage() {
        System.out.print(GameMessageEnum.INPUT_NUMBER.getMessage());
    }

    private String[] inputNumber() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().split("");
    }

    private void checkInputNumberCount(String[] inputs) {
        if (inputs.length != Const.NUMBER_COUNT) {
            throw new IllegalArgumentException(Const.NUMBER_COUNT + ErrorMessageEnum.ERROR_INVALID_LENGTH.getMessage());
        }
    }

    private void checkInputNumberType(String input) {
        if (!Pattern.matches(Const.NUMBER_REGULAR_EXPRESSION, input)) {
            throw new IllegalArgumentException(ErrorMessageEnum.ERROR_INVALID_NUMBER.getMessage());
        }
    }

    private void checkDuplicateNumber(int input) {
        if (selectNumbers.contains(input)) {
            throw new IllegalArgumentException(ErrorMessageEnum.ERROR_DUPLICATE_NUMBER.getMessage());
        }
    }

    private int parseNumber(String number) {
        return Integer.parseInt(number);
    }
}