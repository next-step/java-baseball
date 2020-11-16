package exception;

import static domain.BaseballMessage.NUMBER_NOT_THREE_DIGITS_EXCEPTION_MESSAGE;

public class NumberNotThreeDigitsException extends RuntimeException {
    public NumberNotThreeDigitsException() {
        super(NUMBER_NOT_THREE_DIGITS_EXCEPTION_MESSAGE);
    }
}
