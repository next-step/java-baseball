package baseball.exception;

import baseball.constants.MessageType;

public class InvalidNumbersException extends BaseballException {
    public InvalidNumbersException(MessageType messageType) {
        super(messageType.getMessage());
    }
}
