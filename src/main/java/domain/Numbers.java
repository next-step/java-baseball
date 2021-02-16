package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(final List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        validateSize(numbers);
        // TODO: 중복된 수 검사 & 테스트 추가
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자는 3자리로 구성되어야 합니다.");
        }
    }

    public static Numbers of(final String numbersString) {
        Objects.requireNonNull(numbersString);
        List<Integer> numbers = Arrays.stream(numbersString.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Numbers(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public int numberOfDigits() {
        return this.numbers.size();
    }

    /**
     * 서로 다른 두 Numbers가 갖고 있는 numbers(collection) 필드의 특정 index의 값이 동일한지 검사한다.
     *
     * @param index          비교 할 index
     * @param anotherNumbers 비교할 다른 Numbers 객체
     */
    public boolean existsSameNumberAt(final int index, final Numbers anotherNumbers) {
        int anotherNumber = anotherNumbers.numbers.get(index);
        return this.numbers.get(index).equals(anotherNumber);
    }

    /**
     * Numbers 객체가 내부적으로 갖고 있는 특정 number 값을 다른 Numbers 객체도 갖고 있는지 검사한다.
     *
     * @param index          비교 할 index
     * @param anotherNumbers 비교할 다른 Numbers 객체
     */
    public boolean contains(final int index, final Numbers anotherNumbers) {
        int number = this.numbers.get(index);
        return anotherNumbers.numbers.contains(number);
    }
}
