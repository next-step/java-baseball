package baseball.exception.message;

public enum ErrorMessage {

    BASEBALL_NUMBER_INVALID_FORMAT_EXCEPTION_MASSAGE("야구게임에 유효하지 않은 형식 입니다. 정수만 입력 가능 합니다."),
    BASEBALL_NUMBER_INVALID_RANGE_EXCEPTION_MASSAGE("야구게임에 유효하지 않은 숫자 범위 입니다. 각 자리수는 1이상 9이하의 정수로 입력되어야 합니다."),
    BASEBALL_NUMBERS_HAS_DUPLICATION_EXCEPTION_MASSAGE("야구게임 숫자 모음은 중복된 수를 가질 수 없습니다."),
    BASEBALL_NUMBERS_HAS_INVALID_LENGTH_EXCEPTION_MASSAGE("야구게임 숫자 모음에 유효하지 않은 길이입니다. 3자리 정수를 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
