package util;

import domain.enums.Error;

public class ValidationUtil {
    private boolean validateNumber(String number) {
        if (!isNumber(number))
            return false;
        if (!is3Digits(number))
            return false;

        return true;
    }

    private boolean isNumber(String number) {
        return number.matches("^[1-9]+$");
    }

    private boolean is3Digits(String number) {
        return number.length() == 3;
    }

    public boolean isCorrectNumber(String number) {
        if (!validateNumber(number)) {
            System.out.println(Error.INPUT_ERROR.getMessage());
            return false;
        }

        return true;
    }
}
