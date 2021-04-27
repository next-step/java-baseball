package com.woowahan.precourse.baseball.view;

public class InputValidation {

    public static boolean isValidRange(String inputNumber) {
        return inputNumber.length() == 3;
    }

    public static boolean isNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
