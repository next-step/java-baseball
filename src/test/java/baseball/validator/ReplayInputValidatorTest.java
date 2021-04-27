package baseball.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ReplayInputValidatorTest {
	private final ReplayInputValidator validator = new ReplayInputValidator();

	@Test
	public void isValid_One_ShouldReturnTrue() {
		assertTrue(validator.isValid(1));
	}

	@Test
	public void isValid_Two_ShouldReturnTrue() {
		assertTrue(validator.isValid(2));
	}

	@Test
	public void isValid_NotOneAndTwo_ShouldReturnFalse() {
		assertFalse(validator.isValid(3));
	}
}
