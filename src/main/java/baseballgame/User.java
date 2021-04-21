package baseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
    final int numberCount = 3;
    final String numberRegExpression = "(^[0-9]*$)";
    List<Integer> selectNumbers = new ArrayList<>();

    public void selectNumber() {
        String[] inputs = inputNumber();
        checkInputNumberCount(inputs);
        for (int i = 0; i < numberCount; i++) {
            checkInputNumberType(inputs[i]);
            checkDuplicateNumber(parseNumber(inputs[i]));
            selectNumbers.add(parseNumber(inputs[i]));
        }
    }

    private String[] inputNumber() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().split("");
    }

    private void checkInputNumberCount(String[] inputs) {
        if (inputs.length != numberCount) {
            throw new IllegalArgumentException(numberCount + "개의 숫자를 입력하세요.");
        }
    }

    private void checkInputNumberType(String input) {
        if (!Pattern.matches(input, numberRegExpression)) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private void checkDuplicateNumber(int input) {
        if (selectNumbers.contains(input)) {
            throw new IllegalArgumentException("중복되는 숫자는 넣을 수 없습니다.");
        }
    }

    private int parseNumber(String number) {
        return Integer.parseInt(number);
    }
}
