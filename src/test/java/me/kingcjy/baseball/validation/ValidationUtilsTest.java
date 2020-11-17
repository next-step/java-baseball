package me.kingcjy.baseball.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */
class ValidationUtilsTest {

    @Test
    @DisplayName("입력한 숫자에 따라 ValidationResult를 응답한다. InvalidLength")
    public void getValidationResultTest() {
        ValidationResult invalidLength = ValidationUtils.getValidationResult("1234");
        ValidationResult duplicate = ValidationUtils.getValidationResult("111");
        ValidationResult invalidInput = ValidationUtils.getValidationResult("asd");
        ValidationResult success = ValidationUtils.getValidationResult("123");

        assertThat(invalidLength).isEqualTo(ValidationResult.INVALID_LENGTH);
        assertThat(duplicate).isEqualTo(ValidationResult.DUPLICATED);
        assertThat(invalidInput).isEqualTo(ValidationResult.INVALID_INPUT);
        assertThat(success).isEqualTo(ValidationResult.SUCCESS);
    }
}