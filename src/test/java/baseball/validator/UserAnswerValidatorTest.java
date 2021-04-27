package baseball.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserAnswerValidatorTest {
	private final UserAnswerValidator validator = new UserAnswerValidator();

	@Test
	public void isValid_NonDupThreeNumbersParameter_ShouldReturnTrue() {
		assertTrue(validator.isValid("123"));
	}

	@Test
	public void isValid_DupParameter_ShouldReturnFalse() {
		assertFalse(validator.isValid("111"));
	}

	@Test
	public void isValid_FourLengthParameter_ShouldReturnFalse() {
		assertFalse(validator.isValid("1234"));
	}
}
