package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameServiceTest {

	@Test
	void ofRandom() {
		BaseballGameService baseballGameService = BaseballGameService.ofRandom();

		List<Integer> result = baseballGameService.getComputerNumber();

		assertEquals(3, result.size());
		for (int i = 0; i < 3; i++) {
			assertTrue(result.get(0) >= 1);
			assertTrue(result.get(0) <= 9);
		}
		assertNotEquals(result.get(0), result.get(1));
		assertNotEquals(result.get(0), result.get(2));
		assertNotEquals(result.get(1), result.get(2));
	}

	@Test
	void guessNumber() {
	}

	@Test
	void hasCorrectGuess() {
	}

}