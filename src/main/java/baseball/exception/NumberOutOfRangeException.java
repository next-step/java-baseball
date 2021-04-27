package baseball.exception;

import baseball.domain.Number;

public final class NumberOutOfRangeException extends IllegalArgumentException {

    static final String MESSAGE = Number.MIN_VALUE + " ~ " + Number.MAX_VALUE + " 사이의 값으로만 생성할 수 있습니다.";

    public NumberOutOfRangeException(final int input) {
        super(String.format(MESSAGE, input));
    }
}
