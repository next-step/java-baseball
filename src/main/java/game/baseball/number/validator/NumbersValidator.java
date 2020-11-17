package game.baseball.number.validator;

import game.baseball.number.exceptions.InvalidDifferentThreeNumberTypingException;
import game.baseball.number.exceptions.InvalidRestartOrExitInputException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class NumbersValidator implements Validator<String> {

    private static final int NUMBERS_LENGTH = 3;
    private static final int NUMBER_TYPE = 9;
    private static final int START_OF_RANGE = 49;
    private static final int END_OF_RANGE = 57;

    public boolean validate(String input) {
        char[] chars = Optional.ofNullable(input)
            .map(NumbersValidator::split)
            .orElseThrow(() -> new InvalidDifferentThreeNumberTypingException(input));
        integratedValidation(chars);
        return true;
    }

    private static char[] split(String input) {
        return input.toCharArray();
    }

    private static void integratedValidation(char[] chars) {
        validateLength(chars);
        validateNumber(chars);
        validateDiffer(chars);
        validateRange(chars);
    }

    private static void validateNumber(char[] chars) {
        boolean result = true;
        for (char aChar : chars) {
            result = result && (Character.getType(aChar) == NUMBER_TYPE);
        }
        if (!result) {
            throw new InvalidDifferentThreeNumberTypingException(chars);
        }
    }

    private static void validateLength(char[] chars) {
        if (chars.length != NUMBERS_LENGTH) {
            throw new InvalidDifferentThreeNumberTypingException(chars);
        }
    }

    private static void validateRange(char[] chars) {
        boolean result = true;
        for (char aChar : chars) {
            result = result && (aChar >= START_OF_RANGE && aChar <= END_OF_RANGE);
        }
        if (!result) {
            throw new InvalidDifferentThreeNumberTypingException(chars);
        }
    }

    private static void validateDiffer(char[] chars) {
        Set<Character> notDuplicatedChars = new HashSet<>();
        for (char aChar : chars) {
            notDuplicatedChars.add(aChar);
        }
        if (notDuplicatedChars.size() != NUMBERS_LENGTH) {
            throw new InvalidDifferentThreeNumberTypingException(chars);
        }
    }
}
