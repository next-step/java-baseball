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
            count += isStrike(numbers, i) ? 1 : 0;
        }

        return count;
    }

    private int getBallCount(List<Integer> numbers) {

        int count = 0;
        for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
            count += isBall(numbers, i) ? 1 : 0;
        }

        return count;
    }

    private boolean equals(Integer a, Integer b) {
        return a.intValue() == b.intValue();
    }

    private boolean isStrike(List<Integer> numbers, int i) {
        return equals(numbers.get(i), generatedNumbers.get(i));
    }

    private boolean isBall(List<Integer> numbers, int index) {
        return generatedNumbers.contains(numbers.get(index)) && !isStrike(numbers, index);
    }
}
