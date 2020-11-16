package baseball.domain;

import baseball.exception.IncorrectNumbersException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Numbers {
    private static final List<Integer> ALLOWED_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private final List<Integer> choiceNumbers;

    public Numbers(List<Integer> choiceNumbers) {
        this.choiceNumbers = choiceNumbers;
        validateNumbers();
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

    private void validateNumbers() {
        if (choiceNumbers == null || choiceNumbers.isEmpty()) {
            throw new IncorrectNumbersException("숫자가 비었습니다.");
        }
        if (!ALLOWED_NUMBERS.containsAll(choiceNumbers)) {
            throw new IncorrectNumbersException("허용되지 않은 숫자가 존재합니다.");
        }
        if (new HashSet<>(choiceNumbers).size() != choiceNumbers.size()) {
            throw new IncorrectNumbersException("중복된 숫자가 존재합니다.");
        }
    }
}
