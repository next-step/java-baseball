package org.dhlee.game.baseball.validation;

import org.dhlee.game.baseball.constant.BaseballConstant;
import org.dhlee.game.baseball.exception.InputNumberException;

public class InputNumberValiator {

    public static boolean checkLengthValidate(String value) {
        if (value.length() != 3) {
            throw new InputNumberException(BaseballConstant.EXCEPTION_MAX_LENGTH);
        }
        return true;
    }

    public static boolean checkFormatValidate(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new InputNumberException(BaseballConstant.EXCEPTION_NUMBER_FORMAT);
        }
        return true;
    }

    public static boolean checkHasEqualNumberValidate(String value) {
        if((value.charAt(0) == value.charAt(1))
                || (value.charAt(0) == value.charAt(2))
                || (value.charAt(1) == value.charAt(2))) {
            throw new InputNumberException(BaseballConstant.EXCEPTION_EQAUL_NUMBER);
        }
        return true;
    }
}
