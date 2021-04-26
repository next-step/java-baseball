package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

public class Validator {
    public static boolean inValidate(final List numbers) {
        return validateSize(numbers) || validateDuplicate(numbers) || isOutOfRange(numbers);
    }

    private static boolean validateSize(final List numbers) {
        return numbers.size() != Numbers.SIZE;
    }

    private static boolean validateDuplicate(final List numbers) {
        return new HashSet<>(numbers).size() != Numbers.SIZE;
    }

    public static boolean isOutOfRange(final List numbers) {
        for (final Object object : numbers) {
            if(isOutOfRange(object)) return true;
        }
        return false;
    }

    private static boolean isOutOfRange(Object object) {
        final int value = Integer.parseInt(object.toString());
        return isOutOfRange(value);
    }

    public static boolean isOutOfRange(int value) {
        return value < Number.MIN_VALUE || value > Number.MAX_VALUE;
    }
}
