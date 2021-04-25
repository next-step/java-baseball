package baseball.domain;

public class DuplicatedNumberException extends IllegalArgumentException {
    public DuplicatedNumberException(String message) {
        super(message);
    }
}
