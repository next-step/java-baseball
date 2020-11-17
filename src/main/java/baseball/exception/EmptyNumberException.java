package baseball.exception;

public class EmptyNumberException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "Numbers 는 빈값 일 수 없습니다.";

    public EmptyNumberException() {
        super(ERROR_MESSAGE);
    }
}
