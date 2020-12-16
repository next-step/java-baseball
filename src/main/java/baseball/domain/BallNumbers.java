package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BallNumbers {
    private List<Integer> numbers;

    private BallNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static BallNumbers from(String ballNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : ballNumbers.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }

        return new BallNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
