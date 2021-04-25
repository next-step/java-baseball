package domain;

import exception.BaseBallGameFailureException;
import exception.ErrorCode;
import utils.NumberUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameNumbers {

    private final List<Number> numbers;
    private final Set<Number> numberSet;

    private static final int NUMBER_LENGTH = 3;

    private GameNumbers(List<Number> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
        this.numberSet = new HashSet<>(numbers);
    }

    public static GameNumbers of(List<Number> numbers) {
        return new GameNumbers(numbers);
    }

    public static GameNumbers of(String inputNumbers) {
        List<Number> numbers = NumberUtils.toList(inputNumbers);
        return new GameNumbers(numbers);
    }

    /**
     * 같은 number 필드값을 가진 Number 객체를 포함하는지 여부 반환
     * @param number
     * @return
     */
    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    /**
     * 같은 number, position 필드값을 가진 Number 객체를 포함하는지 여부 반환
     * @param number
     * @return
     */
    public boolean containsExactly(Number number) {
        return numberSet.contains(number);
    }

    private void validateNumbers(List<Number> numbers) {
        if (numbers == null || numbers.size() != NUMBER_LENGTH) {
            throw new BaseBallGameFailureException(ErrorCode.NUMBER_LENGTH_ERROR_MESSAGE);
        }

        if (createNotDuplicatedNumbers(numbers).size() < NUMBER_LENGTH) {
            throw new BaseBallGameFailureException(ErrorCode.NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private Set<Integer> createNotDuplicatedNumbers(List<Number> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Number number : numbers) {
            set.add(number.getNumber());
        }
        return set;
    }
}
