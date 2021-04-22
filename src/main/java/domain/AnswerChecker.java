package domain;

import java.util.function.BiFunction;

public class AnswerChecker {

    private static final int COUNT_OF_NUMBERS = 3;

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
        for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
            count += biFunction.apply(numbers, i);
        }
        return count;
    }

    private boolean equals(Integer a, Integer b) {
        return a.intValue() == b.intValue();
    }

    private int ifStrikeThenPlusOne(Numbers numbers, int i) {
        if (equals(numbers.get(i), answer.get(i))) {
            return 1;
        }
        return 0;
    }

    private int ifBallThenPlusOne(Numbers numbers, int index) {
        if (!equals(numbers.get(index), answer.get(index))
            && answer.contains(numbers.get(index))) {
            return 1;
        }
        return 0;
    }
}
