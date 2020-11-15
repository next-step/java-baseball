package game.baseball.number.exceptions;

public class InvalidUserInputTypingException extends IllegalArgumentException {

    public InvalidUserInputTypingException(Throwable cause) {
        super(ExceptionCodes.INVALID_USER_INPUT_TYPING.getErrorMessage(), cause);
    }

    public InvalidUserInputTypingException(String value, Throwable cause) {
        super(ExceptionCodes.INVALID_USER_INPUT_TYPING.getErrorMessage(value), cause);
    }

    public InvalidUserInputTypingException(Byte value) {
        super(ExceptionCodes.INVALID_USER_INPUT_TYPING.getErrorMessage(value + ""));
    }
}