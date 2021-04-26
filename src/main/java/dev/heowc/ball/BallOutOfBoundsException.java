package dev.heowc.ball;

public final class BallOutOfBoundsException extends RuntimeException {

    static final String MESSAGE = "볼은 " + Ball.MIN_VALUE + " ~ " + Ball.MAX_VALUE +
            " 사이의 값으로만 생성할 수 있습니다. (입력 값: '%s')";

    public BallOutOfBoundsException(final int input) {
        super(String.format(MESSAGE, input));
    }
}
