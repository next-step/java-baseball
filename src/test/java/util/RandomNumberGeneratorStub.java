package util;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGeneratorStub implements RandomGenerator {
    private final List<Integer> numbers = new ArrayList<>();

    public RandomNumberGeneratorStub(String input) {
        char[] array = input.toCharArray();
        for (char ch : array) {
            numbers.add(ch - '0');
        }
    }

    @Override
    public List<Integer> makeNumbersLessThanTen() {
        return numbers;
    }
}
