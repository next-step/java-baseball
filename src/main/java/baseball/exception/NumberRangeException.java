package baseball.exception;

public class NumberRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "음수는 사용할 수 없습니다.  서로 다른 3자리 숫자를 입력해주세요. (1~9)";

    public NumberRangeException() {
        super(ERROR_MESSAGE);
    }
}
