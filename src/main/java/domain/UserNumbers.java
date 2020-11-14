package domain;

import java.util.*;

public class UserNumbers {
    private final List<BaseballNumber> numbers;

    public UserNumbers(List<BaseballNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static UserNumbers of(String userNumberRaw) {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (int i = 0; i < userNumberRaw.length(); i++) {
            int numericValue = Character.getNumericValue(userNumberRaw.charAt(i));
            BaseballNumber baseballNumber = BaseballNumberGenerator.getBaseballNumber(numericValue);
            baseballNumbers.add(baseballNumber);
        }
        return new UserNumbers(baseballNumbers);
    }

    private static void validate(List<BaseballNumber> numbers) {
        validateHasThreeLength(numbers);
        validateDuplication(numbers);
    }

    protected static void validateHasThreeLength(List<BaseballNumber> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("입력 숫자는 3자리 수여야 합니다.");
        }
    }

    protected static void validateDuplication(List<BaseballNumber> numbers) {
        Set<BaseballNumber> set = new HashSet<>(numbers);
        if (set.size() != 3) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력하세요.");
        }
    }

    public int size() {
        return numbers.size();
    }


    public BaseballNumber get(int index) {
        return numbers.get(index);
    }
}
