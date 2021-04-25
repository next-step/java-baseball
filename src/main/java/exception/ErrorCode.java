package exception;

public enum ErrorCode {
    NOT_GAME_START_YET_ERROR_MESSAGE("00", "아직 게임이 시작되지 않았습니다."),
    NUMBER_BOUNDARY_ERROR_MESSAGE("01", "숫자는 1 ~ 9 사이의 수여야 합니다."),
    NUMBER_LENGTH_ERROR_MESSAGE("02", "숫자는 3자리 수여야 합니다."),
    NUMBER_DUPLICATE_ERROR_MESSAGE("03", "숫자는 서로 다른 수여야 합니다."),
    RESULT_EMPTY_ERROR_MESSAGE("04", "결과 값이 존재하지 않습니다."),
    RESULT_COUNT_ERROR_MESSAGE("05", "결과 수가 부족합니다.")
    ;

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
