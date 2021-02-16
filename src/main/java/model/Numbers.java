package model;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Numbers {
    private static final int NUMBERS_SIZE = 3;
    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    private void validate(List<Number> numbers) {
        boolean isUnique = numbers.stream().map(Number::getNumber).allMatch(new HashSet<>()::add);
        if (!isUnique) {
            throw new IllegalArgumentException("숫자열에 중복된 수가 있습니다.");
        }

        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("숫자열의 길이가 유효하지 않습니다.");
        }
    }

    public static Numbers generateNumbers() {
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            numbers.add(Number.of(RandomUtils.generateIntegers()));
        }
        return Numbers.of(numbers);
    }

    public static Numbers of (List<Number> numbers) {
        return new Numbers(new ArrayList<>(numbers));
    }
}
