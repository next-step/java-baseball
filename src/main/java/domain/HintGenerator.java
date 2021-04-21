package domain;

import java.util.List;

public class HintGenerator {

    private static final int COUNT_OF_NUMBERS = 3;

    private final List<Integer> generatedNumbers;

    public HintGenerator(List<Integer> numbers) {
        this.generatedNumbers = numbers;
    }

    public Hint makeHintFromNumbers(List<Integer> numbers) {
        return new Hint(getStrikeCount(numbers), getBallCount(numbers));
    }

    private int getStrikeCount(List<Integer> numbers) {

        int count = 0;
        for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
            count += ifStrikeThenPlusOne(numbers, i);
        }

        return count;
    }

    private int getBallCount(List<Integer> numbers) {

        int count = 0;
        for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
            count += ifBallThenPlusOne(numbers, i);
        }

        return count;
    }

    private boolean equals(Integer a, Integer b) {
        return a.intValue() == b.intValue();
    }

    private int ifStrikeThenPlusOne(List<Integer> numbers, int i) {
        if (equals(numbers.get(i), generatedNumbers.get(i))) {
            return 1;
        }
        return 0;
    }

    private int ifBallThenPlusOne(List<Integer> numbers, int index) {
        if (!equals(numbers.get(index), generatedNumbers.get(index))
            && generatedNumbers.contains(numbers.get(index))) {
            return 1;
        }
        return 0;
    }
}
