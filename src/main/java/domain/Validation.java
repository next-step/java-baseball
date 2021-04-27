package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final int BASEBALL_SIZE = 3;

    private static final String NUMBER_FORMAT_EXCEPTION = "입력값이 올바르지 않습니다. 숫자를 입력해주세요.";
    private static final String SIZE_EXCEPTION = "자리수가 올바르지 않습니다.";
    private static final String DUPLICATE_EXCEPTION = "중복된 값이 있습니다.";

    public Validation(List<Integer> numbers) {
        validateNumberFomat(numbers);
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private static void validateNumberFomat(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUM || number > MAX_NUM) {
                throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
            }
        }
    }

    private void validateSize(List<Integer> numbers) {
        if(numbers.size() != BASEBALL_SIZE) {
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> baseballNumberSet = new HashSet<>(numbers);
        if (baseballNumberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }
}
