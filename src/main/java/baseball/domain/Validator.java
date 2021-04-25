package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class Validator {
    public static boolean inValidate(final List<String> numbers) {
        return validateSize(numbers) || validateDuplicate(numbers);
    }

    private static boolean validateSize(final List<String> numbers) {
        return numbers.size() != Numbers.SIZE;
    }

    private static boolean validateDuplicate(final List<String> numbers) {
        return new HashSet<>(numbers).size() != Numbers.SIZE;
    }
}
