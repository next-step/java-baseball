package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Numbers {
    private static final List<Integer> ALLOWED_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private final List<Integer> choiceNumbers;

    public Numbers(List<Integer> numbers) {
        this.choiceNumbers = numbers;
    }

    public List<Integer> getChoiceNumbers() {
        return choiceNumbers;
    }

    public static Numbers generateRandomNumbers(Integer size) {
        List<Integer> allowedNumbers = new ArrayList<>(ALLOWED_NUMBERS);
        Collections.shuffle(allowedNumbers);
        List<Integer> shuffledNumbers = allowedNumbers.subList(0, size);
        return new Numbers(shuffledNumbers);
    }
}
