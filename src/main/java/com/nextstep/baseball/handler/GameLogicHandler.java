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
}
