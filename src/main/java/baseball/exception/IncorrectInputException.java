package baseball.exception;

public class IncorrectInputException extends RuntimeException {

    public IncorrectInputException() {
        super("잘못된 입력값입니다.");
    }

    public IncorrectInputException(String message) {
        super(message);
    }
}
