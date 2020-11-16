package exception;

import static domain.BaseballMessage.INVALID_NUMBER_OF_DIGIT_RANGE_EXCEPTION_MESSAGE;

public class InvalidNumberOfDigitRangeException extends RuntimeException {
    public InvalidNumberOfDigitRangeException() {
        super(INVALID_NUMBER_OF_DIGIT_RANGE_EXCEPTION_MESSAGE);
    }
}
