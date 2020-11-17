package baseball.model;

import baseball.controller.dto.GuessFeedbackResponse;
import baseball.controller.dto.GuessNumberRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballGameService {

	private static int NUMBER_OF_GUESS_NUMBER = 3;

	private List<Integer> computerNumber;
	private boolean isUserGuessCorrect;

	private BaseballGameService(List<Integer> computerNumber) {
		this.computerNumber = computerNumber;
		isUserGuessCorrect = false;
	}

	public static BaseballGameService ofGiven(List<Integer> computerNumber) {
		return new BaseballGameService(computerNumber);
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
		List<Integer> userGuessNumber = request.getGuessNumbers();

		int numStrike = countStrike(userGuessNumber);
		int numBall = countBall(userGuessNumber);

		setIsUserGuessCorrect(numStrike);

		return new GuessFeedbackResponse(numStrike, numBall);
	}

	private void setIsUserGuessCorrect(int numStrike) {
		if (numStrike == NUMBER_OF_GUESS_NUMBER) {
			isUserGuessCorrect = true;
		}
	}

	private int countStrike(List<Integer> userGuessNumber) {
		int numStrike = 0;

		for (int i = 0; i < NUMBER_OF_GUESS_NUMBER; i++) {
			numStrike += addToStrikeCount(userGuessNumber.get(i), i);
		}

		return numStrike;
	}

	private int addToStrikeCount(int userGuessNumber, int position) {
		if (computerNumber.get(position) == userGuessNumber) {
			return 1;
		}
		return 0;
	}

	private int countBall(List<Integer> userGuessNumber) {
		int numBall = 0;

		for (int i = 0; i < NUMBER_OF_GUESS_NUMBER; i++) {
			numBall += addToBallCount(userGuessNumber.get(i), i);
		}

		return numBall;
	}

	private int addToBallCount(int userGuessNumber, int position) {
		if (computerNumber.get(position) != userGuessNumber && computerNumber.contains(userGuessNumber)) {
			return 1;
		}
		return 0;
	}

	public boolean hasCorrectGuess() {
		return isUserGuessCorrect;
	}

	public List<Integer> getComputerNumber() {
		return computerNumber;
	}
}
