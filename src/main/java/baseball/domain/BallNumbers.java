package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BallNumbers {

    private final List<BallNumber> numbers;

    public BallNumbers(String numbers) {
        validateNullorEmpty(numbers);
        validateDuplicate(numbers);
        this.numbers = convertToList(numbers);
    }

    private void validateNullorEmpty(String numbers) {
        if (numbers == null || numbers.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 값은 넣을 수 없습니다.");
        }
    }

    private void validateDuplicate(String numbers) {
        String[] splited = numbers.split("");
        Set<BallNumber> validateSet = makeValidateSet(splited);
        if (validateSet.size() != 3) {
            throw new IllegalArgumentException("숫자는 중복되지 않은 3자리 숫자여야 합니다.");
        }
    }

    private Set<BallNumber> makeValidateSet(String[] splited) {
        Set<BallNumber> validateSet = new HashSet<>();
        for (String number : splited) {
            validateSet.add(new BallNumber(number));
        }
        return validateSet;
    }

    private List<BallNumber> convertToList(String numbers) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumbers that = (BallNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
