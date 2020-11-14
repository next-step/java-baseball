package domain;

import java.util.*;

import static domain.BaseballNumberGenerator.generateThreeLengthRandomNumber;

public class AnswerNumbers {
    private final List<BaseballNumber> answerNumbers;

    public AnswerNumbers(List<BaseballNumber> answerNumbers) {
        validate(answerNumbers);
        this.answerNumbers = answerNumbers;
    }

    public static AnswerNumbers init() {
        List<BaseballNumber> numbers = generateThreeLengthRandomNumber();
        return new AnswerNumbers(numbers);
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
        if (answerNumbers.get(position).equals(userNumber)) {
            return 1;
        }
        return 0;
    }

    public int isBall(BaseballNumber baseballNumber, int position) {
        if (answerNumbers.indexOf(baseballNumber) == position) {
            return 0;
        }
        if (answerNumbers.contains(baseballNumber)) {
            return 1;
        }
        return 0;
    }
}
