package baseball.exception;

public class NumberOnlyException extends RuntimeException {

    public static final String NUMBER_ONLY_EXCEPTION = "숫자만 입력 가능합니다.";

    public NumberOnlyException() {
        super(NUMBER_ONLY_EXCEPTION);
    }

}
