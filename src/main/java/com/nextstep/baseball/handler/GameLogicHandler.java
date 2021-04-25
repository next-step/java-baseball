package com.nextstep.baseball.handler;

import com.nextstep.baseball.enums.ErrorMessages;

import java.util.Random;

public class GameLogicHandler {
    public static final int INPUT_LENGTH = 3;

    public int validateAndReturnInput(String input) {
        if (input == null) {
            return ErrorMessages.INPUT_LENGTH_UNDER.getCode();
        }

        if (input.length() < INPUT_LENGTH) {
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
        Random random = new Random();
        int result = 0;
        for (int i = 0; i < 3 ; i++) {
            result = result * 10 + (random.nextInt(9) + 1);
        }
        return result;
    }

    public int checkStrike(int source, int target) {
        int numOfStrike = 0;
        int div = 100;

        for (int i = 0 ; i < INPUT_LENGTH; i++) {
            numOfStrike += isEqual(makeCompareNum(source, div), makeCompareNum(target, div));
            div = div / 10;
        }

        return numOfStrike;
    }

    private int makeCompareNum(int source, int div) {
        int result = source / div;
        return result % 10;
    }

    private int isEqual(int source, int target) {
        return source == target ? 1 : 0;
    }
}
