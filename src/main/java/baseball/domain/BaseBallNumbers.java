package baseball.domain;

import java.util.*;

public class BaseBallNumbers {
    public static final int BALL_NUMBERS_LENGTH = 3;
    private static final int INIT_COUNT = 0;

    private final List<BaseBallNumber> numbers;

    private BaseBallNumbers(List<BaseBallNumber> numbers) {
        requireLengthThree(numbers);
        requireNotDuplicate(numbers);

        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void requireLengthThree(List<BaseBallNumber> numbers) {
        if (numbers.size() != BALL_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("세자리 수여야 합니다.");
        }
    }

    private void requireNotDuplicate(List<BaseBallNumber> numbers) {
        Set<BaseBallNumber> distinctNumbers = new HashSet<>(numbers);
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }

    public static BaseBallNumbers from(String ballNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (char number : ballNumbers.toCharArray()) {
            numbers.add(Character.getNumericValue(number));
        }
        return from(numbers);
    }

    public static BaseBallNumbers from(List<Integer> ballNumbers) {
        List<BaseBallNumber> numbers = new ArrayList<>();
        for (int number : ballNumbers) {
            numbers.add(BaseBallNumber.from(number));
        }
        return new BaseBallNumbers(numbers);
    }

    public int countSameNumberAndPlaceWith(BaseBallNumbers other) {
        int count = INIT_COUNT;
        for (int i = 0; i < BALL_NUMBERS_LENGTH; i++) {
            count += isSame(numbers.get(i), other.numbers.get(i));
        }
        return count;
    }

    public int countSameNumberWith(BaseBallNumbers other) {
        Set<BaseBallNumber> union = new HashSet<>();
        union.addAll(numbers);
        union.addAll(other.numbers);

        return numbers.size() + other.numbers.size() - union.size();
    }

    private int isSame(BaseBallNumber number, BaseBallNumber other) {
        if (number.equals(other)) {
            return 1;
        }
        return 0;
    }

    public List<BaseBallNumber> getNumbers() {
        return numbers;
    }
}
