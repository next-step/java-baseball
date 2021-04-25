package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {
    private List<Number> gameNumbers;

    public BaseballGame(NumberGenerator numberGenerator) {
        this.gameNumbers = numberGenerator.generate();
        validateNumbers(this.gameNumbers);
    }

    private void validateNumbers(List<Number> numbers) {
        if (numbers == null || numbers.size() != 3) {
            throw new IllegalArgumentException("숫자는 3자리 수여야 합니다.");
        }

        if (createNotDuplicatedNumbers(numbers).size() < 3) {
            throw new IllegalArgumentException("숫자는 서로 다른 수여야 합니다.");
        }
    }

    private Set<Number> createNotDuplicatedNumbers(List<Number> numbers) {
        return new HashSet<>(numbers);
    }
}
