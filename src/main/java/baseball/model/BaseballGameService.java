package baseball.model;

import baseball.controller.dto.GuessFeedbackResponse;
import baseball.controller.dto.GuessNumberRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballGameService {

	private static int NUMBER_OF_GUESS_NUMBER = 3;

	private List<Integer> computerNumber;

	private BaseballGameService(List<Integer> computerNumber) {
		this.computerNumber = computerNumber;
	}

	public static BaseballGameService ofRandom() {
		List<Integer> computerNumber = getRandomComputerNumber();
		return new BaseballGameService(computerNumber);
	}

	private static List<Integer> getRandomComputerNumber() {
		List<Integer> numberSet = getRandomNumberList();

		List<Integer> computerNumber = new ArrayList<>();
		for (int i = 0; i < NUMBER_OF_GUESS_NUMBER; i++) {
			computerNumber.add(numberSet.get(i));
		}

		return computerNumber;
	}

	private static List<Integer> getRandomNumberList() {
		List<Integer> numberSet = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			numberSet.add(i);
		}
		Collections.shuffle(numberSet);
		return numberSet;
	}

	public GuessFeedbackResponse guessNumber(GuessNumberRequest request) {
		return null;
	}

	public boolean hasCorrectGuess() {
		return true;
	}

	public List<Integer> getComputerNumber() {
		return computerNumber;
	}
}
