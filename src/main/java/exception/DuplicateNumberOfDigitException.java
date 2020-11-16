package exception;

import static domain.BaseballMessage.DUPLICATE_NUMBER_OF_DIGIT_EXCEPTION_MESSAGE;

public class DuplicateNumberOfDigitException extends RuntimeException {
    public DuplicateNumberOfDigitException() {
        super(DUPLICATE_NUMBER_OF_DIGIT_EXCEPTION_MESSAGE);
    }
}
