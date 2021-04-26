package dev.heowc.ball;

import java.util.ArrayList;
import java.util.List;

public final class InvalidBallSizeException extends RuntimeException {

    private static final String JOIN_DELIMITER = "";
    private static final String MESSAGE = "볼의 갯수는 " + Balls.SIZE + "개만 허용됩니다. (입력 값: '%s', %d개)";

    public InvalidBallSizeException(final List<Ball> input) {
        this(join(input), input.size());
    }

    private InvalidBallSizeException(final String input, final int size) {
        super(String.format(MESSAGE, input, size));
    }

    private static String join(final List<Ball> input) {
        final List<String> values = new ArrayList<>(input.size());
        for (final Ball ball : input) {
            values.add(ball.toString());
        }
        return String.join(JOIN_DELIMITER, values);
    }
}
