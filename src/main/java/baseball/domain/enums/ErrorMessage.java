package baseball.domain.enums;

import static baseball.domain.BaseballNumbers.*;
import static java.lang.String.format;

public enum ErrorMessage {
    MESSAGE_NUMERIC_ONLY("숫자만 입력 해주세요 "),
    MESSAGE_INVALID_NUMERIC_BOUNDARY(format("%d과 %d 사이의 숫자로 이뤄진 %d 자리 숫자를 입력해주세요"
            , MIN_RANDOM_NUMBER
            , MAX_RANDOM_NUMBER
            , RANDOM_NUMBER_COUNT)),
    MESSAGE_DUPLICATE_INPUT(format("중복되지 않은 %d자리 숫자를 입력해주세요.", RANDOM_NUMBER_COUNT)),
    MESSAGE_INVALID_INPUT_LENGTH(RANDOM_NUMBER_COUNT + "자리의 숫자를 입력해주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
