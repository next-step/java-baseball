package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {
    private static final int NUMBER_LENGTH = 3;
    private final String number;

    public BaseballNumber(final int numberInt) {
        this.number = String.valueOf(numberInt);
        validateLength(number);
        validateZero(number);
        validateDuplicate(number);
    }

    private void validateLength(final String number) {
        if (number.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("숫자 " + NUMBER_LENGTH + "개만 입력해주세요.");
        }
    }

    private void validateZero(final String number) {
        if (number.contains("0")) {
            throw new IllegalArgumentException("0이 들어있습니다.");
        }
    }

    private void validateDuplicate(final String number) {
        List<String> splitNumbers = Arrays.asList(number.split(""));
        Set<String> numbers = new HashSet<>(splitNumbers);

        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("중복되는 숫자가 있습니다.");
        }
    }

    public String getNumber() {
        return number;
    }
}
