package util;

import domain.enums.Error;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtil {
    private static final int MAX_DIGIT = 3;

    public boolean isCorrectNumber(String number) {
        if (!validateNumber(number)) {
            return false;
        }

        return true;
    }

    private boolean validateNumber(String number) {
        try {
            if (isNotNumber(number))
                throw new IllegalArgumentException(Error.CONTAIN_ZERO_OR_WORD.getMessage());
            if (isNotCorrectDigits(number))
                throw new IllegalArgumentException(Error.DIGIT_LENGTH.getMessage());
            if (isDuplicateNumber(number))
                throw new IllegalArgumentException(Error.DUPLICATE_NUMBER.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

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

    public boolean isCorrectContinueAnswer(String inputAnswer) {
        if (!validateContinueAnswer(inputAnswer)) {
            return false;
        }

        return true;
    }

    private boolean validateContinueAnswer(String inputAnswer) {
        try {
            if (!("1".equals(inputAnswer) || "2".equals(inputAnswer)))
                throw new IllegalArgumentException(Error.WRONG_INPUT.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
