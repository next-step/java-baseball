package com.leeha.baseball.controller.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class BallValidator {

    private final int ballCount;
    private final int minimumNumber;
    private final int maximumNumber;

    public BallValidator(int ballCount, int minimumBallNumber, int maximumBallNumber) {
        this.ballCount = ballCount;
        this.minimumNumber = minimumBallNumber;
        this.maximumNumber = maximumBallNumber;
    }

    public boolean validate(String answer) {
        try {
            return Objects.nonNull(answer) && validateAnswerLength(answer) && validateNumberRange(answer)
                && isNotDuplicateNumber(answer);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validateAnswerLength(String answer) {
        return answer.length() == ballCount;
    }

    private boolean validateNumberRange(String answer) throws NumberFormatException {
        boolean valid = true;

        for (String number : answer.split("")) {
            valid = valid
                && isGreaterThanEqualsMinimumNumber(Integer.parseInt(number))
                && isLessThanEqualsMaximumNumber(Integer.parseInt(number));
        }

        return valid;
    }

    private boolean isNotDuplicateNumber(String answer) {
        String[] numbers = answer.split("");
        HashSet<String> distinctNumbers = new HashSet<>(Arrays.asList(numbers));

        return numbers.length == distinctNumbers.size();
    }

    private boolean isGreaterThanEqualsMinimumNumber(int number) {
        return number >= minimumNumber;
    }

    private boolean isLessThanEqualsMaximumNumber(int number) {
        return number <= maximumNumber;
    }
}