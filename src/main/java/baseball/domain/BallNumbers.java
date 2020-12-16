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
        for (char number : ballNumbers.toCharArray()) {
            numbers.add(getNumberInRangeOneToNine(number));
        }

        return new BallNumbers(numbers);
    }

    private static int getNumberInRangeOneToNine(char number) {
        int numberAsInt = Character.getNumericValue(number);
        if (numberAsInt <= 0 || numberAsInt >= 10) {
            throw new IllegalArgumentException("1~9 사이의 숫자만 허용됩니다.");
        }
        return numberAsInt;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
