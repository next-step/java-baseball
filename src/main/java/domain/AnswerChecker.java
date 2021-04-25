package domain;

import java.util.function.BiFunction;

public class AnswerChecker {

    private static final int COUNT_OF_NUMBERS = 3;
    private static final int ADD_COUNT = 1;
    private static final int NOT_ADD_COUNT = 0;

    private final Numbers answer;

    public AnswerChecker(Numbers answer) {
        this.answer = answer;
    }

    public Hint makeResultHint(Numbers numbers) {
        return new Hint(getStrikeCount(numbers), getBallCount(numbers));
    }

    private int getStrikeCount(Numbers numbers) {
        return getCount(this::ifStrikeThenPlusOne, numbers);
    }

    private int getBallCount(Numbers numbers) {
        return getCount(this::ifBallThenPlusOne, numbers);
    }

    private int getCount(BiFunction<Numbers, Integer, Integer> biFunction, Numbers numbers) {
        int count = 0;
        for (int index = 0; index < COUNT_OF_NUMBERS; index++) {
            count += biFunction.apply(numbers, index);
        }
        return count;
    }

    private boolean equals(Integer a, Integer b) {
        return a.intValue() == b.intValue();
    }

    private int ifStrikeThenPlusOne(Numbers numbers, int index) {
        if (equals(numbers.get(index), answer.get(index))) {
            return ADD_COUNT;
        }
        return NOT_ADD_COUNT;
    }

    private int ifBallThenPlusOne(Numbers numbers, int index) {
        if (!equals(numbers.get(index), answer.get(index))
            && answer.contains(numbers.get(index))) {
            return ADD_COUNT;
        }
        return NOT_ADD_COUNT;
    }
}
