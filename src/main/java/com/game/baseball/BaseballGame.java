package com.game.baseball;

import com.game.code.ErrorCode;
import com.game.common.Game;
import com.game.exception.GameException;
import com.game.util.NumberUtil;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseballGame implements Game {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    @Override
    public boolean isValidInput(String input) {
        Set<Integer> integerSet = new HashSet<>();

        for (char ch : input.toCharArray()) {
            int number = Character.getNumericValue(ch);
            isValidNumber(number);
            integerSet.add(number);
        }
        return integerSet.size() == 3;
    }

    private void isValidNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER)
            throw new GameException(ErrorCode.INVALID_BASEBALL_NUMBER);
    }

    public String generateNumber() {
        Set<Integer> integerSet = new LinkedHashSet<>();
        while (integerSet.size() < 3) {
            int number = NumberUtil.randomNumber(MIN_NUMBER, MAX_NUMBER);
            integerSet.add(number);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : integerSet) {
            stringBuilder.append(integer);
        }
        return stringBuilder.toString();
    }

    public BaseballGameResult play(String target, String input) {
        int strike = 0;
        int ball = 0;

        char[] numbers = target.toCharArray();
        for (int targetIndex = 0; targetIndex < numbers.length; targetIndex++) {
            int inputIndex = input.indexOf(numbers[targetIndex]);
            strike += countStrike(targetIndex, inputIndex);
            ball += countBall(targetIndex, inputIndex);
        }
        return new BaseballGameResult(strike, ball);
    }

    private int countStrike(int targetIndex, int inputIndex) {
        if (targetIndex == inputIndex)
            return 1;
        return 0;
    }

    private int countBall(int targetIndex, int inputIndex) {
        if (inputIndex == -1)
            return 0;
        if (targetIndex != inputIndex)
            return 1;
        return 0;
    }
}
