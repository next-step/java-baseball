package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserNumber {
    private final Integer number;

    public UserNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        validateThreeLength(number);
        validateDuplication(number);
    }

    protected static void validateThreeLength(int randomNumber) {
        String numberString = String.valueOf(randomNumber);
        if (numberString.length() != 3) {
            throw new IllegalArgumentException("입력 숫자는 3자리 수여야 합니다.");
        }
    }

    protected static void validateDuplication(int number) {
        String numberString = String.valueOf(number);
        String[] split = numberString.split("");
        Set<String> set = new HashSet<>(Arrays.asList(split));
        if (set.size() != 3) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력하세요.");
        }
    }
}
