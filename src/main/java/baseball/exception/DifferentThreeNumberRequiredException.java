package baseball.exception;

public class DifferentThreeNumberRequiredException extends RuntimeException {

    public static final String DIFFERENT_THREE_NUMBERS_REQUIRED = "서로 다른 세 숫자가 필요합니다.";

    public DifferentThreeNumberRequiredException() {
        super(DIFFERENT_THREE_NUMBERS_REQUIRED);
    }
}
