package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballServiceTest {

	private BaseballService baseballService;

	@BeforeEach
	void initBaseballService() {
		baseballService = new BaseballService();
	}

	@DisplayName("입력받은스코어사이즈체크")
	@Test
	void isValidInputScore() {
		String inputScore = "123";
		assertTrue(baseballService.isValidInputScore(inputScore));

		String invalidInputScore = "123456";
		assertFalse(baseballService.isValidInputScore(invalidInputScore));
	}
}
