package exception;

public class InvalidGameCommandException extends BaseBallGameException {
    public InvalidGameCommandException(String message) {
        super(message);
    }
}
