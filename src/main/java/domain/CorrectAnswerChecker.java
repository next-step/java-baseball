package domain;

public class CorrectAnswerChecker {

    private static final int COUNT_OF_NUMBERS = 3;

    private final Numbers answer;

    public CorrectAnswerChecker(Numbers answer) {
        this.answer = answer;
    }

    public Hint makeResultHint(Numbers numbers) {
        return new Hint(getStrikeCount(numbers), getBallCount(numbers));
    }

    private int getStrikeCount(Numbers numbers) {

        int count = 0;
        for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
            count += ifStrikeThenPlusOne(numbers, i);
        }

        return count;
    }

    private int getBallCount(Numbers numbers) {

        int count = 0;
        for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
            count += ifBallThenPlusOne(numbers, i);
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
