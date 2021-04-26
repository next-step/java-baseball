package baseball;

import baseball.numbergenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public final class BaseballGameModel {

    public static final int NUMBER_SIZE = 3;

    private String userInput;
    private String target;

    public BaseballGameModel(String userInput, NumberGenerator numberGenerator) {
        setUserInput(userInput);
        setTarget(numberGenerator.create());
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String userInput() {
        if (hasThreeLength(userInput) == false || isOnlyInteger(userInput) == false) {
            throw new IllegalArgumentException("3자리 숫자만 허용합니다.");
        }

        return userInput;
    }

    private String target() {
        if (hasThreeLength(target) == false || isOnlyInteger(target) == false) {
            throw new IllegalArgumentException("3자리 숫자만 허용합니다.");
        }

        return target;
    }

    private boolean hasThreeLength(String userInput) {
        return userInput.length() == NUMBER_SIZE;
    }

    private boolean isOnlyInteger(String userInput) {
        char[] chars = userInput.toCharArray();
        for (char aChar : chars) {
            if (Character.isDigit(aChar) == false) {
                return false;
            }
        }
        return true;
    }

    public int[] guessNumber() {
        List<Character> inputList = convertStrToList(userInput());
        List<Character> targetList = convertStrToList(target());
        return comparing(inputList, targetList);
    }

    private int[] comparing(List<Character> input, List<Character> targetList) {
        int strike = 0, ball = 0;

        for (int i = 0; i < NUMBER_SIZE; i++) {
            Character inputChar = input.get(i);
            Character targetChar = targetList.get(i);

            strike = addCountIfTrue(strike, inputChar == targetChar);
            ball = addCountIfTrue(ball, inputChar != targetChar && targetList.contains(inputChar));
        }
        return new int[]{strike, ball};
    }

    private List<Character> convertStrToList(String str) {
        char[] chars = str.toCharArray();

        ArrayList<Character> charList = new ArrayList<>();
        for (char aChar : chars) {
            charList.add(aChar);
        }
        return charList;
    }

    private int addCountIfTrue(int number, boolean condition) {
        if (condition) {
            number = number + 1;
        }
        return number;
    }

    public String printBallCountMessages(int strike, int ball) {
        StringBuilder sb = new StringBuilder();

        if (hasNonCount(strike, ball))
            return sb.append("낫씽").toString();

        appendMessageIfExists(strike, ball, sb, strike + " 스트라이크");
        appendMessageIfExists(ball, sb, ball + " 볼");

        return sb.toString();
    }

    private void appendMessageIfExists(int strike, int ball, StringBuilder sb, String str) {
        if (isNotZero(strike)) {
            sb.append(str);
            appendMessageIfExists(ball, sb, " ");
        }
    }

    private void appendMessageIfExists(int ball, StringBuilder sb, String message) {
        if (isNotZero(ball)) {
            sb.append(message);
        }
    }

    private boolean isNotZero(int num) {
        return num != 0;
    }

    private boolean hasNonCount(int strike, int ball) {
        return strike == 0 && ball == 0;
    }
}
