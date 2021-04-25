package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class Validator {
    public static boolean inValidate(final List numbers) {
        return validateSize(numbers) || validateDuplicate(numbers);
    }

    private static boolean validateSize(final List numbers) {
        return numbers.size() != Numbers.SIZE;
    }

    private static boolean validateDuplicate(final List numbers) {
        return new HashSet<>(numbers).size() != Numbers.SIZE;
    }
}
