package game.baseball.number.exceptions;

public class InvalidDifferentThreeNumberTypingException extends IllegalArgumentException {

    public InvalidDifferentThreeNumberTypingException(Object object) {
        super(ExceptionCodes.INVALID_INPUT_OF_DIFFERENT_THREE_NUMBERS.toString(object));
    }

    public InvalidDifferentThreeNumberTypingException(char[] chars) {
        super(ExceptionCodes.INVALID_INPUT_OF_DIFFERENT_THREE_NUMBERS.toString(chars));
    }
}
