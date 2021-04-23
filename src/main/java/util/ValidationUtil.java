package util;

import domain.enums.Error;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtil {
    private static final int MAX_DIGIT = 3;

    public boolean isCorrectNumber(String number) {
        if (!validateNumber(number)) {
            System.out.println(Error.INPUT_ERROR.getMessage());
            return false;
        }

        return true;
    }

    private boolean validateNumber(String number) {
        if (isNotNumber(number))
            return false;
        if (isNotCorrectDigits(number))
            return false;
        if (isDuplicateNumber(number))
            return false;

        return true;
    }

    private boolean isNotNumber(String number) {
        return !number.matches("^[1-9]+$");
    }

    private boolean isNotCorrectDigits(String number) {
        return number.length() != MAX_DIGIT;
    }

    private boolean isDuplicateNumber(String number) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < number.length(); i++) {
            set.add(number.charAt(i));
        }

        return number.length() != set.size();
    }

}
