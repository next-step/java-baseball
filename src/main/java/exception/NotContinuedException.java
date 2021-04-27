package exception;

public class NotContinuedException extends RuntimeException {

    public static final String NOT_CONTINUED_EXCEPTION = "연속 된 숫자는 입력 불가합니다.";

    public NotContinuedException() {
        super(NOT_CONTINUED_EXCEPTION);
    }

}