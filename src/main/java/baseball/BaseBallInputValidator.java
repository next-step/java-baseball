package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseBallInputValidator {
    public static boolean isIsValid(String input) {
        if (!checkArgumentTypeAndLength(input)) {
            return false;
        }

        return checkArgumentDuplicated(input);
    }

    private static boolean checkArgumentTypeAndLength(String input) {
        String regExp = "^[1-9]+$";
        int length = input.length();

        return input.matches(regExp) && length > 0 && length <= 3;
    }

    private static boolean checkArgumentDuplicated(String input) {
        Set<Character> uniqueChars = new HashSet<>();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            uniqueChars.add(input.charAt(i));
        }

        return uniqueChars.size() == 3;
    }
}
