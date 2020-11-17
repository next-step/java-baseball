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
	void ofGiven() {
		List<Integer> computerNumber = Arrays.asList(1, 2, 3);
		BaseballGameService baseballGameService = BaseballGameService.ofGiven(computerNumber);

		List<Integer> result = baseballGameService.getComputerNumber();

		assertEquals(3, result.size());
		assertEquals(computerNumber.get(0), result.get(0));
		assertEquals(computerNumber.get(1), result.get(1));
		assertEquals(computerNumber.get(2), result.get(2));
	}

	@Test
	void guessNumberStrike() {
		List<Integer> computerNumber = Arrays.asList(1, 2, 3);
		BaseballGameService baseballGameService = BaseballGameService.ofGiven(computerNumber);

		List<Integer> userGuessNumber = Arrays.asList(1, 2, 3);
		GuessNumberRequest request = new GuessNumberRequest(userGuessNumber);

		GuessFeedbackResponse response = baseballGameService.guessNumber(request);
		assertEquals(3, response.getNumStrike());
		assertEquals(0, response.getNumBall());
	}

	@Test
	void guessNumberBall() {
		List<Integer> computerNumber = Arrays.asList(1, 2, 3);
		BaseballGameService baseballGameService = BaseballGameService.ofGiven(computerNumber);

		List<Integer> userGuessNumber = Arrays.asList(3, 1, 2);
		GuessNumberRequest request = new GuessNumberRequest(userGuessNumber);

		GuessFeedbackResponse response = baseballGameService.guessNumber(request);
		assertEquals(3, response.getNumBall());
		assertEquals(0, response.getNumStrike());
	}

	@Test
	void guessNumberNothing() {
		List<Integer> computerNumber = Arrays.asList(1, 2, 3);
		BaseballGameService baseballGameService = BaseballGameService.ofGiven(computerNumber);

		List<Integer> userGuessNumber = Arrays.asList(4, 5, 6);
		GuessNumberRequest request = new GuessNumberRequest(userGuessNumber);

		GuessFeedbackResponse response = baseballGameService.guessNumber(request);
		assertEquals(0, response.getNumBall());
		assertEquals(0, response.getNumStrike());
	}

	@Test
	void hasCorrectGuess() {
		List<Integer> computerNumber = Arrays.asList(1, 2, 3);
		BaseballGameService baseballGameService = BaseballGameService.ofGiven(computerNumber);

		List<Integer> wrongGuessNumber = Arrays.asList(4, 5, 6);
		GuessNumberRequest requestWrong = new GuessNumberRequest(wrongGuessNumber);

		List<Integer> correctGuessNumber = Arrays.asList(1, 2, 3);
		GuessNumberRequest requestCorrect = new GuessNumberRequest(correctGuessNumber);

		baseballGameService.guessNumber(requestWrong);
		assertFalse(baseballGameService.hasCorrectGuess());

		baseballGameService.guessNumber(requestCorrect);
		assertTrue(baseballGameService.hasCorrectGuess());
	}
}