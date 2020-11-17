package baseball.model;

import baseball.controller.dto.GuessFeedbackResponse;
import baseball.controller.dto.GuessNumberRequest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameServiceTest {

	@Test
	void ofRandom() {
		// given
		BaseballGameService baseballGameService = BaseballGameService.ofRandom();

		// when
		List<Integer> result = baseballGameService.getComputerNumber();

		// then
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
	void ofGiven() {
		// given
		List<Integer> computerNumber = Arrays.asList(1, 2, 3);
		BaseballGameService baseballGameService = BaseballGameService.ofGiven(computerNumber);

		// when
		List<Integer> result = baseballGameService.getComputerNumber();

		// then
		assertEquals(3, result.size());

		assertEquals(computerNumber.get(0), result.get(0));
		assertEquals(computerNumber.get(1), result.get(1));
		assertEquals(computerNumber.get(2), result.get(2));
	}

	@Test
	void guessNumberStrike() {
		// given
		List<Integer> computerNumber = Arrays.asList(1, 2, 3);
		BaseballGameService baseballGameService = BaseballGameService.ofGiven(computerNumber);

		// when
		List<Integer> userGuessNumber = Arrays.asList(1, 2, 3);
		GuessNumberRequest request = new GuessNumberRequest(userGuessNumber);
		GuessFeedbackResponse response = baseballGameService.guessNumber(request);

		// then
		assertEquals(3, response.getNumStrike());
		assertEquals(0, response.getNumBall());
	}

	@Test
	void guessNumberBall() {
		// given
		List<Integer> computerNumber = Arrays.asList(1, 2, 3);
		BaseballGameService baseballGameService = BaseballGameService.ofGiven(computerNumber);

		// when
		List<Integer> userGuessNumber = Arrays.asList(3, 1, 2);
		GuessNumberRequest request = new GuessNumberRequest(userGuessNumber);
		GuessFeedbackResponse response = baseballGameService.guessNumber(request);

		// then
		assertEquals(3, response.getNumBall());
		assertEquals(0, response.getNumStrike());
	}

	@Test
	void guessNumberNothing() {
		// given
		List<Integer> computerNumber = Arrays.asList(1, 2, 3);
		BaseballGameService baseballGameService = BaseballGameService.ofGiven(computerNumber);

		// when
		List<Integer> userGuessNumber = Arrays.asList(4, 5, 6);
		GuessNumberRequest request = new GuessNumberRequest(userGuessNumber);
		GuessFeedbackResponse response = baseballGameService.guessNumber(request);

		// then
		assertEquals(0, response.getNumBall());
		assertEquals(0, response.getNumStrike());
	}

	@Test
	void hasCorrectGuess() {
		// given
		List<Integer> computerNumber = Arrays.asList(1, 2, 3);
		BaseballGameService baseballGameService = BaseballGameService.ofGiven(computerNumber);

		/* wrong guess */

		// when
		List<Integer> wrongGuessNumber = Arrays.asList(4, 5, 6);
		GuessNumberRequest requestWrong = new GuessNumberRequest(wrongGuessNumber);
		baseballGameService.guessNumber(requestWrong);

		// then
		assertFalse(baseballGameService.hasCorrectGuess());

		/* correct guess */

		// when
		List<Integer> correctGuessNumber = Arrays.asList(1, 2, 3);
		GuessNumberRequest requestCorrect = new GuessNumberRequest(correctGuessNumber);
		baseballGameService.guessNumber(requestCorrect);

		// then
		assertTrue(baseballGameService.hasCorrectGuess());
	}
}