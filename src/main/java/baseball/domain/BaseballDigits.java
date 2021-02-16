package baseball.domain;

import java.util.*;

public class BaseballDigits {
    private static final String EMPTY_OBJECT_ERROR_MESSAGE = "숫자 정보가 없습니다.";
    private static final String SIZE_ERROR_MESSAGE = "세개의 숫자를 입력해주세요";
    private static final String DUPLICATED_NUMBER_ERROR_MESSAGE = "같은 숫자를 입력하였습니다.";
    private static final int NUMBER_SIZE = 3;

    public BaseballDigits(List<BaseballDigit> digits) {
        validateEmptyList(digits);
        validateBaseballNumber(digits);
    }

    private void validateEmptyList(List<BaseballDigit> digits) {
        if (Objects.isNull(digits)) {
            throw new IllegalArgumentException(EMPTY_OBJECT_ERROR_MESSAGE);
        }
    }

    private void validateBaseballNumber(List<BaseballDigit> digits) {
        if (digits.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }

        Set<BaseballDigit> uniqueBaseballDigit = new HashSet<>(digits);
        if (uniqueBaseballDigit.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }
}
