package baseball.exceptions;

public class QuitException extends RuntimeException {
    public QuitException(String message) {
        super(message);
    }
}
