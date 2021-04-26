package baseball.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserAnswerValidatorTest {
	private final InputValidator validator = new UserAnswerValidator();

	@Test
	public void isValidate_NonDupThreeNumbersParameter_ShouldReturnTrue() {
		assertTrue(validator.isValid("123"));
	}

	@Test
	public void isValidate_DupParameter_ShouldReturnFalse() {
		assertFalse(validator.isValid("111"));
	}

	@Test
	public void isValidate_FourLengthParameter_ShouldReturnFalse() {
		assertFalse(validator.isValid("1234"));
	}
}
