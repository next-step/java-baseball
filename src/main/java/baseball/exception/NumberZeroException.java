package baseball.exception;

public class NumberZeroException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "0은 사용할 수 없습니다. 서로 다른 3자리 숫자를 입력해주세요. (1~9)";

    public NumberZeroException() {
        super(ERROR_MESSAGE);
    }
}
