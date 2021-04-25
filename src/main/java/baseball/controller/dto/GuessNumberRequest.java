package baseball.controller.dto;

import java.util.List;

public class GuessNumberRequest {
	private List<Integer> guessNumbers;

	public GuessNumberRequest(List<Integer> guessNumbers) {
		this.guessNumbers = guessNumbers;
	}

	public List<Integer> getGuessNumbers() {
		return guessNumbers;
	}
}
