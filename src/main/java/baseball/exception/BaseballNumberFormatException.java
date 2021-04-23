package baseball.exception;

import baseball.model.BaseballNumber;

public class BaseballNumberFormatException extends RuntimeException {
    public BaseballNumberFormatException(BaseballNumber baseballNumber) {
        super("Invalid Baseball Number " + baseballNumber);
    }

    public BaseballNumberFormatException(String input) {
        super("Invalid Input Number " + input);
    }

    public BaseballNumberFormatException(int input) {
        super("Invalid Input Number " + input);
    }
}
