package domain;

import utils.NumberUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {

    private final List<Number> numbers;
    private final Set<Number> numberSet;

    private Numbers(List<Number> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
        this.numberSet = new HashSet<>(numbers);
    }

    public static Numbers of(List<Number> numbers) {
        return new Numbers(numbers);
    }

    public static Numbers of(String inputNumbers) {
        List<Number> numbers = NumberUtils.toList(inputNumbers);
        return new Numbers(numbers);
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

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validateNumbers(List<Number> numbers) {
        if (numbers == null || numbers.size() != 3) {
            throw new IllegalArgumentException("숫자는 3자리 수여야 합니다.");
        }

        if (createNotDuplicatedNumbers(numbers).size() < 3) {
            throw new IllegalArgumentException("숫자는 서로 다른 수여야 합니다.");
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
