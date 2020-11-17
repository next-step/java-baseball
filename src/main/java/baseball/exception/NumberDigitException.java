package baseball.exception;

public class NumberDigitException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "자릿수가 부적합 합니다. 서로 다른 3자리 숫자를 입력해주세요. (1~9)";

    public NumberDigitException() {
        super(ERROR_MESSAGE);
    }
}
