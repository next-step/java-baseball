package util;

import java.util.HashSet;
import java.util.Set;

public class RandomNumberGeneratorStub implements RandomGenerator {
    private final Set<Integer> numbers;

    public RandomNumberGeneratorStub(int[] numberArray) {
        numbers = new HashSet<>();
        for (int num : numberArray) {
            this.numbers.add(num);
        }
    }

    @Override
    public Set<Integer> makeNumbersLessThanTen() {
        return numbers;
    }
}
