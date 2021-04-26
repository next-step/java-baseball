package com.nextstep.baseball.handler;

import com.nextstep.baseball.enums.ErrorMessages;

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
        List<Integer> list = makeRandomNumberList();
        return makeRandomNumListToSum(list);
    }

    private List<Integer> makeRandomNumberList() {
        List<Integer> randomNumList = new ArrayList<>();
        while (randomNumList.size() < 3) {
            addRandomNumberNotDuplicated(randomNumList);
        }
        return randomNumList;
    }

    private void addRandomNumberNotDuplicated(List<Integer> randomNumList) {
        Random random = new Random();
        int num = random.nextInt(9) + 1;

        if (!randomNumList.contains(num)) {
            randomNumList.add(num);
        }
    }

    private int makeRandomNumListToSum(List<Integer> randomNumList) {
        int result = 0;
        int mul = 100;
        for (int i : randomNumList) {
            result += i * mul;
            mul /= 10;
        }
        return result;
    }

    public int checkStrikes(int source, int target) {
        int numOfStrikes = 0;
        int div = 100;

        for (int i = 0 ; i < INPUT_LENGTH; i++) {
            numOfStrikes += isEqual(makeCompareNum(source, div), makeCompareNum(target, div));
            div = div / 10;
        }

        return numOfStrikes;
    }

    public int checkBalls(int source, int target) {
        int numOfBalls = 0;
        return numOfBalls;
    }

    private int makeCompareNum(int source, int div) {
        int result = source / div;
        return result % 10;
    }

    private int isEqual(int source, int target) {
        return source == target ? 1 : 0;
    }
}
