package exception;

import static domain.BaseballMessage.INVALID_GAME_STATUS_EXCEPTION_MESSAGE;

public class InvalidGameStatusException extends RuntimeException {
    public InvalidGameStatusException() {
        super(INVALID_GAME_STATUS_EXCEPTION_MESSAGE);
    }
}
