package me.kingcjy.baseball;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KingCjy
 */
public class ValidationUtils {

    public static ValidationResult getValidationResult(String input) {
        if (input.length() != 3) {
            return ValidationResult.INVALID_LENGTH;
        }

        if (isDuplicate(input)) {
            return ValidationResult.DUPLICATED;
        }

        if (!isNumber(input) || containsZero(input)) {
            return ValidationResult.INVALID_INPUT;
        }

        return ValidationResult.SUCCESS;
    }

    private static boolean isDuplicate(String input) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }

        return set.size() != input.length();
    }

    private static boolean containsZero(String input) {
        return input.contains("0");
    }

    private static boolean isNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
