package baseball.domain;

public class NoAllowNumberException extends IllegalArgumentException {
    public NoAllowNumberException(String message) {
        super(message);
    }
}
