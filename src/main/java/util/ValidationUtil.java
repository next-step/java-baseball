package util;

import domain.enums.Error;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtil {
    public boolean isCorrectNumber(String number) {
        if (!validateNumber(number)) {
            System.out.println(Error.INPUT_ERROR.getMessage());
            return false;
        }

        return true;
    }

    private boolean validateNumber(String number) {
        if (!isNumber(number))
            return false;
        if (!is3Digits(number))
            return false;
        if (isDuplicateNumber(number))
            return false;

        return true;
    }

    private boolean isNumber(String number) {
        return number.matches("^[1-9]+$");
    }

    private boolean is3Digits(String number) {
        return number.length() == 3;
    }

    private boolean isDuplicateNumber(String number) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < number.length(); i++) {
            set.add(number.charAt(i));
        }

        return number.length() != set.size();
    }

}
