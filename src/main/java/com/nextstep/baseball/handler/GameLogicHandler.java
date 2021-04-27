package com.nextstep.baseball.handler;

import com.nextstep.baseball.enums.ErrorMessages;
import com.nextstep.baseball.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogicHandler {
    public static final int INPUT_LENGTH = 3;

    public int validateAndReturnInput(String input) {
        if (input == null || input.length() < INPUT_LENGTH) {
            return ErrorMessages.INPUT_LENGTH_UNDER.getCode();
        }

        if (input.length() > INPUT_LENGTH) {
            return ErrorMessages.INPUT_LENGTH_OVER.getCode();
        }

        return parseAndReturnInput(input);
    }

    private int parseAndReturnInput(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            result = ErrorMessages.INPUT_TYPE.getCode();
        }
        return result;
    }

    public int makeRandomNumberForGame() {
        List<Integer> list = NumberUtil.makeRandomNumberList(INPUT_LENGTH);
        return NumberUtil.makeDigitListToNum(list);
    }

    public int checkStrikes(int source, int target) {
        int numOfStrikes = 0;
        int div = 100;

        for (int i = 0 ; i < INPUT_LENGTH; i++) {
            numOfStrikes += NumberUtil.isEqual(makeCompareNum(source, div), makeCompareNum(target, div));
            div = div / 10;
        }

        return numOfStrikes;
    }

    private int makeCompareNum(int source, int div) {
        int result = source / div;
        return result % 10;
    }

    public int checkBalls(int source, int target) {
        int numOfBalls = 0;
        for (int i = 1 ; i <= INPUT_LENGTH; i++) {
            numOfBalls += compareWithTarget(source, i, target);
        }
        return numOfBalls;
    }

    private int compareWithTarget(int source, int index, int target) {
        int result = 0;

        List<Integer> indexList = makeInitIndexForCompare();
        indexList.remove(new Integer(index));
        for (int i : indexList) {
            result += NumberUtil.isEqual(makeCompareNumByIndex(source, index), makeCompareNumByIndex(target, i));
        }

        return result;
    }

    private int makeCompareNumByIndex(int source, int index) {
        int div = 100;
        for (int i = 1; i < index; i++) {
            div /= 10;
        }
        return makeCompareNum(source, div);
    }

    private List<Integer> makeInitIndexForCompare() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= INPUT_LENGTH; i++) {
            list.add(i);
        }
        return list;
    }

    public int[] checkStrikesAndBalls(int source, int target) {
        int[] result = new int[2];
        result[0] = checkStrikes(source, target);
        result[1] = checkBalls(source, target);
        return result;
    }
}
