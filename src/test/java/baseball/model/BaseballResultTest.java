package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseballResultTest {

	@Test
	void isAnswer_StrikeCountIsNotSameAsAnswerSize_ShouldReturnFalse() {
		BaseballResult result = new BaseballResult(2, 0);
		assertFalse(result.isAnswer());
	}

	@Test
	void isAnswer_StrikeCountIsSameAsAnswerSize_ShouldReturnTrue() {
		BaseballResult result = new BaseballResult(3, 0);
		assertTrue(result.isAnswer());
	}
}
