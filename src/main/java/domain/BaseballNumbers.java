package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static domain.BaseballNumberGenerator.generateThreeLengthRandomNumber;

public class BaseballNumbers {
    private final List<BaseballNumber> numbers;

    public BaseballNumbers(List<BaseballNumber> answerNumbers) {
        validate(answerNumbers);
        this.numbers = answerNumbers;
    }

    public static BaseballNumbers generateRandomNumber() {
        List<BaseballNumber> numbers = generateThreeLengthRandomNumber();
        return new BaseballNumbers(numbers);
    }

    public static BaseballNumbers of(String userNumberRaw) {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (int i = 0; i < userNumberRaw.length(); i++) {
            int numericValue = Character.getNumericValue(userNumberRaw.charAt(i));
            BaseballNumber baseballNumber = BaseballNumberGenerator.getBaseballNumber(numericValue);
            baseballNumbers.add(baseballNumber);
        }
        return new BaseballNumbers(baseballNumbers);
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

    public int isStrike(BaseballNumber userNumber, int position) {
        if (numbers.get(position).equals(userNumber)) {
            return 1;
        }
        return 0;
    }

    public int isBall(BaseballNumber baseballNumber, int position) {
        if (numbers.indexOf(baseballNumber) == position) {
            return 0;
        }
        if (numbers.contains(baseballNumber)) {
            return 1;
        }
        return 0;
    }

    public int size() {
        return numbers.size();
    }

    public BaseballNumber get(int index) {
        return numbers.get(index);
    }
}
