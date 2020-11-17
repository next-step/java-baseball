package game.baseball.number.exceptions;

public class InvalidRestartOrExitInputException extends IllegalArgumentException {

    public InvalidRestartOrExitInputException(Throwable cause) {
        super(ExceptionCodes.INVALID_INPUT_OF_GAME_RESTART_OR_EXIT.toString(), cause);
    }

    public InvalidRestartOrExitInputException(Object value) {
        super(ExceptionCodes.INVALID_INPUT_OF_GAME_RESTART_OR_EXIT.toString(value));
    }

    public InvalidRestartOrExitInputException(Object value, Throwable cause) {
        super(ExceptionCodes.INVALID_INPUT_OF_GAME_RESTART_OR_EXIT.toString(value.toString()), cause);
    }
}
