package com.leeha.baseball.controller.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class BallValidatorTest {

    public static final int CAPACITY = 3;
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;

    private static BallValidator validator;

    @BeforeAll
    public static void initialize() {
        validator = new BallValidator(CAPACITY, MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "leeha0", "!"})
    public void validate_ShouldReturnFalseForNotNumberAnswer(String answer) {
        boolean validate = validator.validate(answer);

        assertThat(validate)
            .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12"})
    public void validate_ShouldReturnFalseForNotFillAnswer(String answer) {
        boolean validate = validator.validate(answer);

        assertThat(validate)
            .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"012", "890"})
    public void validate_ShouldReturnFalseForInvalidRangeAnswer(String answer) {
        boolean validate = validator.validate(answer);

        assertThat(validate)
            .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "333", "899"})
    public void validate_ShouldReturnFalseForDuplicatedAnswer(String answer) {
        boolean validate = validator.validate(answer);

        assertThat(validate)
            .isFalse();
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void validate_ShouldReturnFalseForNullOrEmptyAnswer(String answer) {
        boolean validate = validator.validate(answer);

        assertThat(validate)
            .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    public void validate_ShouldReturnTrueForValidString(String answer) {
        boolean validate = validator.validate(answer);

        assertThat(validate)
            .isTrue();
    }
}