package com.jaeeyeonling.baseball.ball;

import com.jaeeyeonling.baseball.BaseballException;

import java.util.ArrayList;
import java.util.List;

public final class BallsSizeException extends BaseballException {

    private static final String JOIN_DELIMITER = "";
    private static final String MESSAGE = "볼들은 " + Balls.SIZE + "개만을 허용합니다. (입력 값: '%s', %d개)";

    public BallsSizeException(final String input) {
        this(input, input.length());
    }

    public BallsSizeException(final List<Ball> input) {
        this(join(input), input.size());
    }

    private BallsSizeException(final String input,
                               final int size) {
        super(String.format(MESSAGE, input, size));
    }

    private static String join(final List<Ball> input) {
        final var values = new ArrayList<String>(input.size());
        for (final var ball : input) {
            values.add(ball.toString());
        }

        return String.join(JOIN_DELIMITER, values);
    }
}
