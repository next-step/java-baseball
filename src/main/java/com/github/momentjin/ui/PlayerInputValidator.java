package com.github.momentjin.ui;

import java.util.HashSet;
import java.util.Set;

public class PlayerInputValidator {

    public ValidatorResult isNotNumber(String inputNumbers) {

        for (char number : inputNumbers.toCharArray()) {
            if (!Character.isDigit(number)) {
                return ValidatorResult.fail("반드시 숫자만 입력해야 합니다");
            }
        }

        return ValidatorResult.success();
    }

    public ValidatorResult isInvalidSize(String inputNumbers, int size) {
        boolean isValid = inputNumbers.length() == size;
        if (isValid) {
            return ValidatorResult.success();
        }

        return ValidatorResult.fail(size+"개의 숫자만 입력해야 합니다.");
    }

    public ValidatorResult containsOverlappedNumber(String inputNumbers) {

        int originSize = inputNumbers.toCharArray().length;
        Set<Character> inputNumberSet = new HashSet<>();
        for (char number : inputNumbers.toCharArray()) {
            inputNumberSet.add(number);
        }

        boolean isValid = originSize == inputNumberSet.size();
        if (isValid) {
            return ValidatorResult.success();
        }

        return ValidatorResult.fail("중복된 숫자는 입력할 수 없습니다.");
    }
}

class ValidatorResult {

    public boolean isValid;
    public String errorMessage;

    private ValidatorResult(boolean isValid, String errorMessage) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
    }

    public boolean isError() {
        return !isValid;
    }

    public static ValidatorResult success() {
        return new ValidatorResult(true, "");
    }

    public static ValidatorResult fail(String errorMessage) {
        return new ValidatorResult(false, errorMessage);
    }
}
