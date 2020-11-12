package baseball.exception;

public class IllegalBallNumberException extends RuntimeException {

    private static final String MESSAGE = "1~9 사이의 정수만 생성 가능";

    public IllegalBallNumberException() {
        super(MESSAGE);
    }
}
