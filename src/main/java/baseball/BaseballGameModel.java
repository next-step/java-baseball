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

    public GameResult guessNumber() {
        List<Character> inputList = convertStrToList(userInput());
        List<Character> targetList = convertStrToList(target());
        GameResult result = comparing(inputList, targetList);
        if ((result.isFullStrike())) {
            isRoundFinished = true;
        }
        return result;
    }

    private GameResult comparing(List<Character> input, List<Character> targetList) {
        int strike = 0, ball = 0;

        for (int i = 0; i < NUMBER_SIZE; i++) {
            Character inputChar = input.get(i);
            Character targetChar = targetList.get(i);

            strike = addCountIfTrue(strike, inputChar == targetChar);
            ball = addCountIfTrue(ball, inputChar != targetChar && targetList.contains(inputChar));
        }
        return new GameResult(strike, ball);
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

    public boolean isRoundFinished() {
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
