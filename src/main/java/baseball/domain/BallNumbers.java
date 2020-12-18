package baseball.domain;

import java.util.*;

public class BallNumbers {
    public static final int BALL_NUMBERS_LENGTH = 3;
    private static final int INIT_COUNT = 0;

    private final List<BallNumber> numbers;

    private BallNumbers(List<BallNumber> numbers) {
        requireLengthThree(numbers);
        requireNotDuplicate(numbers);

        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void requireLengthThree(List<BallNumber> numbers) {
        if (numbers.size() != BALL_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("세자리 수여야 합니다.");
        }
    }

    private void requireNotDuplicate(List<BallNumber> numbers) {
        Set<BallNumber> distinctNumbers = new HashSet<>(numbers);
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }

    public static BallNumbers from(String ballNumbers) {
        List<BallNumber> numbers = new ArrayList<>();
        for (char number : ballNumbers.toCharArray()) {
            numbers.add(new BallNumber(Character.getNumericValue(number)));
        }
        return new BallNumbers(numbers);
    }

    public int countSameNumberAndPlaceWith(BallNumbers other) {
        int count = INIT_COUNT;
        for (int i = 0; i < BALL_NUMBERS_LENGTH; i++) {
            count += isSame(numbers.get(i), other.numbers.get(i));
        }
        return count;
    }

    public int countSameNumberWith(BallNumbers other) {
        Set<BallNumber> union = new HashSet<>();
        union.addAll(numbers);
        union.addAll(other.numbers);

        return numbers.size() + other.numbers.size() - union.size();
    }

    private int isSame(BallNumber number, BallNumber other) {
        if (number.equals(other)) {
            return 1;
        }
        return 0;
    }

    public List<BallNumber> getNumbers() {
        return numbers;
    }
}
