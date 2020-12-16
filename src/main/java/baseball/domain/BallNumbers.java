package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallNumbers {
    private static final int VALID_NUMBERS_LENGTH = 3;

    private List<Integer> numbers;

    private BallNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static BallNumbers from(String ballNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (char number : ballNumbers.toCharArray()) {
            numbers.add(getNumberInRangeOneToNine(number));
        }
        requireLengthThree(numbers);
        requireNotDuplicate(numbers);

        return new BallNumbers(numbers);
    }

    private static int getNumberInRangeOneToNine(char number) {
        int numberAsInt = Character.getNumericValue(number);
        if (numberAsInt <= 0 || numberAsInt >= 10) {
            throw new IllegalArgumentException("1~9 사이의 숫자만 허용됩니다.");
        }
        return numberAsInt;
    }

    private static void requireLengthThree(List<Integer> numbers) {
        if (numbers.size() != VALID_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("세자리 수여야 합니다.");
        }
    }

    private static void requireNotDuplicate(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);

        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
