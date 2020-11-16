package baseball.exception;

public class IncorrectNumbersException extends RuntimeException {

    public IncorrectNumbersException() {
        super("잘못된 숫자 형식입니다.");
    }

    public IncorrectNumbersException(String message) {
        super(message);
    }
}
