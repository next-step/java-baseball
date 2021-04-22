package baseball.exception;

import baseball.model.BaseballNumber;

public class BaseballNumberFormatException extends RuntimeException {
    public BaseballNumberFormatException(BaseballNumber baseballNumber) {
        super("Invalid Baseball Number " + baseballNumber);
    }

}
