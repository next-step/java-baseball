package baseball.domain;

public class NoAllowNumber extends IllegalArgumentException {
    public NoAllowNumber(String message) {
        super(message);
    }
}
