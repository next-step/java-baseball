package baseball;

import baseball.numbergenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public final class BaseballGameModel {


    public static final String GAME_RESTART = "1";
    public static final String GAME_EXIT = "2";
    public static final int NUMBER_SIZE = 3;

    private String userInput;
    private String target;
    private final NumberGenerator numberGenerator;
    private boolean isRoundFinished = false;
    private boolean isEnd = true;

    public BaseballGameModel(String userInput, NumberGenerator numberGenerator) {
        this(numberGenerator);
        setUserInput(userInput);
    }

    public BaseballGameModel(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        setTarget(numberGenerator.create());
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String userInput() {
        if (hasValidIntegerNumber(userInput) == false) {
            throw new IllegalArgumentException("3자리 숫자만 허용합니다.");
        }

        return userInput;
    }

    private String target() {
        if (hasValidIntegerNumber(target) == false) {
            throw new IllegalArgumentException("3자리 숫자만 허용합니다.");
        }

        return target;
    }

    private boolean hasValidIntegerNumber(String numberStr) {

        char[] chars = numberStr.toCharArray();

        return hasValidLength(numberStr)
                && Character.isDigit(chars[0])
                && Character.isDigit(chars[1])
                && Character.isDigit(chars[2]);
    }

    private boolean hasValidLength(String numberStr) {
        return numberStr.length() == NUMBER_SIZE;
    }

    public int[] guessNumber() {
        List<Character> inputList = convertStrToList(userInput());
        List<Character> targetList = convertStrToList(target());
        int[] result = comparing(inputList, targetList);
        int strike = result[0];
        if (strike == NUMBER_SIZE) {
            isRoundFinished = true;
        }
        return result;
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

        if (hasNonCount(strike, ball)) {
            return sb.append("낫씽").toString();
        }

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

    public boolean isRoundFinished() {
        if (isRoundFinished) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료.");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        return isRoundFinished;
    }

    public void restart() {
        setTarget(numberGenerator.create());
        isRoundFinished = false;
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void end() {
        isEnd = false;
    }

    public void selectGame(String option) {
        option = option.trim();
        if (option.equals(GAME_RESTART)) {
            this.restart();
            return;
        }
        if (option.equals(GAME_EXIT)) {
            this.end();
            return;
        }
        throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }
}
