package baseball;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class BaseballApplicationTest {

	@Test
	void allow_3_digit_number() {
		assertTrue(BaseballApplication.validate("123"));
		assertFalse(BaseballApplication.validate("1d3"));
		assertFalse(BaseballApplication.validate("123123"));
	}

	@Test
	void allow_3_digit_number_by_random() {
		BaseballApplication baseball = new BaseballApplication();
		assertTrue(BaseballApplication.validate(baseball.generateRandomNumber()));
	}
}
